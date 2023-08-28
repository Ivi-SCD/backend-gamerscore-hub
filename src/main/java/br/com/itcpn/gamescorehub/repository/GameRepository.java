package br.com.itcpn.gamescorehub.repository;

import br.com.itcpn.gamescorehub.domain.game.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
    @Query("SELECT g FROM Game g WHERE g.name LIKE %:name%")
    List<Game> findAllLikeName(String name);
    @Query("SELECT g FROM Game g WHERE YEAR(g.releaseYear) = :year")
    List<Game> findGamesByYear(@Param("year") int year);
    @Query("SELECT g FROM Game g WHERE g.ageClassification = :ageClassification")
    List<Game> findGamesByAge(@Param("ageClassification") String ageClassification);
    @Query("SELECT g FROM Game g ORDER BY g.criticsNote DESC")
    List<Game> findAllGamesOrderByCriticsNote();
    @Query("SELECT g FROM Game g ORDER BY g.releaseYear DESC")
    List<Game> findAllGamesOrderByYear();
}
