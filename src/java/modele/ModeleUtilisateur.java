package modele;

import accesauxdonnees.CreationConnexion;
import accesauxdonnees.DaoUtilisateur;
import Beans.Utilisateur;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alice
 */
public class ModeleUtilisateur {

    private final List<Utilisateur> leConteneurUtilisateurs;
    private final DaoUtilisateur leDaoUtilisateur;

    public ModeleUtilisateur() {
        this.leConteneurUtilisateurs = new ArrayList<>();
        this.leDaoUtilisateur = CreationConnexion.getDaoUtilisateur();
    }

    public void insererUtilisateur(Utilisateur user) throws SQLException {
        leConteneurUtilisateurs.clear();
        leDaoUtilisateur.ajouterUtilisateur(user);
        chargerLesUtilisateurs();
    }
    
    public void modifierUtilisateur(Utilisateur user) throws SQLException {
        leDaoUtilisateur.modifierUtilisateur(user);
    }

    public void chargerLesUtilisateurs() throws SQLException {
        leDaoUtilisateur.recupererUtilisateurs(leConteneurUtilisateurs);
    }
    
    public boolean existeUtilisateur(String email, String motDePasse) throws SQLException {
        return leDaoUtilisateur.existeUtilisateur(email, motDePasse) != 0;
    }
}
