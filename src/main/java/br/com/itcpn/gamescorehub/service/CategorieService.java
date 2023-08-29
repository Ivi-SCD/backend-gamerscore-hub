package br.com.itcpn.gamescorehub.service;

import br.com.itcpn.gamescorehub.domain.categorie.Categorie;
import br.com.itcpn.gamescorehub.domain.categorie.dto.CategorieDTO;
import br.com.itcpn.gamescorehub.repository.CategorieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<CategorieDTO> findAllCategories() {
        return categorieRepository.findAll()
                .stream()
                .map(categorie -> modelMapper.map(categorie, CategorieDTO.class))
                .toList();
    }

    public CategorieDTO saveCategorie(CategorieDTO categorieDTO) {
        Categorie categorie = modelMapper.map(categorieDTO, Categorie.class);
        categorie = categorieRepository.save(categorie);
        return modelMapper.map(categorie, CategorieDTO.class);
    }
}
