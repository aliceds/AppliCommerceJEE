/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

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
    private List<String> listeInfos = new ArrayList<>();
    private DaoUtilisateur leDaoUtilisateur;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet CompteInfos</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet CompteInfos at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        listeInfos.clear();
        leDaoUtilisateur = CreationConnexion.getDaoUtilisateur();
        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession(true);
        System.out.println("email=" + request.getParameter("mailUtilisateur"));
//        try {
//            leDaoUtilisateur.recupererUtilisateur(listeInfos, session.getAttribute("idUtilisateur"));
//            System.out.println(session.getAttribute("idUtilisateur"));
//        } catch (SQLException ex) {
//            System.out.println("erreur lors du chargement : "+ex.getMessage());
//        }       
        
        request.setAttribute(LIST, listeInfos);
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
