package br.com.itcpn.gamescorehub.domain.game.dto;

import br.com.itcpn.gamescorehub.domain.categorie.dto.CategorieDTO;
import br.com.itcpn.gamescorehub.domain.platform.dto.PlatformDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GameResponseDTO {
    private String name;
    private String description;
    private LocalDate releaseYear;
    private String ageClassification;
    private Integer criticsNote;
    private String developer;
    private List<PlatformDTO> platformsList = new ArrayList<>();
    private List<CategorieDTO> categoriesList = new ArrayList<>();
    private Double publicNote;
}
