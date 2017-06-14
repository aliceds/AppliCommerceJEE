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
<section class="container">
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
        <!--
        <c:if test="${cart.lineItemCount==0}">
            <tr>
                <td colspan="4">- Cart is currently empty -<br/>
            </tr>
        </c:if>
        !-->
        <c:forEach var="cartItem" items="${cart.getCartItems()}">
            <form name="item" method="POST" action="servlet/CartController">
                <tr>
                    <td><c:out value="${cartItem['idProduit']}"/></td>
                    <input type="hidden" name="idProduit" value="<c:out value="${produit['idProduit']}"/>"/>
                    <td><c:out value="${cartItem['nomProduit']}"/></td>
                    <input type="hidden" name="nomProduit" value="<c:out value="${produit['nomProduit']}"/>"/>
                    <td><c:out value="${cartItem['quantite']}"/></td>
                    <input type="hidden" name="quantite" value="<c:out value="${produit['quantite']}"/>"/>
                    <td><c:out value="${cartItem['prixUnitaireHT']}"/> €</td>
                    <input type="hidden" name="idProduit" value="<c:out value="${produit['prixUnitaireHT']}"/>"/>
                    <td><c:out value="${cartItem['montant']}"/> €</td>
                    <input type="hidden" name="montant" value="<c:out value="${produit['montant']}"/>"/>
                    <td>
                        <button type="submit" name="action" value="supprimer" onclick="alert('Produit supprimé au panier !')"><i class="glyphicon glyphicon-trash"></i></button>
                    </td>
                </tr>
            </form>
        </c:forEach>
        <tr>
            <td colspan="3"></td>
            <td><em>Total</em></td>
            <td><strong>${cart.getOrderTotal()} €</strong></td>
        </tr>
    </table>
</section>
<jsp:include page="footer.jsp" flush="true">
    <jsp:param name="footer" value="footer" />
</jsp:include> 
