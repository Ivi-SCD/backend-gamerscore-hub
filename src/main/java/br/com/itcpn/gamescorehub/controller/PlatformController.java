package br.com.itcpn.gamescorehub.controller;

import br.com.itcpn.gamescorehub.domain.platform.dto.PlatformDTO;
import br.com.itcpn.gamescorehub.domain.platform.dto.PlatformResponseDTO;
import br.com.itcpn.gamescorehub.openapi.PlatformControllerOpenAPI;
import br.com.itcpn.gamescorehub.service.PlaftormService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/platforms")
public class PlatformController implements PlatformControllerOpenAPI {

    @Autowired
    private PlaftormService platformService;

    @GetMapping
    public List<PlatformResponseDTO> listAllPlatforms() {
        return platformService.findAllPlatforms();
    }

    @PostMapping
    @Transactional
    @SecurityRequirement(name="bearer-key")
    public ResponseEntity<PlatformDTO> savePlatform(@RequestBody @Valid PlatformDTO platformDTO) {
        platformDTO = platformService.savePlatform(platformDTO);
        return ResponseEntity.created(URI.create("/platforms")).body(platformDTO);
    }
}
