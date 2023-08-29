package br.com.itcpn.gamescorehub.domain.game.dto;

import br.com.itcpn.gamescorehub.domain.caserules.ValidImageURL;
import br.com.itcpn.gamescorehub.domain.platform.Platform;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GameDTO {
    private Long id;
    @Size(min = 5, max = 100)
    @NotBlank(message = "The name of the game cannot be empty")
    private String name;
    @NotBlank(message = "The description of the game cannot be empty")
    private String description;
    @NotNull(message = "The release year of the game cannot be empty")
    private LocalDate releaseYear;
    @Pattern(regexp = "^(0|10|12|14|16|18)$", message = "The age classification must be one of the following: 0, 10, 12, 14, 16 or 18")
    @NotBlank(message = "The age classification of the game cannot be empty")
    private String ageClassification;
    @ValidImageURL
    @NotNull(message = "The thumbURL of the game cannot be empty")
    private String thumbURL;
    @DecimalMin(value = "0", message = "The critics note must be a number between 0 and 100")
    @DecimalMax(value = "100", message = "The critics note must be a number between 0 and 100")
    private Integer criticsNote;
    @NotNull(message = "The developer of the game cannot be empty")
    private String developer;
    @NotEmpty(message = "The game must have at least one platform")
    private Set<Platform> platformsList = new HashSet<>();
}
