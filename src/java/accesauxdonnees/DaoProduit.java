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
            float prixUnitaireHT = rset.getFloat(3);
            String infosProduits = rset.getString(4);
            String type = rset.getString(5);
            String parfum = rset.getString(6);
            LocalDate dateMiseEnVente = rset.getDate(7).toLocalDate();
            String lienImage= rset.getString(8);
            Produit temp = new Produit(idProduit, nomProduit, prixUnitaireHT,  infosProduits, type, parfum, dateMiseEnVente, lienImage);
            lesProduits.add(temp);
        }
        
        rset.close();
        pstmt.close();
    }
}
