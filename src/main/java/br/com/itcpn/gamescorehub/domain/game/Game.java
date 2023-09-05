package br.com.itcpn.gamescorehub.domain.game;

import br.com.itcpn.gamescorehub.domain.categorie.Categorie;
import br.com.itcpn.gamescorehub.domain.platform.Platform;
import br.com.itcpn.gamescorehub.domain.publicnote.PublicNote;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_games")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_game")
    private Long id;
    @Column(length = 100, nullable = false, unique = true)
    private String name;
    @Column(length = 1000)
    private String description;
    @Temporal(TemporalType.DATE)
    @Column(name = "release_year", nullable = false)
    private LocalDate releaseYear;
    @Column(name = "age_classification", columnDefinition = "ENUM('L', '10', '12', '14', '16', '18')", nullable = false)
    private String ageClassification;
    @Column(name = "thumb_url", length = 500)
    private String thumbURL;
    @Column(name = "critics_note", columnDefinition = "DECIMAL(3,0)")
    private Integer criticsNote;
    @Column(length = 50)
    private String developer;
    @ManyToMany
    @JoinTable(name = "tb_games_platforms",
    joinColumns = @JoinColumn(name = "id_game"),
    inverseJoinColumns = @JoinColumn(name = "id_platform"))
    private Set <Platform> platformsList = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "tb_games_categories",
    joinColumns = @JoinColumn(name = "id_game"),
    inverseJoinColumns = @JoinColumn(name = "id_category"))
    private Set <Categorie> categoriesList = new HashSet<>();
    @OneToMany(mappedBy = "game")
    @JsonIgnore
    private Set <PublicNote> publicNotesList = new HashSet<>();
    @Column(name = "public_note", columnDefinition = "DECIMAL(2,1)")
    private Double publicNote;
}
