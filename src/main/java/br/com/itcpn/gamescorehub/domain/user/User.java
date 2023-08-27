package br.com.itcpn.gamescorehub.domain.user;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_users")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;
    @Column(length = 100, nullable = false, unique = true)
    private String email;
    @Column(length = 50, nullable = false)
    private String password;
    @Column(length = 50, nullable = false, unique = true)
    private String nickname;
    private Boolean active;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime created_at;

    public User(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.active = true;
        this.created_at = LocalDateTime.now();
    }

}
