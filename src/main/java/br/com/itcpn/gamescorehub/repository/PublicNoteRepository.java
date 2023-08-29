package br.com.itcpn.gamescorehub.repository;

import br.com.itcpn.gamescorehub.domain.publicnote.PublicNote;
import br.com.itcpn.gamescorehub.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublicNoteRepository extends JpaRepository<PublicNote, Long> {
}
