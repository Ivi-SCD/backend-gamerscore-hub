package br.com.itcpn.gamescorehub.openapi;

import br.com.itcpn.gamescorehub.domain.publicnote.dto.PublicNoteDTO;
import br.com.itcpn.gamescorehub.domain.user.dto.LoginResponseDTO;
import br.com.itcpn.gamescorehub.exception.dto.ErrorResponseSimpleCause;
import br.com.itcpn.gamescorehub.exception.dto.ErrorResponseSpecificCause;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Users")
public interface PublicNoteControllerOpenAPI {

    @SecurityRequirement(name="bearer-key")
    @ApiResponse(responseCode = "400", description = "One or more credentials missing", content =
    @Content(schema = @Schema(implementation = ErrorResponseSpecificCause.class)))
    @ApiResponse(responseCode = "404", description = "Game not found", content = @Content
            (schema = @Schema(implementation = ErrorResponseSimpleCause.class)))
    @ApiResponse(responseCode = "200", description = "Public note added to user", content = @Content
            (schema = @Schema(implementation = LoginResponseDTO.class)))
    @Operation(summary = "Add a public note to a user")
    ResponseEntity<Object> updatePublicNote(@RequestBody @Valid PublicNoteDTO publicNoteDTO, HttpServletRequest request);

}
