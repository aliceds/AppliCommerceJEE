package modele;

import Beans.Commande;
import Beans.Utilisateur;
import accesauxdonnees.CreationConnexion;
import accesauxdonnees.DaoCommande;
import accesauxdonnees.DaoUtilisateur;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author p1519286
 */
public class ModeleCommandes {
    
    private final List<Commande> lesCommandes;
    private final DaoCommande leDaoCommandes;

    public ModeleCommandes() {
        this.lesCommandes = new ArrayList<>();
        this.leDaoCommandes = CreationConnexion.getDaoCommande();
    }
    
    public void recupererLesCommandes(String email) throws SQLException {
        DaoUtilisateur leDaoUtilisateur = CreationConnexion.getDaoUtilisateur();
        Utilisateur user = new Utilisateur();
        user.setEmail(email);
        try {
            leDaoUtilisateur.recupererUtilisateur(user, user.getEmail());
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement : "+ex.getMessage());
        }
        
        leDaoCommandes.recupererCommandes(lesCommandes, user.getId_utilisateur());
    }

    public List<Commande> getLesCommandes() {
        return lesCommandes;
    }
}
