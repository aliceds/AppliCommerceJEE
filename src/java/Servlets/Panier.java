package Servlets;

import java.io.IOException;
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

        if (strAction.equals("Ajouter au panier")) {
            leModelePanier.addToCart(request);
        }
        
        response.sendRedirect(request.getContextPath() + "/Accueil");
    }
}
