package accesauxdonnees;

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
public class DaoUtilisateur {
    private final Connection connexion;

    public DaoUtilisateur(Connection connexion) throws SQLException {
        this.connexion = connexion;
    }

    public void recupererUtilisateurs(List<Utilisateur> lesUtilisateurs) throws SQLException {
        String requete = "select * from utilisateur";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        while (rset.next()) {       // traitement du résulat
            int id_utilisateur = rset.getInt(1);
            String email = rset.getString(2);
            String motDePasse = rset.getString(3);
            String nom = rset.getString(4);
            String prenom = rset.getString(5);
            String num_tel = rset.getString(6);
            LocalDate date_inscription = rset.getDate(7).toLocalDate();
            Utilisateur temp = new Utilisateur(id_utilisateur, email, motDePasse, nom, prenom, num_tel, date_inscription);
            lesUtilisateurs.add(temp);
        }
        rset.close();
        pstmt.close();
    }
    
    public void modifierUtilisateur(Utilisateur utilisateur) throws SQLException {
        String requete = "update utilisateur set email=?, mot_de_passe=?, nom=?, prenom=?, num_tel=? where email='" + utilisateur.getEmail() +"'";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setString(1, utilisateur.getEmail());
        pstmt.setString(2, utilisateur.getMotDePasse());
        pstmt.setString(3, utilisateur.getNom());
        pstmt.setString(4, utilisateur.getPrenom());
        pstmt.setString(5, utilisateur.getNum_tel());
        pstmt.executeUpdate();
        pstmt.close();
    }
    
    public void ajouterUtilisateur(Utilisateur utilisateur) throws SQLException {
        String requete = "insert into utilisateur (email, mot_de_passe, nom, prenom, num_tel, date_inscription) values(?,?,?,?,?,?)";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setString(1, utilisateur.getEmail());
        pstmt.setString(2, utilisateur.getMotDePasse());
        pstmt.setString(3, utilisateur.getNom());
        pstmt.setString(4, utilisateur.getPrenom());
        pstmt.setString(5, utilisateur.getNum_tel());
        pstmt.setDate(6, java.sql.Date.valueOf(utilisateur.getDate_inscription()));
        pstmt.executeUpdate();
        pstmt.close();
    }
    
    public int existeUtilisateur(String email, String motDePasse) throws SQLException {
        int resultat = 0;

        String requete = "select email from utilisateur where email= '" + email + "' and mot_de_passe='" + motDePasse + "'";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        
        ResultSet rset = pstmt.executeQuery(requete);
        while (rset.next()) {       // traitement du résulat
            resultat++;
        }
        pstmt.close();
        
        return resultat;
    }
    
    public void recupererUtilisateur(Utilisateur utilisateur, String email) throws SQLException {
        String requete = "select * from utilisateur where email= '"+email+"'";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        while (rset.next()) { 
            utilisateur.setId_utilisateur(rset.getInt(1));
            utilisateur.setEmail(rset.getString(2));
            utilisateur.setMotDePasse(rset.getString(3));
            utilisateur.setNom(rset.getString(4));
            utilisateur.setPrenom(rset.getString(5));
            utilisateur.setNum_tel(rset.getString(6));
            utilisateur.setDate_inscription(rset.getDate(7).toLocalDate());
        }
        
        rset.close();
        pstmt.close();
    }
}
