package accesauxdonnees;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 *
 * @author Alice
 */
public class CreationConnexion {

    private static DaoUtilisateur daoUtilisateur;
    private static DaoProduit daoProduit;
    private static DaoCommande daoCommande;
    private static int etatSortie = 0;

    // les accesseurs aux DAO utilisés par l'application
    public static DaoUtilisateur getDaoUtilisateur() {
        return daoUtilisateur;
    }
    public static DaoProduit getDaoProduit() {
        return daoProduit;
    }
    public static DaoCommande getDaoCommande() {
        return daoCommande;
    }

    public static int creerConnexion() {
        // les variables locales
        DataSource laSourceDeDonnees;
        Connection laConnexion = null;
        
        // Etablissement de la connexion à la base MariaDB avec affichage de la fenetre d'identification 
        try {
            laSourceDeDonnees = SourceMariaDB.getSource();
            laConnexion = laSourceDeDonnees.getConnection();
        } catch (Exception ex) {
            System.out.println("erreur lors de la connexion" + ex.getMessage());
            etatSortie = 1;
        }
        // Instanciation des objets nécessaires à l'application
        try {
            // les DAO nécessaires
            daoUtilisateur = new DaoUtilisateur(laConnexion);
            daoProduit = new DaoProduit(laConnexion);
            daoCommande = new DaoCommande(laConnexion);
        } catch (SQLException ex) {
            System.out.println("erreur lors de la création du DAO" + ex.getMessage());
            etatSortie = 1;
        }
        
        return etatSortie;
    }

}
