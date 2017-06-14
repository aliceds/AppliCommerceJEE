/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.time.LocalDate;

/**
 *
 * @author Alice
 */
public class Produit {
    private int idProduit;
    private String nomProduit;
    private float prixUnitaireHT;
    private String infosProduits;
    private String type;
    private String parfum;
    private LocalDate dateMiseEnVente;
    private String lienImage;

    public Produit(int idProduit, String nomProduit, float prixUnitaireHT, String infosProduits, String type, String parfum, LocalDate dateMiseEnVente, String lienImage) {
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.prixUnitaireHT = prixUnitaireHT;
        this.infosProduits = infosProduits;
        this.type = type;
        this.parfum = parfum;
        this.dateMiseEnVente = dateMiseEnVente;
        this.lienImage = lienImage;
    }
    
    public Produit() {
        
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public float getPrixUnitaireHT() {
        return prixUnitaireHT;
    }

    public void setPrixUnitaireHT(float prixUnitaireHT) {
        this.prixUnitaireHT = prixUnitaireHT;
    }

    public String getInfosProduits() {
        return infosProduits;
    }

    public void setInfosProduits(String infosProduits) {
        this.infosProduits = infosProduits;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParfum() {
        return parfum;
    }

    public void setParfum(String parfum) {
        this.parfum = parfum;
    }

    public LocalDate getDateMiseEnVente() {
        return dateMiseEnVente;
    }

    public void setDateMiseEnVente(LocalDate dateMiseEnVente) {
        this.dateMiseEnVente = dateMiseEnVente;
    }

    public String getLienImage() {
        return lienImage;
    }

    public void setLienImage(String lienImage) {
        this.lienImage = lienImage;
    }

    @Override
    public String toString() {
        return "Produit{" + "idProduit=" + idProduit + ", nomProduit=" + nomProduit + ", prixUnitaireHT=" + prixUnitaireHT + ", infosProduits=" + infosProduits + ", type=" + type + ", parfum=" + parfum + ", dateMiseEnVente=" + dateMiseEnVente + ", lienImage=" + lienImage + '}';
    }
    
    
    
}
