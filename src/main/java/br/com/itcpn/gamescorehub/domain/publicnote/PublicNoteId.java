package br.com.itcpn.gamescorehub.domain.publicnote;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PublicNoteId implements Serializable {

    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "id_game")
    private Long idGame;
}
