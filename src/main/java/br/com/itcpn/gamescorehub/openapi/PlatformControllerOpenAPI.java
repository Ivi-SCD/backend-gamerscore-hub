package br.com.itcpn.gamescorehub.openapi;

import br.com.itcpn.gamescorehub.domain.platform.dto.PlatformDTO;
import br.com.itcpn.gamescorehub.domain.platform.dto.PlatformResponseDTO;
import br.com.itcpn.gamescorehub.exception.dto.ErrorResponseSimpleCause;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Platforms")
public interface PlatformControllerOpenAPI {
    @Operation(summary = "List all platforms")
    @ApiResponse(responseCode = "200", description = "List of all platforms successfully returned",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = PlatformResponseDTO.class))))
    @ApiResponse(responseCode = "403", description = "Access denied or token error",
            content = @Content)
    List<PlatformResponseDTO> listAllPlatforms();
    @Operation(summary = "Save a new platform")
    @ApiResponse(responseCode = "201", description = "Platform created",
            content = @Content(schema = @Schema(implementation = PlatformResponseDTO.class)))
    @ApiResponse(responseCode = "400", description = "Invalid Request, Review the fields or if the platform already exists",
            content = @Content(schema = @Schema(implementation = ErrorResponseSimpleCause.class)))
    @ApiResponse(responseCode = "403", description = "Access denied or token error",
            content = @Content)
    ResponseEntity<PlatformDTO> savePlatform(@RequestBody @Valid PlatformDTO platformDTO);
}
