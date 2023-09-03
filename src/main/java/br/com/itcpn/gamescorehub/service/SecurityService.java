package br.com.itcpn.gamescorehub.service;

import br.com.itcpn.gamescorehub.domain.user.User;
import br.com.itcpn.gamescorehub.domain.user.dto.RegisterDTO;
import br.com.itcpn.gamescorehub.exception.UnexpectedError;
import br.com.itcpn.gamescorehub.exception.user.UserWithEmailOrNicknameAlreadyExistsException;
import br.com.itcpn.gamescorehub.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityService implements UserDetailsService {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username);
    }

    private RegisterDTO findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if(user != null) {
            return modelMapper.map(user, RegisterDTO.class);
        }
        return null;
    }

    private RegisterDTO findByNickname(String nickname) {
        User user = userRepository.findByNickname(nickname);
        if(user != null) {
            return modelMapper.map(user, RegisterDTO.class);
        }
        return null;
    }

    public void validateUser(RegisterDTO registerDTO) {
        if(findByEmail(registerDTO.getEmail()) != null || findByNickname(registerDTO.getNickname()) != null) {
            throw new UserWithEmailOrNicknameAlreadyExistsException("Email or nickname already registered");
        }
    }

    public User authorize(String token) {
        if(token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);

            String email = tokenService.validateToken(token);
            return userRepository.findByEmail(email);
        }
        throw new UnexpectedError("Unexpected error");
    }
    public String ecryptPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}