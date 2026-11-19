package com.sesame.librairie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sesame.librairie.model.Livre;
import com.sesame.librairie.repository.LivreRepository;

@Service
public class LivreService {

    private final LivreRepository livreRepository;

    public LivreService(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    public List<Livre> lister(String auteur) {
        if (auteur == null) {
            return livreRepository.findAll();
        }
        return livreRepository.findByAuteurContainingIgnoreCase(auteur);
    }

    public Optional<Livre> trouver(Long id) {
        return livreRepository.findById(id);
    }

    public int compter() {
        return (int) livreRepository.count();
    }

    public Livre ajouter(String titre, String auteur, int annee) {
        Livre livre = new Livre(null, titre, auteur, annee);
        return livreRepository.save(livre);
    }
}
