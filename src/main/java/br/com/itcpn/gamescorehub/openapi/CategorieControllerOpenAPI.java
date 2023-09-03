package br.com.itcpn.gamescorehub.openapi;

import br.com.itcpn.gamescorehub.domain.categorie.dto.CategorieDTO;
import br.com.itcpn.gamescorehub.domain.categorie.dto.CategorieResponseDTO;
import br.com.itcpn.gamescorehub.exception.dto.ErrorResponseSimpleCause;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Categories")
public interface CategorieControllerOpenAPI {
    @Operation(summary = "List all categories")
    @ApiResponse(responseCode = "200", description = "List of all categories",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = CategorieResponseDTO.class))))
    @ApiResponse(responseCode = "403", description = "Access denied or token error",
            content = @Content)
    List<CategorieResponseDTO> listAllCategories();
    @Operation(summary = "Save a new categorie")
    @ApiResponse(responseCode = "201", description = "Categorie created",
            content = @Content(schema = @Schema(implementation = CategorieResponseDTO.class)))
    @ApiResponse(responseCode = "400", description = "Invalid Request, Review the fields or if the categorie already exists",
            content = @Content(schema = @Schema(implementation = ErrorResponseSimpleCause.class)))
    @ApiResponse(responseCode = "403", description = "Access denied or token error",
            content = @Content)
    @SecurityRequirement(name="bearer-key")
    ResponseEntity<CategorieDTO> saveCategorie(@RequestBody @Valid CategorieDTO categorieDTO);
}
