package br.com.itcpn.gamescorehub.openapi;

import br.com.itcpn.gamescorehub.domain.game.dto.GameDTO;
import br.com.itcpn.gamescorehub.domain.game.dto.GameForSaveDTO;
import br.com.itcpn.gamescorehub.domain.game.dto.GameForUpdateDTO;
import br.com.itcpn.gamescorehub.domain.game.dto.GameResponseDTO;
import br.com.itcpn.gamescorehub.exception.dto.ErrorResponseSimpleCause;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Games")
public interface GameControllerOpenAPI {
    @Operation(summary = "List all games")
    @ApiResponse(responseCode = "200", description = "List of all games successfully listed",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = GameResponseDTO.class))))
    @ApiResponse(responseCode = "403", description = "Parameters wrong",
    content = @Content)
    List<GameResponseDTO> listAllGames();
    @Operation(summary = "List all games by specific year")
    @ApiResponse(responseCode = "200", description = "List of all games by specific year successfully listed",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = GameResponseDTO.class))))
    @ApiResponse(responseCode = "403", description = "Parameters wrong", content = @Content)
    List<GameResponseDTO> listAllGamesByYear(@PathVariable int year);
    @Operation(summary = "List all games with pagination")
    @ApiResponse(responseCode = "200", description = "List of all games with pagination successfully listed",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = GameResponseDTO.class))))
    @ApiResponse(responseCode = "403", description = "Parameters wrong", content = @Content)
    List<GameResponseDTO> listAllGames(@PageableDefault(size = 20) Pageable pageable,
                                              @PathVariable int size);
    @Operation(summary = "List all games by specific age classification")
    @ApiResponse(responseCode = "200", description = "List of all games with specific age classification",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = GameResponseDTO.class))))
    @ApiResponse(responseCode = "403", description = "Parameters wrong", content = @Content)
    List<GameResponseDTO> listAllGamesByAgeClassification(@PathVariable String age);
    @Operation(summary = "List all games and order by critics notes")
    @ApiResponse(responseCode = "200", description = "List of all games and order by critics note sucessfully listed",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = GameResponseDTO.class))))
    @ApiResponse(responseCode = "403", description = "Parameters wrong", content = @Content)
    List<GameResponseDTO> listAllGamesByCriticsNotes();
    @Operation(summary = "List all games and order by year")
    @ApiResponse(responseCode = "200", description = "List of all games and order by year sucessfully listed",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = GameResponseDTO.class))))
    @ApiResponse(responseCode = "403", description = "Parameters wrong", content = @Content)
    List<GameResponseDTO> listAllGamesByYear();
    @Operation(summary = "List all games with name like the param")
    @ApiResponse(responseCode = "200", description = "List of all games with name like parameter successfully listed",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = GameResponseDTO.class))))
    @ApiResponse(responseCode = "403", description = "Parameters wrong", content = @Content)
    List<GameResponseDTO> listAllGamesByName(@PathVariable String name);
    @Operation(summary = "List all games and order by public notes")
    @ApiResponse(responseCode = "200", description = "List of all games and order by public note sucessfully listed",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = GameResponseDTO.class))))
    @ApiResponse(responseCode = "403", description = "Parameters wrong", content = @Content)
    List<GameResponseDTO> listAllGamesByPublicNotes();
    @Operation(summary = "Find a game by id")
    @ApiResponse(responseCode = "200", description = "Find a game by id successfully found",
            content = @Content(schema = @Schema(implementation = GameResponseDTO.class)))
    @ApiResponse(responseCode = "404", description = "Game not found", content = @Content
            (schema = @Schema(implementation = ErrorResponseSimpleCause.class)))
    GameResponseDTO findGameById(@PathVariable Long id);
    @Operation(summary = "Save a new game")
    @ApiResponse(responseCode = "403", description = "Parameters wrong or token expired", content = @Content)
    @ApiResponse(responseCode = "400", description = "Integration error, check the fields and if the other schemas exists",
    content = @Content(schema = @Schema(implementation = ErrorResponseSimpleCause.class)))
    @ApiResponse(responseCode = "201", description = "Game successfully saved",
            content = @Content(schema = @Schema(implementation = GameForSaveDTO.class)))
    @SecurityRequirement(name="bearer-key")
    ResponseEntity<GameForSaveDTO> saveGame(@RequestBody @Valid GameDTO GameDTO);
    @Operation(summary = "Update a game")
    @ApiResponse(responseCode = "404", description = "Game with that id not found",
    content = @Content(schema = @Schema(implementation = ErrorResponseSimpleCause.class)))
    @ApiResponse(responseCode = "200", description = "Game updated with success",
            content = @Content(schema = @Schema(implementation = GameResponseDTO.class)))
    @ApiResponse(responseCode = "403", description = "Parameters wrong or token expired", content = @Content)
    @SecurityRequirement(name="bearer-key")
    ResponseEntity<GameResponseDTO> updateGame(@PathVariable Long id, @RequestBody GameForUpdateDTO gameDTO) throws IllegalAccessException;

}
