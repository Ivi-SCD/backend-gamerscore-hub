package br.com.itcpn.gamescorehub.controller;

import br.com.itcpn.gamescorehub.domain.user.User;
import br.com.itcpn.gamescorehub.domain.user.dto.LoginDTO;
import br.com.itcpn.gamescorehub.domain.user.dto.LoginResponseDTO;
import br.com.itcpn.gamescorehub.domain.user.dto.RegisterDTO;
import br.com.itcpn.gamescorehub.service.SecurityService;
import br.com.itcpn.gamescorehub.service.TokenService;
import br.com.itcpn.gamescorehub.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
    private SecurityService securityService;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid LoginDTO loginDTO) {

        var userEmailPass = new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword());
        var auth = authenticationManager.authenticate(userEmailPass);
        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    @Transactional
    public ResponseEntity<Object> register(@RequestBody @Valid RegisterDTO registerDTO) {

        HttpStatus status = securityService.validateUser(registerDTO);

        if(status == HttpStatus.OK) {
            registerDTO.setPassword(securityService.ecryptPassword(registerDTO.getPassword()));
            User user = userService.saveUser(registerDTO);
            return ResponseEntity.created(URI.create("/user/" + user.getId())).build();
        }
        return ResponseEntity.badRequest().build();

    }
}