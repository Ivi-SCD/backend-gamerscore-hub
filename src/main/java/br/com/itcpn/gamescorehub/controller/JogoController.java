package br.com.itcpn.gamescorehub.controller;

import br.com.itcpn.gamescorehub.dto.JogoDTO;
import br.com.itcpn.gamescorehub.service.JogoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogos")
public class JogoController {

    @Autowired
    private JogoService jogoService;

    @GetMapping("/{size}")
    public List<JogoDTO> listAllJogos(
            @PageableDefault(size = 20) Pageable pageable,
            @PathVariable int size) {

        pageable = PageRequest.of(pageable.getPageNumber(), size, pageable.getSort());

        return jogoService.getAllJogos(pageable);
    }

    @GetMapping("/{name}")
    public JogoDTO findJogoByName(@PathVariable String name) {
        return jogoService.findByName(name);
    }

    @GetMapping("sort/{name}")
    public List<JogoDTO> findJogosByName(@PathVariable String name) {
        return jogoService.findJogosByNome(name);
    }

    @GetMapping
    public List<JogoDTO> listAllJogos() {
        return jogoService.getAllJogos();
    }

    @PostMapping
    public JogoDTO saveJogo(@RequestBody @Valid JogoDTO jogoDTO) {
        return jogoService.saveJogo(jogoDTO);
    }

}
