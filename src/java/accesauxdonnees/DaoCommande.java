/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesauxdonnees;

import Beans.Commande;
import Beans.ItemPanier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author p1519286
 */
public class DaoCommande {
    private final Connection connexion;

    public DaoCommande(Connection connexion) throws SQLException {
        this.connexion = connexion;
    }

    public void recupererCommandes(List<Commande> lesCommandes, int id_utilisateur) throws SQLException {
        String requete = "SELECT commande.numeroCommande, dateCommande, etat, contenuCommande.idProduit, nomProduit, quantiteAchetee, prixUnitaireHT "
                + "FROM commande, contenuCommande, produit "
                + "WHERE contenuCommande.idProduit = produit.idProduit "
                + "AND commande.numeroCommande = contenuCommande.numeroCommande "
                + "AND  id_utilisateur="+id_utilisateur;
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        while (rset.next()) {       // traitement du résulat
            int idCommande = rset.getInt(1);
            LocalDate dateCommande = rset.getDate(2).toLocalDate();
            String etat = rset.getString(3);
            ItemPanier item = new ItemPanier();
            item.setIdProduit(rset.getInt(4));
            item.setNomProduit(rset.getString(5));
            item.setQuantite(rset.getInt(6));
            item.setPrixUnitaireHT(rset.getFloat(7));
            item.setMontant(rset.getInt(6)*rset.getFloat(7));
            Commande cmd = new Commande(idCommande, id_utilisateur, dateCommande, etat, item);
            lesCommandes.add(cmd);
        }
        
        rset.close();
        pstmt.close();
    }
}
