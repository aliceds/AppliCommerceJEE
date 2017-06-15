/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesauxdonnees;

import Beans.Commande;
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
        String requete = "select * from commande where id_utilisateur="+id_utilisateur;
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        while (rset.next()) {       // traitement du résulat
            int idCommande = rset.getInt(1);
            LocalDate dateCommande = rset.getDate(3).toLocalDate();
            String etat = rset.getString(4);
            Commande cmd = new Commande(idCommande, id_utilisateur, dateCommande, etat);
            lesCommandes.add(cmd);
        }
        
        rset.close();
        pstmt.close();
    }
}
