/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Utilisateur;
import accesauxdonnees.CreationConnexion;
import static accesauxdonnees.CreationConnexion.creerConnexion;
import accesauxdonnees.DaoUtilisateur;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Leen
 */
public class CompteInfos extends HttpServlet {
    
    public static final String VUE = "/WEB-INF/compte.jsp";
    public static final String LIST = "listeInfos";
    public static final String ERREUR = "erreur";
    private DaoUtilisateur leDaoUtilisateur;
    private Utilisateur user;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();

        leDaoUtilisateur = CreationConnexion.getDaoUtilisateur();
        user = new Utilisateur();
        user.setEmail((String) session.getAttribute("mailUtilisateur"));
        
        try {
            leDaoUtilisateur.recupererUtilisateur(user, user.getEmail());
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement : "+ex.getMessage());
        }       
        
        
        request.setAttribute("utilisateur", user);
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        leDaoUtilisateur = CreationConnexion.getDaoUtilisateur();
        user = new Utilisateur();
        user.setEmail((String) request.getParameter("email"));
        user.setMotDePasse((String) request.getParameter("motdepasse"));
        user.setNom((String) request.getParameter("nom"));
        user.setPrenom((String) request.getParameter("prenom"));
        user.setNum_tel((String) request.getParameter("num_tel"));
        System.out.println("nom : " + (String) request.getParameter("email"));
        try {
            leDaoUtilisateur.modifierUtilisateur(user);
            HttpSession session = request.getSession();
            session.setAttribute("mailUtilisateur", user.getEmail());
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement : "+ex.getMessage());
        }       
        
        
        request.setAttribute("utilisateur", user);
        
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }

}
