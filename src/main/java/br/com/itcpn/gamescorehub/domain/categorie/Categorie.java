package br.com.itcpn.gamescorehub.domain.categorie;

import br.com.itcpn.gamescorehub.domain.game.Game;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_categories")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categorie")
    private Long id;
    @Column(unique = true, length = 50, nullable = false)
    private String name;
    @ManyToMany(mappedBy = "categoriesList")
    @JsonIgnore
    private Set<Game> gameList = new HashSet<>();
}
