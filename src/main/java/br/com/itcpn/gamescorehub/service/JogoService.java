package br.com.itcpn.gamescorehub.service;

import br.com.itcpn.gamescorehub.dto.JogoDTO;
import br.com.itcpn.gamescorehub.model.Jogo;
import br.com.itcpn.gamescorehub.repository.JogoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public JogoDTO getJogoById(Long id) {
        Jogo jogo = jogoRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(jogo, JogoDTO.class);
    }

    public List<JogoDTO> getAllJogos() {
        List<Jogo> jogos = jogoRepository.findAll();
        return jogos.stream()
                .map(jogo -> modelMapper.map(jogo, JogoDTO.class))
                .toList();
    }

    public List<JogoDTO> getAllJogos(Pageable pagination) {
        return jogoRepository.findAll(pagination)
                .map(jogo -> modelMapper.map(jogo, JogoDTO.class))
                .toList();
    }

    public JogoDTO updateJogo(Long id, JogoDTO jogoDTO) {
        Jogo jogo = modelMapper.map(jogoDTO, Jogo.class);
        jogo.setId(id);
        jogo = jogoRepository.save(jogo);
        return modelMapper.map(jogo, JogoDTO.class);
    }

    public JogoDTO saveJogo(JogoDTO jogoDTO) {
        Jogo jogo = modelMapper.map(jogoDTO, Jogo.class);
        jogo = jogoRepository.save(jogo);
        return modelMapper.map(jogo, JogoDTO.class);
    }

    public void deleteJogo(Long id) {
        jogoRepository.deleteById(id);
    }

    public JogoDTO findByName(String name) {
        Jogo jogo = jogoRepository.findByNome(name);
        return modelMapper.map(jogo, JogoDTO.class);
    }

    public List<JogoDTO> findJogosByNome (String nome) {
        return jogoRepository.findAllLikeNome(nome)
                .stream()
                .map(jogo -> modelMapper.map(jogo, JogoDTO.class))
                .toList();
    }
}
