package br.com.itcpn.gamescorehub.domain.publicnote;

import br.com.itcpn.gamescorehub.domain.game.Game;
import br.com.itcpn.gamescorehub.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_public_notes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PublicNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_public_note")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    @ManyToOne
    @JoinColumn(name = "id_game")
    private Game game;
    @Column(columnDefinition = "DECIMAL(3,0)")
    private Integer animation;
    @Column(columnDefinition = "DECIMAL(3,0)")
    private Integer gameplay;
    @Column(columnDefinition = "DECIMAL(3,0)")
    private Integer narrative;
    @Column(columnDefinition = "DECIMAL(3,0)")
    private Integer soundtrack;

}
