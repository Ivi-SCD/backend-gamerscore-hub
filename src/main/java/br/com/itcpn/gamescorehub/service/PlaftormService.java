package br.com.itcpn.gamescorehub.service;

import br.com.itcpn.gamescorehub.domain.platform.Platform;
import br.com.itcpn.gamescorehub.domain.platform.dto.PlatformDTO;
import br.com.itcpn.gamescorehub.domain.platform.dto.PlatformResponseDTO;
import br.com.itcpn.gamescorehub.repository.PlatformRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaftormService {

    @Autowired
    private PlatformRepository platformRepository;

    @Autowired
    private ModelMapper modelMapper;
    public List<PlatformResponseDTO> findAllPlatforms() {
        return platformRepository.findAll()
                .stream()
                .map((platform) -> modelMapper.map(platform, PlatformResponseDTO.class))
                .toList();
    }

    public PlatformDTO savePlatform(PlatformDTO platformDTO) {
        Platform platform = modelMapper.map(platformDTO, Platform.class);
        platform = platformRepository.save(platform);
        return modelMapper.map(platform, PlatformDTO.class);
    }
}
