package br.com.itcpn.gamescorehub.domain.platforms;

import br.com.itcpn.gamescorehub.domain.game.Game;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_platform")
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
    private List<Game> gameList = new ArrayList<>();
}
