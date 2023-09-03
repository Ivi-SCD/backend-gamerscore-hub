package br.com.itcpn.gamescorehub.domain.game.dto;

import br.com.itcpn.gamescorehub.domain.caserules.ValidImageURL;
import br.com.itcpn.gamescorehub.domain.categorie.Categorie;
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
public class GameForUpdateDTO {
    private String name;
    private String description;
    private LocalDate releaseYear;
    @Pattern(regexp = "^(0|10|12|14|16|18)$", message = "The age classification must be one of the following: 0, 10, 12, 14, 16 or 18")
    private String ageClassification;
    @ValidImageURL
    private String thumbURL;
    @DecimalMin(value = "0", message = "The critics note must be a number between 0 and 100")
    @DecimalMax(value = "100", message = "The critics note must be a number between 0 and 100")
    private Integer criticsNote;
    private String developer;
    private Set<Platform> platformsList = new HashSet<>();
    private Set<Categorie> categoriesList = new HashSet<>();
}
