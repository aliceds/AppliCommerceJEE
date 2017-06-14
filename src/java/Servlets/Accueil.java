/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Produit;
import static accesauxdonnees.CreationConnexion.creerConnexion;
import Beans.Utilisateur;
import accesauxdonnees.CreationConnexion;
import accesauxdonnees.DaoProduit;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modele.ModeleUtilisateur;

/**
 *
 * @author Alice
 */
public class Accueil extends HttpServlet {

    public static final String VUE = "/WEB-INF/index.jsp";
    public static final String LIST = "liste";
    public static final String ERREUR = "erreur";
    private List<Produit> listeProduits = new ArrayList<>();
    private DaoProduit leDaoProduit;
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int erreur = creerConnexion();
//        out.println("<!DOCTYPE html>");
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<title>Servlet NewServlet</title>");            
//        out.println("</head>");
//        out.println("<body>");
//        out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
//        out.println("</body>");
//        out.println("</html>");
        
        request.setAttribute(ERREUR, erreur);
        listeProduits.clear();
        leDaoProduit = CreationConnexion.getDaoProduit();
        try {
            leDaoProduit.recupererProduits(listeProduits);
            
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement : "+ex.getMessage());
        } 
        HttpSession session = request.getSession();
        System.out.println("email dans accueil : " + session.getAttribute("mailUtilisateur"));
        
        request.setAttribute(LIST, listeProduits);
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
