package br.com.itcpn.gamescorehub.controller;

import br.com.itcpn.gamescorehub.domain.categorie.dto.CategorieDTO;
import br.com.itcpn.gamescorehub.domain.categorie.dto.CategorieResponseDTO;
import br.com.itcpn.gamescorehub.service.CategorieService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @GetMapping()
    public List<CategorieResponseDTO> listAllCategories() {
        return categorieService.findAllCategories();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CategorieDTO> saveCategorie(@RequestBody @Valid CategorieDTO categorieDTO) {
        categorieDTO = categorieService.saveCategorie(categorieDTO);
        return ResponseEntity.created(URI.create("/categories")).body(categorieDTO);
    }
}
