package br.com.itcpn.gamescorehub.controller;

import br.com.itcpn.gamescorehub.domain.user.User;
import br.com.itcpn.gamescorehub.domain.user.dto.UserResponseDTO;
import br.com.itcpn.gamescorehub.openapi.UserControllerOpenAPI;
import br.com.itcpn.gamescorehub.service.SecurityService;
import br.com.itcpn.gamescorehub.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController implements UserControllerOpenAPI {

    @Autowired
    private UserService userService;
    @Autowired
    private SecurityService securityService;

    @GetMapping("{id}")
    public UserResponseDTO findUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Object> updateUserById(@RequestBody UserResponseDTO userDTO, HttpServletRequest request) throws IllegalAccessException {
        String token = request.getHeader("Authorization");
        User user = securityService.authorize(token);
        UserResponseDTO userUpdated = userService.updateUser(user.getId(), userDTO);
        return ResponseEntity.ok(userUpdated);
    }
}
