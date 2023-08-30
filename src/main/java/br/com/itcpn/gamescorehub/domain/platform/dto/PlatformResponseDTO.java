package br.com.itcpn.gamescorehub.domain.platform.dto;

import br.com.itcpn.gamescorehub.domain.game.dto.GameSimplifiedDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlatformResponseDTO {
    private String name;
    private List<GameSimplifiedDTO> gameList = new ArrayList<>();
}
