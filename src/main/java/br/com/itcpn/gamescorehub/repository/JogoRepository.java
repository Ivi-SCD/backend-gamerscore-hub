package br.com.itcpn.gamescorehub.repository;

import br.com.itcpn.gamescorehub.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogoRepository extends JpaRepository<Jogo, Long> {
}
