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

//    public void deleteCart(HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        String strItemIndex = request.getParameter("itemIndex");
//        Panier cartBean = null;
//
//        Object objCartBean = session.getAttribute("cart");
//        if (objCartBean != null) {
//            cartBean = (Panier) objCartBean;
//        } else {
//            cartBean = new Panier();
//        }
//        cartBean.deleteCartItem(strItemIndex);
//    }

//    public void updateCart(HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        String strQuantity = request.getParameter("quantity");
//        String strItemIndex = request.getParameter("itemIndex");
//
//        Panier panier = null;
//
//        Object objPanier = session.getAttribute("cart");
//        if (objPanier != null) {
//            panier = (Panier) objPanier;
//        } else {
//            panier = new Panier();
//        }
//        panier.updateCartItem(strItemIndex, strQuantity);
//    }

    public void addToCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println("parametres dans addToCart : " + request.getParameter("idProduit"));
        int idProduit = Integer.parseInt(request.getParameter("idProduit"));
        String nomProduit = request.getParameter("nomProduit");
        float prixUnitaireHT = Float.parseFloat(request.getParameter("prixUnitaireHT"));
        String infosProduits = request.getParameter("infosProduits");
        String parfum = request.getParameter("parfum");
        String type = request.getParameter("type");
        String lienImage = request.getParameter("lienImage");
        
        System.out.println("on entre bien dans addToCart");

        Panier panier = null;

        Object objPanier = session.getAttribute("cart");

        if (objPanier != null) {
            panier = (Panier) objPanier;
        } else {
            panier = new Panier();
            session.setAttribute("cart", panier);
        }

        panier.addCartItem(idProduit, nomProduit, prixUnitaireHT, infosProduits, parfum, type, lienImage);
    }
}
