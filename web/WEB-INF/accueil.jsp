<%-- 
    Document   : accueil
    Created on : 9 juin 2017, 09:46:29
    Author     : Leen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<section class="container">

    <h1>Bienvenue sur notre site</h1>
    <p>Nous faisons [TO DO]</p> 
    <p>Connexion à la base : ${erreur}</p>
        
            <div class="container">
                <h2>Basic List Group</h2>
                <ul class="list-group">
                    <c:forEach items="${liste}" var="produit">
                    <li class="list-group-item">
                        <p class="nomproduit"><c:out value="${produit['nomProduit']}"/></p>
                        <input type="hidden" size="2" value="1" name="quantity">
                        <p class="prixUnitaireHT"><c:out value="${produit['prixUnitaireHT']}"/> €</p> 
                        <img class="images" src="IMAGES/<c:out value="${produit['lienImage']}"/>"/>
                    </li>
                    </c:forEach>
                </ul>
            </div>

        
    <p>Vous pouvez vous inscrire ou vous connecter à votre compte en haut à droite de la fenêtre</p>
    <p>Une fois connecté-e, vous pourrez accéder à votre panier, vos informations personnelles et vos commandes passées.</p>

</section>
