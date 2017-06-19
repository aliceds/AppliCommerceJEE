package Servlets;

import Beans.Produit;
import static accesauxdonnees.CreationConnexion.creerConnexion;
import accesauxdonnees.CreationConnexion;
import accesauxdonnees.DaoProduit;
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
 * @author Alice
 */
public class Accueil extends HttpServlet {

    public static final String VUE = "/WEB-INF/index.jsp";
    public static final String LIST = "liste";
    public static final String ERREUR = "erreur";
    private final List<Produit> listeProduits = new ArrayList<>();
    private DaoProduit leDaoProduit;
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int erreur = creerConnexion();
        
        request.setAttribute(ERREUR, erreur);
        listeProduits.clear();
        leDaoProduit = CreationConnexion.getDaoProduit();
        try {
            leDaoProduit.recupererProduits(listeProduits);
            
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement : "+ex.getMessage());
        } 
        HttpSession session = request.getSession();
        
        request.setAttribute(LIST, listeProduits);
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
    }

}
