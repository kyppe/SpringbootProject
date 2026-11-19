package com.sesame.librairie.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sesame.librairie.model.Livre;

@Service
public class LivreService {

    private final List<Livre> livres = new ArrayList<>();
    private long prochainId = 6;

    public LivreService() {
        livres.add(new Livre(1L, "Les Misérables", "Victor Hugo", 1862));
        livres.add(new Livre(2L, "Notre-Dame de Paris", "Victor Hugo", 1831));
        livres.add(new Livre(3L, "L'Étranger", "Albert Camus", 1942));
        livres.add(new Livre(4L, "La Peste", "Albert Camus", 1947));
        livres.add(new Livre(5L, "Le Petit Prince", "Antoine de Saint-Exupéry", 1943));
    }

    public List<Livre> lister(String auteur) {
        if (auteur == null) {
            return livres;
        }
        return livres.stream()
                .filter(l -> l.getAuteur().toLowerCase()
                        .contains(auteur.toLowerCase()))
                .toList();
    }

    public Optional<Livre> trouver(Long id) {
        return livres.stream()
                .filter(l -> l.getId().equals(id))
                .findFirst();
    }

    public int compter() {
        return livres.size();
    }

    public Livre ajouter(String titre, String auteur, int annee) {
        Livre livre = new Livre(prochainId++, titre, auteur, annee);
        livres.add(livre);
        return livre;
    }
}
