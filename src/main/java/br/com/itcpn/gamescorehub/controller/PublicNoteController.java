package br.com.itcpn.gamescorehub.controller;

import br.com.itcpn.gamescorehub.domain.publicnote.dto.PublicNoteDTO;
import br.com.itcpn.gamescorehub.domain.user.User;
import br.com.itcpn.gamescorehub.service.PublicNoteService;
import br.com.itcpn.gamescorehub.service.TokenService;
import br.com.itcpn.gamescorehub.service.UserService;
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
public class PublicNoteController {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserService userService;
    @Autowired
    private PublicNoteService publicNoteService;


    @PutMapping
    @Transactional
    public ResponseEntity<Object> updatePublicNote(@RequestBody @Valid PublicNoteDTO publicNoteDTO, HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        if(token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);

            String email = tokenService.validateToken(token);
            User user = userService.findByEmail(email);

            publicNoteService.saveNote(publicNoteDTO, user);
            return ResponseEntity.ok().body("Public note added to user");
        }

        return ResponseEntity.badRequest().build();

    }
}
