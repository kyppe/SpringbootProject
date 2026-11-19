package com.sesame.librairie.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String titre;

    private String auteur;
    private int annee;

    // Constructeur vide
    public Livre() {
    }

    // Constructeur avec tous les attributs
    public Livre(Long id, String titre, String auteur, int annee) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.annee = annee;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public String getAuteur() { return auteur; }
    public void setAuteur(String auteur) { this.auteur = auteur; }

    public int getAnnee() { return annee; }
    public void setAnnee(int annee) { this.annee = annee; }
}
