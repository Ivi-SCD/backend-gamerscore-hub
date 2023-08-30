package br.com.itcpn.gamescorehub.domain.categorie.dto;

import br.com.itcpn.gamescorehub.domain.game.dto.GameSimplifiedDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CategorieResponseDTO {
    private String name;
    private List<GameSimplifiedDTO> gameList = new ArrayList<>();
}
