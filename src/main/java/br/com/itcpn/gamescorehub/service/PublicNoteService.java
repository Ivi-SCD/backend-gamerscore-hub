package br.com.itcpn.gamescorehub.service;

import br.com.itcpn.gamescorehub.domain.game.Game;
import br.com.itcpn.gamescorehub.domain.publicnote.PublicNote;
import br.com.itcpn.gamescorehub.domain.publicnote.dto.PublicNoteDTO;
import br.com.itcpn.gamescorehub.domain.publicnote.dto.PublicNoteOnlyNotesDTO;
import br.com.itcpn.gamescorehub.domain.user.User;
import br.com.itcpn.gamescorehub.exception.user.UserAlreadyHasPublicNoteOnGameException;
import br.com.itcpn.gamescorehub.repository.GameRepository;
import br.com.itcpn.gamescorehub.repository.PublicNoteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicNoteService {

    @Autowired
    private PublicNoteRepository publicNoteRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private GameService gameService;
    @Autowired
    private GameRepository gameRepository;

    public void saveNote(PublicNoteDTO publicNoteDTO, User user) {
        Game game = gameService.findByName(publicNoteDTO.getGameName());

        if(verifyIfUserHasPublicNoteOnGame(user, game)) {
            throw new UserAlreadyHasPublicNoteOnGameException("User already has a note on this game");
        }

        PublicNoteOnlyNotesDTO publicNoteNotesDTO = modelMapper.map(publicNoteDTO, PublicNoteOnlyNotesDTO.class);
        PublicNote publicNote = modelMapper.map(publicNoteNotesDTO, PublicNote.class);

        publicNote.setGame(game);
        publicNote.setUser(user);

        publicNoteRepository.save(publicNote);

        Double note = gameService.calculateNote(game);
        game.setPublicNote(note);

        gameRepository.save(game);

    }

    private boolean verifyIfUserHasPublicNoteOnGame(User user, Game game) {
        return user.getPublicNotesList().stream().anyMatch(x -> x.getGame().equals(game));
    }

}
