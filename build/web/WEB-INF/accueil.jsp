<%-- 
    Document   : accueil
    Created on : 9 juin 2017, 09:46:29
    Author     : Leen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <h1>Bienvenue sur notre site !</h1>
    
    <p>Nos confiseries sont de qualité artisanale, 100% naturelles et 100% françaises !</p>
    <p>Vous pouvez vous inscrire ou vous connecter à votre compte en haut à droite de la fenêtre.</p>
    <p>Une fois connecté-e, vous pourrez accéder à votre panier, vos informations personnelles et vos commandes passées.</p>
    
    <div class="container">
        <h2>Confiseries que nous vendons</h2>
        <ul class="list-group">
            <c:forEach items="${liste}" var="produit">
            <li class="list-group-item">
                <table class="table-produit">
                    <form method="post" action="Panier">
                        <input type="hidden" name="idProduit" value="<c:out value="${produit['idProduit']}"/>"/>
                        <tr>
                            <td rowspan="4" class="col-md-2"><img class="images" src="IMAGES/<c:out value="${produit['lienImage']}"/>"/></td>
                            <input type="hidden" name="lienImage" value="<c:out value="${produit['lienImage']}"/>"/>
                            <td class="col-md-6"><strong><c:out value="${produit['nomProduit']}"/></strong></td>
                            <input type="hidden" name="nomProduit" value="<c:out value="${produit['nomProduit']}"/>"/>
                            <input type="hidden" name="prixUnitaireHT" value="<c:out value="${produit['prixUnitaireHT']}"/>"/>
                            <td class="col-md-3"><strong><c:out value="${produit['prixUnitaireHT']}"/> €</strong></td>
                        </tr>
                        <tr>
                            <td class="col-md-6"><p>Type : ${produit['type']}</p></td>
                            <td class="col-md-3"><input type="submit" name="action" value="Ajouter au panier" onclick="alert('Produit ajouté au panier !')"/></td>
                        </tr>
                        <tr>
                            <td class="col-md-6"><p>Parfum : ${produit['parfum']}</p></td>
                        </tr>
                        <tr>
                            <td class="col-md-6"><p>Description : ${produit['infosProduits']}</p></td>
                        </tr>
                    </form>
                </table>
            </li>
            </c:forEach>
        </ul>
    </div>

