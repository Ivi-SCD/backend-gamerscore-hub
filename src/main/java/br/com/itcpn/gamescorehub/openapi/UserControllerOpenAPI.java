package br.com.itcpn.gamescorehub.openapi;

import br.com.itcpn.gamescorehub.domain.user.dto.UserResponseDTO;
import br.com.itcpn.gamescorehub.exception.dto.ErrorResponseSimpleCause;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Users")
public interface UserControllerOpenAPI {

    @Operation(summary = "User delete by id value")
    @SecurityRequirement(name = "bearer-key")
    @ApiResponse(responseCode = "403", description = "User not authorized", content = @Content)
    @ApiResponse(responseCode = "204", description = "User deleted", content = @Content)
    @ApiResponse(responseCode = "404", description = "User not found",
            content = @Content(schema = @Schema(implementation = ErrorResponseSimpleCause.class)))
    ResponseEntity<Object> deleteUserById(@PathVariable Long id);
    @Operation(summary = "User update by id value")
    @ApiResponse(responseCode = "200", description = "User updated")
    @ApiResponse(responseCode = "400", description = "Nickname or email already in use", content = @Content(
            schema = @Schema(implementation = ErrorResponseSimpleCause.class)
    ))
    @ApiResponse(responseCode = "403", description = "User not authorized", content = @Content)
    @SecurityRequirement(name = "bearer-key")
    ResponseEntity<Object> updateUserById(@RequestBody UserResponseDTO userDTO, HttpServletRequest request) throws IllegalAccessException;
    @Operation(summary = "User find by id value")
    @SecurityRequirement(name = "bearer-key")
    @ApiResponse(responseCode = "200", description = "User found", content =
    @Content(schema = @Schema(implementation = UserResponseDTO.class)))
    @ApiResponse(responseCode = "403", description = "User not authorized", content = @Content)
    @ApiResponse(responseCode = "404", description = "User not found",
    content = @Content(schema = @Schema(implementation = ErrorResponseSimpleCause.class)))
    UserResponseDTO findUserById(@PathVariable Long id);
}
