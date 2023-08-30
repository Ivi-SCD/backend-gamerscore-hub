package br.com.itcpn.gamescorehub.domain.game.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GameSimplifiedDTO {
    private String name;
    private String description;
    private String developer;
    private Double publicNote;
}
