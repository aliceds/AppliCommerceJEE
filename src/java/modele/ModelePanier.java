/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import Beans.Panier;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author p1519286
 */
public class ModelePanier {
    
    public ModelePanier() {
        
    }

    public void addToCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        int idProduit = Integer.parseInt(request.getParameter("idProduit"));
        String nomProduit = request.getParameter("nomProduit");
        float prixUnitaireHT = Float.parseFloat(request.getParameter("prixUnitaireHT"));
        int quantite = 1;//Integer.parseInt(request.getParameter("quantite"));
        String lienImage = request.getParameter("lienImage");

        Panier panier;

        Object objPanier = session.getAttribute("cart");

        if (objPanier != null) {
            panier = (Panier) objPanier;
        } else {
            panier = new Panier();
            session.setAttribute("cart", panier);
        }

        panier.addCartItem(idProduit, nomProduit, prixUnitaireHT, quantite, lienImage);
    }
}
