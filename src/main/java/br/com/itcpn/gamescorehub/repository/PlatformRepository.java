package br.com.itcpn.gamescorehub.repository;

import br.com.itcpn.gamescorehub.domain.platform.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatformRepository extends JpaRepository<Platform, Long> {
}
