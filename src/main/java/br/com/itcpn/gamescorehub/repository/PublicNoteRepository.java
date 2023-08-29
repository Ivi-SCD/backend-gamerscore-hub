package br.com.itcpn.gamescorehub.repository;

import br.com.itcpn.gamescorehub.domain.publicnote.PublicNote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicNoteRepository extends JpaRepository<PublicNote, Long> {
}
