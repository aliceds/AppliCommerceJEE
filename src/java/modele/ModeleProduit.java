/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import Beans.Produit;
import Beans.Utilisateur;
import accesauxdonnees.CreationConnexion;
import accesauxdonnees.DaoProduit;
import accesauxdonnees.DaoUtilisateur;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alice
 */
public class ModeleProduit {
     private final List<Produit> leConteneurProduits;
    private final DaoProduit leDaoProduit;

    public ModeleProduit() {
        this.leConteneurProduits = new ArrayList<>();
        this.leDaoProduit = CreationConnexion.getDaoProduit();
    }
    
    public void chargerLesProduits() throws SQLException {
        leDaoProduit.recupererProduits(leConteneurProduits);
    }

    public List<Produit> getLeConteneurProduits() {
        return leConteneurProduits;
    }
}
