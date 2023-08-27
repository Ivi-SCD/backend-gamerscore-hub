package br.com.itcpn.gamescorehub.service;

import br.com.itcpn.gamescorehub.domain.user.RegisterDTO;
import br.com.itcpn.gamescorehub.domain.user.User;
import br.com.itcpn.gamescorehub.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username);
    }

    public RegisterDTO getUserById(Long id) {
        User user = findUser(id);
        return modelMapper.map(user, RegisterDTO.class);
    }

    public User saveUser(RegisterDTO registerDTO) {
        User user = modelMapper.map(registerDTO, User.class);
        return userRepository.save(user);
    }

    public RegisterDTO findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if(user != null) {
            return modelMapper.map(user, RegisterDTO.class);
        }
        return null;
    }

    public RegisterDTO findByNickname(String nickname) {
        User user = userRepository.findByNickname(nickname);
        if(user != null) {
            return modelMapper.map(user, RegisterDTO.class);
        }
        return null;
    }

    public void deleteUser(Long id) {
        User user = findUser(id);
        user.setActive(false);
    }

    private User findUser(Long id) {
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public HttpStatus validateUser(RegisterDTO registerDTO) {
        if(findByEmail(registerDTO.getEmail()) != null || findByNickname(registerDTO.getNickname()) != null) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.OK;
    }
}
