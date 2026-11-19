package com.sesame.librairie.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.sesame.librairie.model.Livre;

class LivreServiceTest {

    // Pas de Spring : on crée le service directement
    private final LivreService service = new LivreService();

    @Test
    void compterRenvoieCinqLivresAuDepart() {
        assertEquals(5, service.compter());
    }

    @Test
    void trouverRenvoieLeLivreExistant() {
        Livre livre = service.trouver(3L).get();
        assertEquals("L'Étranger", livre.getTitre());
    }

    @Test
    void trouverRenvoieVideSiIdInconnu() {
        assertTrue(service.trouver(99L).isEmpty());
    }

    @Test
    void listerFiltreParAuteur() {
        assertEquals(2, service.lister("camus").size());
    }

    @Test
    void ajouterAttribueUnIdentifiantEtAugmenteLeNombre() {
        Livre livre = service.ajouter("Candide", "Voltaire", 1759);
        assertEquals(6L, livre.getId());
        assertEquals(6, service.compter());
    }
}
