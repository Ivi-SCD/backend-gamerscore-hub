package br.com.itcpn.gamescorehub.service;

import br.com.itcpn.gamescorehub.domain.user.User;
import br.com.itcpn.gamescorehub.domain.user.dto.RegisterDTO;
import br.com.itcpn.gamescorehub.domain.user.dto.UserResponseDTO;
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
    private SecurityService securityService;

    @Autowired
    private ModelMapper modelMapper;

    public User saveUser(RegisterDTO registerDTO) {
        User user = modelMapper.map(registerDTO, User.class);
        return userRepository.save(user);
    }

    public UserResponseDTO getUserById(Long id) {
        User user = findUserById(id);
        return modelMapper.map(user, UserResponseDTO.class);
    }

    public void deleteUserById(Long id) {
        User user = findUserById(id);
        user.setActive(false);
        userRepository.save(user);
    }

    public void updateUser(Long id, UserResponseDTO user) {
        User userToUpdate = findUserById(id);
        userToUpdate.setPassword(securityService.ecryptPassword(userToUpdate.getPassword()));
        modelMapper.map(user, userToUpdate);
        userRepository.save(userToUpdate);
    }
    private User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

}
