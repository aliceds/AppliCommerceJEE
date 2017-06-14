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
                <form method="post" action="Panier">
                    <input type="hidden" name="idProduit" value="<c:out value="${produit['idProduit']}"/>"/>
                    <td><input type="text" name="nomProduit" value="<c:out value="${produit['nomProduit']}"/>"/>
                    <input type="text"  name="prixUnitaireHT" value="<c:out value="${produit['prixUnitaireHT']}"/>"/> €
                    <img class="images" src="IMAGES/<c:out value="${produit['lienImage']}"/>"/></td>
                    <input type="hidden" name="lienImage" value="<c:out value="${produit['lienImage']}"/>"/>
                    <td><input type="text"  name="infosProduits" value="<c:out value="${produit['infosProduits']}"/>"/>
                        <label>Type : </label>
                        <input type="text"  name="type" value="<c:out value="${produit['type']}"/>"/>
                        <label>Parfum : </label>
                        <input type="text"  name="parfum" value="<c:out value="${produit['parfum']}"/>"/>
                        <input type="submit" name="action" value="ajouter au panier"/></td>
                </form>
                <tr>
                </table>
            </li>
            </c:forEach>
        </ul>
    </div>

</section>
