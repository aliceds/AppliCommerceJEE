<%-- 
    Document   : compte
    Created on : 13 juin 2017, 10:17:12
    Author     : Leen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" flush="true">
    <jsp:param name="header" value="header" />
</jsp:include> 

<jsp:include page="menu.jsp" flush="true">
    <jsp:param name="menu" value="menu" />
</jsp:include>

<form method="post" action="CompteInfos">
    <fieldset>
        <table class="formulaire">
            <th colspan="2">Informations de votre compte</th>
            <tr>
                <td><label for="nom">Adresse email <span class="requis">*</span></label></td>
                <td><input type="email" id="email" name="email" value="<c:out value="${utilisateur.email}"/>" size="20" maxlength="60" /></td>
            <span class="erreur">${form.erreurs['email']}</span>
            </tr>

            <tr>
                <td><label for="motdepasse">Mot de passe <span class="requis">*</span></label></td>
                <td><input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" /></td>
            <span class="erreur">${form.erreurs['motdepasse']}</span>
            </tr>

            <tr>
                <td><label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label></td>
                <td><input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20"/></td>
            <span class="erreur">${form.erreurs['confirmation']}</span>
            </tr>

            <tr>
                <td><label for="nom">Nom<span class="requis">*</span></label></td>
                <td><input type="text" id="nom" name="nom" value="<c:out value="${utilisateur.nom}"/>" size="20" maxlength="20" /></td>
            <span class="erreur">${form.erreurs['nom']}</span>
            </tr>

            <tr>
                <td><label for="nom">Prénom<span class="requis">*</span></label></td>
                <td><input type="text" id="prenom" name="prenom" value="<c:out value="${utilisateur.prenom}"/>" size="20" maxlength="20" /></td>
            <span class="erreur">${form.erreurs['prenom']}</span>
            </tr>

            <tr>
                <td><label for="nom">Numéro de téléphone<span class="requis">*</span></label></td>
                <td><input type="text" id="num_tel" name="num_tel" value="<c:out value="${utilisateur.num_tel}"/>" size="20" maxlength="20" /></td>
            <span class="erreur">${form.erreurs['num_tel']}</span>
            </tr>

            <tr>
                <td></td>
                <td><input type="submit" value="Enregistrer les modifications" class="sansLabel" /></td>
            </tr>
        </table>

        <p class="indication"><span class="requis">Les champs marqués de * sont obligatoires</span></p>

        <%-- vérification de la présence d'un objet utilisateur en session --%>
        <c:if test="${!empty sessionScope.sessionUtilisateur}">
            <%-- si l'utilisateur existe en session, alors affichage adresse email --%>
            <p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionUtilisateur.email}</p>
        </c:if>

    </fieldset>
</form>

<a href="Commandes">Mes commandes</a>


<jsp:include page="footer.jsp" flush="true">
    <jsp:param name="footer" value="footer" />
</jsp:include> 
