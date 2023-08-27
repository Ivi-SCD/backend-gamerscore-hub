package br.com.itcpn.gamescorehub.domain.game;

import br.com.itcpn.gamescorehub.domain.caserules.ValidImageURL;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tb_game")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_game")
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 5000, nullable = false)
    private String description;

    @Temporal(TemporalType.DATE)
    private LocalDate releaseYear;
    @Column(length = 2, nullable = false)
    private String ageClassification;
    @Column(name = "thumb_url")
    private String thumbURL;
    @Column(name = "critics_note")
    private Integer criticsNote;
    private String developer;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class GameForSaveDTO {
           private Long id;
           private String name;
           private String ageClassification;
           private Integer criticsNote;
           private String developer;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class GameDTO {
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
    }
}
