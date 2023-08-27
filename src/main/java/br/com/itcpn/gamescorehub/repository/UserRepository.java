package br.com.itcpn.gamescorehub.repository;

import br.com.itcpn.gamescorehub.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByNickname(String nickname);
}
