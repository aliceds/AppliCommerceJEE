<%-- 
    Document   : accueil
    Created on : 9 juin 2017, 09:46:29
    Author     : Leen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<section class="container">

    <h1>Bienvenue sur notre site</h1>
    
    <p>Vous pouvez vous inscrire ou vous connecter à votre compte en haut à droite de la fenêtre</p>
    <p>Une fois connecté-e, vous pourrez accéder à votre panier, vos informations personnelles et vos commandes passées.</p>
    
    <div class="container">
        <h2>Confiseries que nous vendons</h2>
        <ul class="list-group">
            <c:forEach items="${liste}" var="produit">
            <li class="list-group-item">
                <table class="table-produit">
                <tr>

                    <td><p class="nomproduit"><c:out value="${produit['nomProduit']}"/></p>
                    <input type="hidden" size="2" value="1" name="quantity">
                    <p class="prixUnitaireHT"><c:out value="${produit['prixUnitaireHT']}"/> €</p> 
                    <img class="images" src="IMAGES/<c:out value="${produit['lienImage']}"/>"/></td>
                    <td><p class="description"><c:out value="${produit['infosProduits']}"/></p></td>
                <tr>
                </table>
            </li>
            </c:forEach>
        </ul>
    </div>

</section>
