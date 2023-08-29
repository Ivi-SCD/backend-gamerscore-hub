package br.com.itcpn.gamescorehub.service;

import br.com.itcpn.gamescorehub.domain.game.Game;
import br.com.itcpn.gamescorehub.domain.game.dto.GameDTO;
import br.com.itcpn.gamescorehub.domain.game.dto.GameForSaveDTO;
import br.com.itcpn.gamescorehub.repository.GameRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private ModelMapper modelMapper;

    public GameDTO findGameById(Long id) {
        Game game = gameRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(game, GameDTO.class);
    }

    public List<GameDTO> findAllGames() {
        List<Game> games = gameRepository.findAll();
        return games.stream()
                .map(game -> modelMapper.map(game, GameDTO.class))
                .toList();
    }

    public List<GameDTO> findAllGames(Pageable pagination) {
        return gameRepository.findAll(pagination)
                .map(game -> modelMapper.map(game, GameDTO.class))
                .toList();
    }

    public List<GameDTO> findGamesLikeName (String name) {
        return gameRepository.findAllLikeName(name)
                .stream()
                .map(game -> modelMapper.map(game, GameDTO.class))
                .toList();
    }

    public List<GameDTO> findAllGamesByYear(int year) {
        return gameRepository.findGamesByYear(year)
                .stream()
                .map((game) -> modelMapper.map(game, GameDTO.class))
                .toList();
    }

    public List<GameDTO> findAllGamesByAge(String ageClassification) {
        return gameRepository.findGamesByAge(ageClassification)
                .stream()
                .map((game) -> modelMapper.map(game, GameDTO.class))
                .toList();
    }

    public List<GameDTO> findAllGamesOrderByCriticsNote() {
        return gameRepository.findAllGamesOrderByCriticsNote()
                .stream()
                .map((game) -> modelMapper.map(game, GameDTO.class))
                .toList();
    }

    public List<GameDTO> findAllGamesOrderByYear() {
        return gameRepository.findAllGamesOrderByYear()
                .stream()
                .map((game) -> modelMapper.map(game, GameDTO.class))
                .toList();
    }

    public GameDTO updateGame(Long id, GameDTO gameDTO) {
        Game game = modelMapper.map(gameDTO, Game.class);
        game.setId(id);
        game = gameRepository.save(game);
        return modelMapper.map(game, GameDTO.class);
    }

    public GameForSaveDTO saveGame(GameDTO gameDTO) {
        Game game = modelMapper.map(gameDTO, Game.class);
        game = gameRepository.save(game);
        return modelMapper.map(game, GameForSaveDTO.class);
    }

    public Game findByName(String gameName) {
        return gameRepository.findByName(gameName);
    }
}
