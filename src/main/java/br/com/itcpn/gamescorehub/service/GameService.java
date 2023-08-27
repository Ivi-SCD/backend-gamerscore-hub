package br.com.itcpn.gamescorehub.service;

import br.com.itcpn.gamescorehub.domain.game.Game;
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

    public Game.GameDTO getGameById(Long id) {
        Game game = gameRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(game, Game.GameDTO.class);
    }

    public List<Game.GameDTO> getAllGames() {
        List<Game> games = gameRepository.findAll();
        return games.stream()
                .map(game -> modelMapper.map(game, Game.GameDTO.class))
                .toList();
    }

    public List<Game.GameDTO> getAllGames(Pageable pagination) {
        return gameRepository.findAll(pagination)
                .map(game -> modelMapper.map(game, Game.GameDTO.class))
                .toList();
    }

    public Game.GameDTO updateGame(Long id, Game.GameDTO gameDTO) {
        Game game = modelMapper.map(gameDTO, Game.class);
        game.setId(id);
        game = gameRepository.save(game);
        return modelMapper.map(game, Game.GameDTO.class);
    }

    public Game.GameForSaveDTO saveGame(Game.GameDTO gameDTO) {
        Game game = modelMapper.map(gameDTO, Game.class);
        game = gameRepository.save(game);
        return modelMapper.map(game, Game.GameForSaveDTO.class);
    }

    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }

    public List<Game.GameDTO> findGamesByname (String name) {
        return gameRepository.findAllLikeName(name)
                .stream()
                .map(game -> modelMapper.map(game, Game.GameDTO.class))
                .toList();
    }

    public List<Game.GameDTO> getAllGamesByYear(int year) {
        return gameRepository.findGamesByYear(year)
                .stream()
                .map((game) -> modelMapper.map(game, Game.GameDTO.class))
                .toList();
    }
}
