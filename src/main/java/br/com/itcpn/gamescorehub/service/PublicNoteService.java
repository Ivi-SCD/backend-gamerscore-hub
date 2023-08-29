package br.com.itcpn.gamescorehub.service;

import br.com.itcpn.gamescorehub.domain.game.Game;
import br.com.itcpn.gamescorehub.domain.publicnote.PublicNote;
import br.com.itcpn.gamescorehub.domain.publicnote.dto.PublicNoteDTO;
import br.com.itcpn.gamescorehub.domain.user.User;
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

    public void saveNote(PublicNoteDTO publicNoteDTO, User user) {

        Game game = gameService.findByName(publicNoteDTO.getGameName());
        PublicNote publicNote = modelMapper.map(publicNoteDTO, PublicNote.class);

        publicNote.setGame(game);
        publicNote.setUser(user);

        publicNoteRepository.save(publicNote);

        double note = game.getPublicNotesList()
                .stream().mapToDouble(x -> (double) (x.getNarrative()
                        + x.getSoundtrack()
                        + x.getGameplay()
                        + x.getAnimation()) /4).average().orElse(0.0);

        game.setPublicNote(String.valueOf(note));

    }

}
