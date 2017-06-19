package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modele.ModeleCommandes;

/**
 *
 * @author p1519286
 */
public class Commandes extends HttpServlet {
    private ModeleCommandes leModeleCommandes;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        leModeleCommandes = new ModeleCommandes();
        try {
            leModeleCommandes.recupererLesCommandes((String) session.getAttribute("mailUtilisateur"));
        } catch (SQLException ex) {
            System.out.println("erreur de chargement des commandes : " + ex.getMessage());
        }
        request.setAttribute("listeCommandes", leModeleCommandes.getLesCommandes());
        this.getServletContext().getRequestDispatcher("/WEB-INF/commandes.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
