package br.com.itcpn.gamescorehub.domain.publicnote.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PublicNoteDTO {
    @NotBlank(message = "The name of the game cannot be empty")
    private String gameName;
    @DecimalMin(value = "0", message = "The critics note must be a number between 0 and 10")
    @DecimalMax(value = "10", message = "The critics note must be a number between 0 and 10")
    @NotNull(message = "The animation note cannot be empty")
    private Integer animation;
    @DecimalMin(value = "0", message = "The critics note must be a number between 0 and 10")
    @DecimalMax(value = "10", message = "The critics note must be a number between 0 and 10")
    @NotNull(message = "The gameplay note cannot be empty")
    private Integer gameplay;
    @DecimalMin(value = "0", message = "The critics note must be a number between 0 and 10")
    @DecimalMax(value = "10", message = "The critics note must be a number between 0 and 10")
    @NotNull(message = "The narrative note cannot be empty")
    private Integer narrative;
    @DecimalMin(value = "0", message = "The critics note must be a number between 0 and 10")
    @DecimalMax(value = "10", message = "The critics note must be a number between 0 and 10")
    @NotNull(message = "The soundtrack note cannot be empty")
    private Integer soundtrack;
}
