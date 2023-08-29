package br.com.itcpn.gamescorehub.domain.game.dto;

import br.com.itcpn.gamescorehub.domain.platform.Platform;
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
public class GameForSaveDTO {
    private Long id;
    private String name;
    private String ageClassification;
    private Integer criticsNote;
    private String developer;
    private Set<Platform> platformsList = new HashSet<>();
}