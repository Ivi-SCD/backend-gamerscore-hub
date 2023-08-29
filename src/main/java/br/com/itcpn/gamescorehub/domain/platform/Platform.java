package br.com.itcpn.gamescorehub.domain.platform;

import br.com.itcpn.gamescorehub.domain.game.Game;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_platforms")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Platform {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_platform")
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "platformsList")
    @JsonIgnore
    private List<Game> gameList = new ArrayList<>();
}
