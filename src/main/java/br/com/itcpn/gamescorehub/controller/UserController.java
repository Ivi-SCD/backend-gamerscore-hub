package br.com.itcpn.gamescorehub.controller;

import br.com.itcpn.gamescorehub.domain.user.dto.UserResponseDTO;
import br.com.itcpn.gamescorehub.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public UserResponseDTO findGameById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("{id}")
    @SecurityRequirement(name="bearer-key")
    public ResponseEntity<Object> deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    @Transactional
    @SecurityRequirement(name="bearer-key")
    public ResponseEntity<Object> updateUserById(@PathVariable Long id, @RequestBody UserResponseDTO user) {
        userService.updateUser(id, user);
        return ResponseEntity.ok().build();
    }
}
