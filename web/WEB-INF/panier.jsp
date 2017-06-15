<%-- 
    Document   : panier
    Created on : 14 juin 2017, 09:33:33
    Author     : p1519286
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" flush="true">
    <jsp:param name="header" value="header" />
</jsp:include> 

<jsp:include page="menu.jsp" flush="true">
    <jsp:param name="menu" value="menu" />
</jsp:include>
    <h1>Mon Panier</h1>
    <table>
        <tr>
            <th>N° du produit</th>
            <th>Nom</th>
            <th>Quantité</th>
            <th>Prix unitaire</th>
            <th>Montant</th>
            <th>Supprimer</th>
        </tr>
        <jsp:useBean id="panier" scope="session" class="Beans.Panier" />
        <form name="item" method="POST" action="Accueil">
            <c:forEach var="cartItem" items="${cart.getCartItems()}">
                <tr>
                    <td><c:out value="${cartItem['idProduit']}"/></td>
                    <input type="hidden" name="idProduit" value="<c:out value="${cartItem['idProduit']}"/>"/>
                    <td><c:out value="${cartItem['nomProduit']}"/></td>
                    <input type="hidden" name="nomProduit" value="<c:out value="${cartItem['nomProduit']}"/>"/>
                    <td><c:out value="${cartItem['quantite']}"/></td>
                    <input type="hidden" name="quantite" value="<c:out value="${cartItem['quantite']}"/>"/>
                    <td><c:out value="${cartItem['prixUnitaireHT']}"/> €</td>
                    <input type="hidden" name="idProduit" value="<c:out value="${cartItem['prixUnitaireHT']}"/>"/>
                    <td><c:out value="${cartItem['montant']}"/> €</td>
                    <input type="hidden" name="montant" value="<c:out value="${cartItem['montant']}"/>"/>
                    <td>
                        <button type="submit" name="action" value="supprimer" onclick="alert('Produit supprimé au panier !')"><i class="glyphicon glyphicon-trash"></i></button>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="3"></td>
                <td><em>Total</em></td>
                <td><strong>${cart.getOrderTotal()} €</strong></td>
            </tr>
            <tr>
                <% if(session.getAttribute("mailUtilisateur") != null) { %>
                    <td colspan="2"><td>
                    <td colspan="2"><button type="submit" name="action" value="valider" onclick="alert('Commande enregistrée!')">
                            <i class="glyphicon glyphicon-ok"></i>
                            <strong>Valider la commande</strong></button>
                    </td>
                <% } else { %>
                <td><p>Il faut être connecté pour valider le panier.</p></td>
                <% } %>
            </tr> 
        </form>
    </table>
<jsp:include page="footer.jsp" flush="true">
    <jsp:param name="footer" value="footer" />
</jsp:include> 
