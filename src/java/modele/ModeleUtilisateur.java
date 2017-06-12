/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    // le conteneur de données
    private final List<Utilisateur> leConteneurUtilisateurs;
    // le titre des champs du conteneur
    //private final String[] titres;
    // l'objet DAO pour mettre à jour le conteneur
    private final DaoUtilisateur leDaoUtilisateur;

    public ModeleUtilisateur() {
        // définition du conteneur d'étudiants
        this.leConteneurUtilisateurs = new ArrayList<>();
        // définition des noms du champ
        //this.titres = new String[]{"Num", "Nom", "Prénom", "Civilité", "Date de naissance", "Lieu de naissance", "Role", "Statut", "Pays"};
        // récupération de l'objet DAO utilisé
        this.leDaoUtilisateur = CreationConnexion.getDaoUtilisateur();
    }

    public void insererUtilisateur(Utilisateur user) throws SQLException {
        leConteneurUtilisateurs.clear();
        leDaoUtilisateur.ajouterUtilisateur(user);
        chargerLesUtilisateurs();
    }

    public void chargerLesUtilisateurs() throws SQLException {
        leDaoUtilisateur.recupererUtilisateurs(leConteneurUtilisateurs);
        //this.fireTableDataChanged();
    }
    
    public boolean existeUtilisateur(String email, String motDePasse) throws SQLException {
        if (leDaoUtilisateur.existeUtilisateur(email, motDePasse) == 0)
            return false;
        return true;
    }
}
