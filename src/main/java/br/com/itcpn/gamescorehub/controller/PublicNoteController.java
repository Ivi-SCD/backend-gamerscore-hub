package br.com.itcpn.gamescorehub.controller;

import br.com.itcpn.gamescorehub.domain.publicnote.dto.PublicNoteDTO;
import br.com.itcpn.gamescorehub.domain.user.User;
import br.com.itcpn.gamescorehub.openapi.PublicNoteControllerOpenAPI;
import br.com.itcpn.gamescorehub.service.PublicNoteService;
import br.com.itcpn.gamescorehub.service.SecurityService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publicnotes")
public class PublicNoteController implements PublicNoteControllerOpenAPI {

    @Autowired
    private SecurityService securityService;
    @Autowired
    private PublicNoteService publicNoteService;
    @PutMapping
    @Transactional
    public ResponseEntity<Object> updatePublicNote(@RequestBody @Valid PublicNoteDTO publicNoteDTO, HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        User user = securityService.authorize(token);
        publicNoteService.saveNote(publicNoteDTO, user);
        return ResponseEntity.ok().body("Public note added to user");
    }
}
