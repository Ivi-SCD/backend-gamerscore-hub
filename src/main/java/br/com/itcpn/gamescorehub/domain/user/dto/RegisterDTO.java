package br.com.itcpn.gamescorehub.domain.user.dto;

import br.com.itcpn.gamescorehub.domain.user.enums.ProfilePic;
import br.com.itcpn.gamescorehub.domain.user.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegisterDTO {
    @Email
    private String email;
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[@#$%^&+=!])(?=\\S+$).{6,}$",
            message = "The password must contain at least 6 characters, 1 number and 1 special character"
    )
    private String password;
    @Size(min = 5, max = 50)
    private String nickname;
    private final Boolean active = true;
    private final UserRole role = UserRole.USER;
    private final LocalDateTime createdAt = LocalDateTime.now();
    private final ProfilePic profilePic = ProfilePic.GREEN;
}
