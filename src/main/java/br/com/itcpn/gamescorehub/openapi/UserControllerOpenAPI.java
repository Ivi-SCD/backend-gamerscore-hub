package br.com.itcpn.gamescorehub.openapi;

import br.com.itcpn.gamescorehub.domain.user.dto.UserResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Users")
public interface UserControllerOpenAPI {

    @Operation(summary = "User delete by id value")
    @SecurityRequirement(name = "bearer-key")
    ResponseEntity<Object> deleteUserById(@PathVariable Long id);
    @Operation(summary = "User update by id value")
    @SecurityRequirement(name = "bearer-key")
    ResponseEntity<Object> updateUserById(@PathVariable Long id, @RequestBody UserResponseDTO user);
    @Operation(summary = "User find by id value")
    UserResponseDTO findGameById(@PathVariable Long id);
}
