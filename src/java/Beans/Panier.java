/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.ArrayList;

/**
 *
 * @author p1519286
 */
public class Panier {

    private ArrayList alCartItems = new ArrayList();
    private double dblOrderTotal;

    public int getLineItemCount() {
        return alCartItems.size();
    }

//    public void deleteCartItem(String strItemIndex) {
//        int iItemIndex = 0;
//        try {
//            iItemIndex = Integer.parseInt(strItemIndex);
//            alCartItems.remove(iItemIndex - 1);
//            calculateOrderTotal();
//        } catch (NumberFormatException nfe) {
//            System.out.println("Error while deleting cart item: " + nfe.getMessage());
//            nfe.printStackTrace();
//        }
//    }

//    public void updateCartItem(String strItemIndex, String strQuantity) {
//        double dblTotalCost = 0.0;
//        double dblUnitCost = 0.0;
//        int iQuantity = 0;
//        int iItemIndex = 0;
//        ItemPanier cartItem = null;
//        try {
//            iItemIndex = Integer.parseInt(strItemIndex);
//            iQuantity = Integer.parseInt(strQuantity);
//            if (iQuantity > 0) {
//                cartItem = (ItemPanier) alCartItems.get(iItemIndex - 1);
//                dblUnitCost = cartItem.getUnitCost();
//                dblTotalCost = dblUnitCost * iQuantity;
//                cartItem.setQuantity(iQuantity);
//                cartItem.setTotalCost(dblTotalCost);
//                calculateOrderTotal();
//            }
//        } catch (NumberFormatException nfe) {
//            System.out.println("Error while updating cart: " + nfe.getMessage());
//            nfe.printStackTrace();
//        }
//
//    }

    public void addCartItem(int idProduit, String nomProduit, float prixUnitaireHT, String infosProduits, String parfum, String type, String lienImage) {
        ItemPanier cartItem = new ItemPanier();
        //dblTotalCost = dblUnitCost * iQuantity;
        cartItem.setIdProduit(idProduit);
        cartItem.setNomProduit(nomProduit);
        cartItem.setPrixUnitaireHT(prixUnitaireHT);
        cartItem.setInfosProduits(infosProduits);
        cartItem.setParfum(parfum);
        cartItem.setType(type);
        cartItem.setLienImage(lienImage);
        alCartItems.add(cartItem);
        calculateOrderTotal();
    }

    public void addCartItem(ItemPanier cartItem) {
        alCartItems.add(cartItem);
    }

    public ItemPanier getCartItem(int iItemIndex) {
        ItemPanier cartItem = null;
        if (alCartItems.size() > iItemIndex) {
            cartItem = (ItemPanier) alCartItems.get(iItemIndex);
        }
        return cartItem;
    }

    public ArrayList getCartItems() {
        return alCartItems;
    }

    public void setCartItems(ArrayList alCartItems) {
        this.alCartItems = alCartItems;
    }

    public double getOrderTotal() {
        return dblOrderTotal;
    }

    public void setOrderTotal(double dblOrderTotal) {
        this.dblOrderTotal = dblOrderTotal;
    }

    protected void calculateOrderTotal() {
        double dblTotal = 0;
        for (int counter = 0; counter < alCartItems.size(); counter++) {
            ItemPanier cartItem = (ItemPanier) alCartItems.get(counter);
            dblTotal += cartItem.getPrixUnitaireHT();

        }
        setOrderTotal(dblTotal);
    }
}
