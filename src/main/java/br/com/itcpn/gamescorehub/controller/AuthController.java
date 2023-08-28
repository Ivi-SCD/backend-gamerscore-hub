package br.com.itcpn.gamescorehub.controller;

import br.com.itcpn.gamescorehub.domain.user.User;
import br.com.itcpn.gamescorehub.domain.user.dto.AuthenticatorDTO;
import br.com.itcpn.gamescorehub.domain.user.dto.LoginResponseDTO;
import br.com.itcpn.gamescorehub.domain.user.dto.RegisterDTO;
import br.com.itcpn.gamescorehub.service.AuthorizationService;
import br.com.itcpn.gamescorehub.service.TokenService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid AuthenticatorDTO authenticatorDTO) {

        var userEmailPass = new UsernamePasswordAuthenticationToken(authenticatorDTO.email(), authenticatorDTO.password());
        var auth = authenticationManager.authenticate(userEmailPass);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    @Transactional
    public ResponseEntity<Object> register(@RequestBody @Valid RegisterDTO registerDTO) {

        HttpStatus status = authorizationService.validateUser(registerDTO);

        if(status == HttpStatus.OK) {
            String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.getPassword());

            registerDTO.setPassword(encryptedPassword);
            User user = authorizationService.saveUser(registerDTO);

            return ResponseEntity.created(URI.create("/user/" + user.getId())).build();

        }
        return ResponseEntity.badRequest().build();

    }
}