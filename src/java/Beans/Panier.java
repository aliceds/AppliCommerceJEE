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

    public void deleteCartItem(String strItemIndex) {
        int itemIndex = 0;
        try {
            itemIndex = Integer.parseInt(strItemIndex);
            alCartItems.remove(itemIndex - 1);
            calculateOrderTotal();
        } catch (NumberFormatException nfe) {
            System.out.println("Error while deleting cart item: " + nfe.getMessage());
            nfe.printStackTrace();
        }
    }

    public void addCartItem(int idProduit, String nomProduit, float prixUnitaireHT, int quantite, String lienImage) {
        ItemPanier cartItem = new ItemPanier();
        //dblTotalCost = dblUnitCost * iQuantity;
        cartItem.setIdProduit(idProduit);
        cartItem.setNomProduit(nomProduit);
        cartItem.setPrixUnitaireHT(prixUnitaireHT);
        cartItem.setQuantite(quantite);
        cartItem.setMontant(quantite*prixUnitaireHT);
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
