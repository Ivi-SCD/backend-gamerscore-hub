package br.com.itcpn.gamescorehub.openapi;

import br.com.itcpn.gamescorehub.domain.user.dto.LoginDTO;
import br.com.itcpn.gamescorehub.domain.user.dto.LoginResponseDTO;
import br.com.itcpn.gamescorehub.domain.user.dto.RegisterDTO;
import br.com.itcpn.gamescorehub.exception.dto.ErrorResponseSimpleCause;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import br.com.itcpn.gamescorehub.exception.dto.ErrorResponse;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Users")
public interface AuthControllerOpenAPI {
    @Operation(summary = "User login action")
    @ApiResponse(responseCode = "200", description = "User logged in", content = @Content(
            schema = @Schema(implementation = LoginResponseDTO.class)

    ))
    @ApiResponse(responseCode = "400", description = "User inexistent or wrong password", content = @Content
            (schema = @Schema(implementation = ErrorResponse.class)))
    ResponseEntity<Object> login(@RequestBody @Valid LoginDTO loginDTO);
    @Operation(summary = "User register action",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "User object to register"
            , content = @Content(examples = {
                    @ExampleObject(
                            name = "User example",
                            value = "{\n" +
                                    "  \"name\": \"string\",\n" +
                                    "  \"email\": \"string\",\n" +
                                    "  \"password\": \"string\"\n" +
                                    "}")
            })))
    @ApiResponse(responseCode = "201", description = "User successful registered")
    @ApiResponse(responseCode = "400", description = "Invalid request (Validation Exception) ", content = @Content
            (schema = @Schema(implementation = ErrorResponse.class)))
    @ApiResponse(responseCode = "409", description = "User email or nickname already in use", content = @Content
            (schema = @Schema(implementation = ErrorResponseSimpleCause.class)))
   ResponseEntity<Object> register(@RequestBody @Valid RegisterDTO registerDTO);
}