package com.sesame.librairie.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.sesame.librairie.model.Livre;

@SpringBootTest
@Transactional
class LivreServiceTest {

    @Autowired
    private LivreService service;

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
        assertNotNull(livre.getId());
        assertEquals(6, service.compter());
    }
}
