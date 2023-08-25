package br.com.itcpn.gamescorehub.repository;

import br.com.itcpn.gamescorehub.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JogoRepository extends JpaRepository<Jogo, Long> {
    Jogo findByNome(String nome);
    @Query("SELECT j FROM Jogo j WHERE j.nome LIKE %:nome%")
    List<Jogo> findAllLikeNome(String nome);
}
