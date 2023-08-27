package br.com.itcpn.gamescorehub.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    @Email
    private String email;
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[@#$%^&+=!])(?=\\S+$).{6,}$",
            message = "The password must contain at least 6 characters, 1 number and 1 special character"
    )
    private String password;
    @Size(min = 5, max = 50)
    private String nickname;
}
