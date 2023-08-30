package br.com.itcpn.gamescorehub.service;

import br.com.itcpn.gamescorehub.domain.game.Game;
import br.com.itcpn.gamescorehub.domain.game.dto.GameDTO;
import br.com.itcpn.gamescorehub.domain.game.dto.GameForSaveDTO;
import br.com.itcpn.gamescorehub.domain.game.dto.GameResponseDTO;
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

    public GameResponseDTO findGameById(Long id) {
        Game game = gameRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(game, GameResponseDTO.class);
    }

    public List<GameResponseDTO> findAllGames() {
        List<Game> games = gameRepository.findAll();
        return games.stream()
                .map(game -> modelMapper.map(game, GameResponseDTO.class))
                .toList();
    }

    public List<GameResponseDTO> findAllGames(Pageable pagination) {
        return gameRepository.findAll(pagination)
                .map(game -> modelMapper.map(game, GameResponseDTO.class))
                .toList();
    }

    public List<GameResponseDTO> findGamesLikeName (String name) {
        return gameRepository.findAllLikeName(name)
                .stream()
                .map(game -> modelMapper.map(game, GameResponseDTO.class))
                .toList();
    }

    public List<GameResponseDTO> findAllGamesByYear(int year) {
        return gameRepository.findGamesByYear(year)
                .stream()
                .map((game) -> modelMapper.map(game, GameResponseDTO.class))
                .toList();
    }

    public List<GameResponseDTO> findAllGamesByAge(String ageClassification) {
        return gameRepository.findGamesByAge(ageClassification)
                .stream()
                .map((game) -> modelMapper.map(game, GameResponseDTO.class))
                .toList();
    }

    public List<GameResponseDTO> findAllGamesOrderByCriticsNote() {
        return gameRepository.findAllGamesOrderByCriticsNote()
                .stream()
                .map((game) -> modelMapper.map(game, GameResponseDTO.class))
                .toList();
    }

    public List<GameResponseDTO> findAllGamesOrderByYear() {
        return gameRepository.findAllGamesOrderByYear()
                .stream()
                .map((game) -> modelMapper.map(game, GameResponseDTO.class))
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

    public Double calculateNote(Game game) {
        return game.getPublicNotesList()
                .stream().mapToDouble(x -> (double) (x.getNarrative()
                        + x.getSoundtrack()
                        + x.getGameplay()
                        + x.getAnimation()) /4).average().orElse(0.0);
    }
}
