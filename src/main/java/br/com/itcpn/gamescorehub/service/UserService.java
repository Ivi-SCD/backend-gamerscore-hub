package br.com.itcpn.gamescorehub.service;

import br.com.itcpn.gamescorehub.domain.user.User;
import br.com.itcpn.gamescorehub.domain.user.dto.RegisterDTO;
import br.com.itcpn.gamescorehub.domain.user.dto.UserResponseDTO;
import br.com.itcpn.gamescorehub.repository.UserRepository;
import br.com.itcpn.gamescorehub.util.NonNullFieldsReflection;
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

    public UserResponseDTO updateUser(Long id, UserResponseDTO user) throws IllegalAccessException {
        User userToUpdate = findUserById(id);
        NonNullFieldsReflection.setNonNullFields(user, userToUpdate);
        userRepository.save(userToUpdate);

        return modelMapper.map(userToUpdate, UserResponseDTO.class);
    }
    private User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
