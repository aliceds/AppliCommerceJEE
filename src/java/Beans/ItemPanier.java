/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author p1519286
 */
public class ItemPanier {
    private int idProduit;
    private String nomProduit;
    private float prixUnitaireHT;
    private String infosProduits;
    private String parfum;
    private String type;
    private String lienImage;

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

    public String getParfum() {
        return parfum;
    }

    public void setParfum(String parfum) {
        this.parfum = parfum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLienImage() {
        return lienImage;
    }

    public void setLienImage(String lienImage) {
        this.lienImage = lienImage;
    }
     
    
}
