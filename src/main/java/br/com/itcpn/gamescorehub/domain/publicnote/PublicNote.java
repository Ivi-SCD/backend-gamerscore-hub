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

    @EmbeddedId
    private PublicNoteId id;
    @ManyToOne
    @MapsId("idUser")
    @JoinColumn(name = "id_user")
    private User user;
    @ManyToOne
    @MapsId("idGame")
    @JoinColumn(name = "id_game")
    private Game game;
    private Integer animation;
    private Integer gameplay;
    private Integer narrative;
    private Integer soundtrack;

}
