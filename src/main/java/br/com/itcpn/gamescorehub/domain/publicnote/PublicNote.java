package br.com.itcpn.gamescorehub.domain.publicnote;

import br.com.itcpn.gamescorehub.domain.game.Game;
import br.com.itcpn.gamescorehub.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_public_notes", uniqueConstraints = @UniqueConstraint(columnNames = {"id_user", "id_game"}))
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
    private Integer animation;
    private Integer gameplay;
    private Integer narrative;
    private Integer soundtrack;

}
