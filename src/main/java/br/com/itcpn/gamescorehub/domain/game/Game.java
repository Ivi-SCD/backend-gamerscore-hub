package br.com.itcpn.gamescorehub.domain.game;

import br.com.itcpn.gamescorehub.domain.categorie.Categorie;
import br.com.itcpn.gamescorehub.domain.platform.Platform;
import br.com.itcpn.gamescorehub.domain.publicnote.PublicNote;
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
    @Column(length = 100, nullable = false)
    private String name;
    @Column(length = 5000, nullable = false)
    private String description;
    @Temporal(TemporalType.DATE)
    private LocalDate releaseYear;
    @Column(length = 2, nullable = false)
    private String ageClassification;
    @Column(name = "thumb_url")
    private String thumbURL;
    @Column(name = "critics_note")
    private Integer criticsNote;
    private String developer;
    @ManyToMany
    @JoinTable(name = "tb_games_platforms",
    joinColumns = @JoinColumn(name = "id_game"),
    inverseJoinColumns = @JoinColumn(name = "id_platform"), uniqueConstraints = {@UniqueConstraint(columnNames = {"id_game", "id_platform"})})
    private Set <Platform> platformsList = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "tb_games_categories",
    joinColumns = @JoinColumn(name = "id_game"),
    inverseJoinColumns = @JoinColumn(name = "id_categorie"), uniqueConstraints = {@UniqueConstraint(columnNames = {"id_game", "id_categorie"})})
    private Set <Categorie> categoriesList = new HashSet<>();
    @OneToMany(mappedBy = "game")
    private Set <PublicNote> publicNotesList = new HashSet<>();
    @Column(name = "public_note", length = 3)
    private String publicNote;

    public void addPlatform(Platform platform) {
        this.platformsList.add(platform);
    }

    public void removePlatform(Platform platform) {
        this.platformsList.remove(platform);
    }

    public void addCategorie(Categorie categorie) {
        this.categoriesList.add(categorie);
    }

    public void removeCategorie(Categorie categorie) {
        this.categoriesList.remove(categorie);
    }
}
