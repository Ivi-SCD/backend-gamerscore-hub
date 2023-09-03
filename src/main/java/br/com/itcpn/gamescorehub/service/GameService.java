package br.com.itcpn.gamescorehub.service;

import br.com.itcpn.gamescorehub.domain.game.Game;
import br.com.itcpn.gamescorehub.domain.game.dto.GameDTO;
import br.com.itcpn.gamescorehub.domain.game.dto.GameForSaveDTO;
import br.com.itcpn.gamescorehub.domain.game.dto.GameForUpdateDTO;
import br.com.itcpn.gamescorehub.domain.game.dto.GameResponseDTO;
import br.com.itcpn.gamescorehub.repository.GameRepository;
import br.com.itcpn.gamescorehub.util.NonNullFieldsReflection;
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

    public GameResponseDTO getGameById(Long id) {
        Game game = findGameById(id);
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

    public GameResponseDTO updateGame(Long id, GameForUpdateDTO gameDTO) throws IllegalAccessException {
        Game gameToUpdate = findGameById(id);
        NonNullFieldsReflection.setNonNullFields(gameDTO, gameToUpdate);

        return modelMapper.map(gameToUpdate, GameResponseDTO.class);
    }

    public GameForSaveDTO saveGame(GameDTO gameDTO) {
        Game game = modelMapper.map(gameDTO, Game.class);
        game = gameRepository.save(game);
        return modelMapper.map(game, GameForSaveDTO.class);
    }

    private Game findGameById(Long id) {
        return gameRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Game findByName(String gameName) {
        Game game = gameRepository.findByName(gameName);
        if(game == null)
            throw new EntityNotFoundException("Game not found");
        return game;
    }

    public Double calculateNote(Game game) {
        return game.getPublicNotesList()
                .stream().mapToDouble(x -> (double) (x.getNarrative()
                        + x.getSoundtrack()
                        + x.getGameplay()
                        + x.getAnimation()) /4).average().orElse(0.0);
    }

    public List<GameResponseDTO> findAllGamesOrderByPublicNote() {
        return gameRepository.findAllGamesOrderByPublicNote()
                .stream()
                .map((game) -> modelMapper.map(game, GameResponseDTO.class))
                .toList();
    }
}
