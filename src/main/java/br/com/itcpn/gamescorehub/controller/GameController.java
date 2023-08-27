package br.com.itcpn.gamescorehub.controller;

import br.com.itcpn.gamescorehub.domain.game.Game;
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
public class GameController {

    @Autowired
    private GameService gameService;


    @GetMapping
    public List<Game.GameDTO> listAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("year/{year}")
    public List<Game.GameDTO> listAllGamesByYear(@PathVariable int year) {
        return gameService.getAllGamesByYear(year);
    }

    @GetMapping("{id}")
    public Game.GameDTO getGameById(@PathVariable Long id) {
        return gameService.getGameById(id);
    }

    @GetMapping("{size}")
    public List<Game.GameDTO> listAllGames(
            @PageableDefault(size = 20) Pageable pageable,
            @PathVariable int size) {

        pageable = PageRequest.of(pageable.getPageNumber(), size, pageable.getSort());

        return gameService.getAllGames(pageable);
    }

    @GetMapping("sort/{name}")
    public List<Game.GameDTO> findGamesByName(@PathVariable String name) {
        return gameService.findGamesByname(name);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Game.GameForSaveDTO> saveGame(@RequestBody @Valid Game.GameDTO GameDTO) {
        Game.GameForSaveDTO game = gameService.saveGame(GameDTO);

        return ResponseEntity.created(URI.create("/games/" + game.getId())).body(game);
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<Game.GameDTO> updateGame(@PathVariable Long id, @RequestBody @Valid Game.GameDTO gameDTO) {
        gameDTO = gameService.updateGame(id, gameDTO);
        return ResponseEntity.ok(gameDTO);
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Object> deleteGame(@PathVariable Long id) {
        gameService.deleteGame(id);
        return ResponseEntity.noContent().build();
    }
}
