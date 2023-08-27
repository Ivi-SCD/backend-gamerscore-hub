package br.com.itcpn.gamescorehub.service;

import br.com.itcpn.gamescorehub.domain.user.UserDTO;
import br.com.itcpn.gamescorehub.domain.user.User;
import br.com.itcpn.gamescorehub.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO getUserById(Long id) {
        User user = findUser(id);
        return modelMapper.map(user, UserDTO.class);
    }

    public UserDTO saveUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        user = userRepository.save(user);
        return modelMapper.map(user, UserDTO.class);
    }

    public UserDTO findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return modelMapper.map(user, UserDTO.class);
    }

    public UserDTO findByNickname(String nickname) {
        User user = userRepository.findByNickname(nickname);
        return modelMapper.map(user, UserDTO.class);
    }

    public void deleteUser(Long id) {
        User user = findUser(id);
        user.setActive(false);
    }

    private User findUser(Long id) {
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
