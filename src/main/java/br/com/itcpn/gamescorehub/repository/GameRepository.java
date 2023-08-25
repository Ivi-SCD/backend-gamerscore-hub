package br.com.itcpn.gamescorehub.repository;

import br.com.itcpn.gamescorehub.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
    @Query("SELECT g FROM Game g WHERE g.name LIKE %:name%")
    List<Game> findAllLikeName(String name);
    @Query("SELECT g FROM Game g WHERE YEAR(g.releaseYear) = :year")
    List<Game> findGamesByYear(@Param("year") int year);
}
