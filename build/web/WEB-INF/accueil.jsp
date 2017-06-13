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
    
        <div class="container-fluid">
            <c:forEach items="${liste}" var="produit">
            <div class="row">
                <div class="col-sm-4" style="background-color:lavender;">${produit['nomProduit']}</div>
            </div>
        
    </c:forEach>
</div>
    <p>Vous pouvez vous inscrire ou vous connecter à votre compte en haut à droite de la fenêtre</p>
    <p>Une fois connecté-e, vous pourrez accéder à votre panier, vos informations personnelles et vos commandes passées.</p>

</section>
