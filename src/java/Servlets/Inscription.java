/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Utilisateur;
import Forms.InscriptionForm;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.ModeleUtilisateur;

/**
 *
 * @author Alice
 */
public class Inscription extends HttpServlet {

    public static final String ATT_USER = "utilisateur";
    public static final String ATT_FORM = "form";
    public static final String VUE = "/WEB-INF/inscription.jsp";
    private ModeleUtilisateur leModeleUtilisateur;
    private Map<String, String> erreurs = new HashMap<String, String>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // affichage de la page d'inscription
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // préparation de l'objet formulaire
        InscriptionForm form = new InscriptionForm();

        //appel au traitement et à la validation de la requête, et récupération du bean en résultant
        Utilisateur utilisateur = form.inscrireUtilisateur(request);

        if (form.getErreurs().isEmpty()) {
            leModeleUtilisateur = new ModeleUtilisateur();
            try {
                leModeleUtilisateur.chargerLesUtilisateurs();
            } catch (SQLException ex) {
                erreurs.put("chargement", "erreur au chargement" + ex.getMessage());
            }

            try {
                leModeleUtilisateur.insererUtilisateur(utilisateur);
            } catch (SQLException ex) {
                erreurs.put("insertion", "erreur à l'insertion" + ex.getMessage());
            }
        }

        //
        request.setAttribute("erreurs", erreurs);

        //Stockage du formulaire et du bean dans l'objet request
        request.setAttribute(ATT_FORM, form);
        request.setAttribute(ATT_USER, utilisateur);

        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
