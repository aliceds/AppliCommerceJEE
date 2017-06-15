/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modele.ModelePanier;

/**
 *
 * @author p1519286
 */
public class Panier extends HttpServlet {
    private ModelePanier leModelePanier;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.getAttribute("mailUtilisateur");
        this.getServletContext().getRequestDispatcher("/WEB-INF/panier.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        leModelePanier = new ModelePanier();
        
        HttpSession session = request.getSession();
        session.getAttribute("mailUtilisateur");
        String strAction = request.getParameter("action");
        
        System.out.println("parametre : " + request.getParameter("action"));

        if (strAction.equals("Ajouter au panier")) {
            System.out.println("on a bien cliqué sur ajouter au panier");
            System.out.println(request.getParameter("nomProduit"));
            System.out.println(request.getParameter("idProduit"));
            leModelePanier.addToCart(request);
        } //else if (strAction.equals("Update")) {
//                leModelePanier.updateCart(request);
//            } else if (strAction.equals("Delete")) {
//                leModelePanier.deleteCart(request);
//            }
        response.sendRedirect(request.getContextPath() + "/Accueil");
    }
}
