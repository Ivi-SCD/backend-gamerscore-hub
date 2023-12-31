package br.com.itcpn.gamescorehub.controller;

import br.com.itcpn.gamescorehub.domain.game.dto.GameDTO;
import br.com.itcpn.gamescorehub.domain.game.dto.GameForSaveDTO;
import br.com.itcpn.gamescorehub.domain.game.dto.GameForUpdateDTO;
import br.com.itcpn.gamescorehub.domain.game.dto.GameResponseDTO;
import br.com.itcpn.gamescorehub.openapi.GameControllerOpenAPI;
import br.com.itcpn.gamescorehub.service.GameService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController implements GameControllerOpenAPI {

    @Autowired
    private GameService gameService;


    @GetMapping
    public List<GameResponseDTO> listAllGames() {
        return gameService.findAllGames();
    }

    @GetMapping("year/{year}")
    public List<GameResponseDTO> listAllGamesByYear(@PathVariable int year) {
        return gameService.findAllGamesByYear(year);
    }

    @GetMapping("pagination/{size}")
    public List<GameResponseDTO> listAllGames(
            @PageableDefault(size = 20) Pageable pageable,
            @PathVariable int size) {

        pageable = PageRequest.of(pageable.getPageNumber(), size, pageable.getSort());

        return gameService.findAllGames(pageable);
    }

    @GetMapping("name/{name}")
    public List<GameResponseDTO> listAllGamesByName(@PathVariable String name) {
        return gameService.findGamesLikeName(name);
    }

    @GetMapping("classification/{age}")
    public List<GameResponseDTO> listAllGamesByAgeClassification(@PathVariable String age) {
        return gameService.findAllGamesByAge(age);
    }

    @GetMapping("order/publicnote")
    public List<GameResponseDTO> listAllGamesByPublicNotes() {
        return gameService.findAllGamesOrderByPublicNote();
    }
    @GetMapping("order/critics")
    public List<GameResponseDTO> listAllGamesByCriticsNotes() {
        return gameService.findAllGamesOrderByCriticsNote();
    }

    @GetMapping("order/release")
    public List<GameResponseDTO> listAllGamesByYear() {
        return gameService.findAllGamesOrderByYear();
    }

    @GetMapping("{id}")
    public GameResponseDTO findGameById(@PathVariable Long id) {
        return gameService.getGameById(id);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<GameForSaveDTO> saveGame(@RequestBody @Valid GameDTO GameDTO) {
        GameForSaveDTO game = gameService.saveGame(GameDTO);

        return ResponseEntity.created(URI.create("/games/" + game.getId())).body(game);
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<GameResponseDTO> updateGame(@PathVariable Long id, @RequestBody GameForUpdateDTO gameDTO) throws IllegalAccessException {
        GameResponseDTO gameUpdated = gameService.updateGame(id, gameDTO);
        return ResponseEntity.ok(gameUpdated);
    }

}
