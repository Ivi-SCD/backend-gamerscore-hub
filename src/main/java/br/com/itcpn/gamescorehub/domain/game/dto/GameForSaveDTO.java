package br.com.itcpn.gamescorehub.domain.game.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GameForSaveDTO {
    private Long id;
    private String name;
    private String ageClassification;
    private Integer criticsNote;
    private String developer;
}