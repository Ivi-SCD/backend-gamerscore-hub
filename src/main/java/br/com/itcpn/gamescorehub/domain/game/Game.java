package br.com.itcpn.gamescorehub.domain.game;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tb_game")
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

}
