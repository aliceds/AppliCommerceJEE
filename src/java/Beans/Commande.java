/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.time.LocalDate;

/**
 *
 * @author p1519286
 */
public class Commande {
    private int numeroCommande;
    private int id_utilisateur;
    private LocalDate dateCommande;
    private String etat;

    public Commande(int numeroCommande, int id_utilisateur, LocalDate dateCommande, String etat) {
        this.numeroCommande = numeroCommande;
        this.id_utilisateur = id_utilisateur;
        this.dateCommande = dateCommande;
        this.etat = etat;
    }
    
    public Commande() {
        
    }

    public int getNumeroCommande() {
        return numeroCommande;
    }

    public void setNumeroCommande(int numeroCommande) {
        this.numeroCommande = numeroCommande;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public LocalDate getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDate dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
    
    
}
