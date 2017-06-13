/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesauxdonnees;

import Beans.Produit;
import Beans.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Alice
 */
public class DaoProduit {
    private final Connection connexion;

    public DaoProduit(Connection connexion) throws SQLException {
        this.connexion = connexion;
    }

    public void recupererProduits(List<Produit> lesProduits) throws SQLException {
        String requete = "select * from produit";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        while (rset.next()) {       // traitement du résulat
            int idProduit = rset.getInt(1);
            String nomProduit = rset.getString(2);
            int prixUnitaireHT = rset.getInt(3);
            int tauxTVA = rset.getInt(4);
            String infosProduits = rset.getString(5);
            String type = rset.getString(6);
            String parfum = rset.getString(7);
            LocalDate dateMiseEnVente = rset.getDate(8).toLocalDate();
            String lienImage= rset.getString(9);
            Produit temp = new Produit(idProduit, nomProduit, prixUnitaireHT, tauxTVA, infosProduits, type, parfum, dateMiseEnVente, lienImage);
            lesProduits.add(temp);
        }
        
        rset.close();
        pstmt.close();
    }
}
