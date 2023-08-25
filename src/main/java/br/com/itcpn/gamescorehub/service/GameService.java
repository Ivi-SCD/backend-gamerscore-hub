package br.com.itcpn.gamescorehub.service;

import br.com.itcpn.gamescorehub.dto.GameDTO;
import br.com.itcpn.gamescorehub.dto.GameForSaveDTO;
import br.com.itcpn.gamescorehub.model.Game;
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

    public GameDTO getGameById(Long id) {
        Game game = gameRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(game, GameDTO.class);
    }

    public List<GameDTO> getAllGames() {
        List<Game> games = gameRepository.findAll();
        return games.stream()
                .map(game -> modelMapper.map(game, GameDTO.class))
                .toList();
    }

    public List<GameDTO> getAllGames(Pageable pagination) {
        return gameRepository.findAll(pagination)
                .map(game -> modelMapper.map(game, GameDTO.class))
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

    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }

    public List<GameDTO> findGamesByname (String name) {
        return gameRepository.findAllLikeName(name)
                .stream()
                .map(game -> modelMapper.map(game, GameDTO.class))
                .toList();
    }

    public List<GameDTO> getAllGamesByYear(int year) {
        return gameRepository.findGamesByYear(year)
                .stream()
                .map((game) -> modelMapper.map(game, GameDTO.class))
                .toList();
    }
}
