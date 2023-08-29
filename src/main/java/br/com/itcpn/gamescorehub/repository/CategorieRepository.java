package br.com.itcpn.gamescorehub.repository;

import br.com.itcpn.gamescorehub.domain.categorie.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}
