package br.com.itcpn.gamescorehub.domain.categorie.dto;

import br.com.itcpn.gamescorehub.domain.game.Game;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategorieDTO {
    private Long id;
    @NotBlank
    private String name;
    private Set<Game> gameList = new HashSet<>();
}
