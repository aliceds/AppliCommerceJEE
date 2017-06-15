<%-- 
    Document   : Commandes
    Created on : 15 juin 2017, 12:50:28
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
<% if(session.getAttribute("mailUtilisateur") != null) { %>
    <h2>Vos commandes</h2>
    <ul class="list-group">
        <c:forEach items="${listeCommandes}" var="cmd">
            <li class="list-group-item">
                <table class="table-produit">
                    <input type="hidden" name="numeroCommande" value="<c:out value="${cmd['numeroCommande']}"/>"/>
                    <input type="hidden" name="dateCommande" value="<c:out value="${cmd['dateCommande']}"/>"/>
                    <input type="hidden" name="etat" value="<c:out value="${cmd['etat']}"/>"/>
                    <tr>
                        <td class="col-md-3"><p>Commande n° : ${cmd['numeroCommande']}</p></td>
                        <td class="col-md-3"><p>Date de la commande : ${cmd['dateCommande']}</p></td>
                        <td class="col-md-3"><p>Etat : ${cmd['etat']}</p></td>
                    </tr>
                </table>
                <table class="panier">
                    <input type="hidden" name="idProduit" value="<c:out value="${cmd.itemCommande['idProduit']}"/>"/>
                    <input type="hidden" name="nomProduit" value="<c:out value="${cmd.itemCommande['nomProduit']}"/>"/>
                    <input type="hidden" name="quantite" value="<c:out value="${cmd.itemCommande['quantite']}"/>"/>
                    <input type="hidden" name="prixUnitaireHT" value="<c:out value="${cmd.itemCommande['prixUnitaireHT']}"/>"/>
                    <tr>
                        <td><em>N° produit</em></td>
                        <td><em>Nom</em></td>
                        <td><em>Quantité</em></td>
                        <td><em>Montant</em></td>
                    </tr>
                    <tr>
                        <td><p>${cmd.itemCommande['idProduit']}</p></td>
                        <td><p>${cmd.itemCommande['nomProduit']}</p></td>
                        <td><p>${cmd.itemCommande['quantite']}</p></td>
                        <td><p>${cmd.itemCommande['montant']}</p></td>
                    </tr>
                </table>
            </li>
        </c:forEach>
<% } else {%>
    <p>Veuillez vous connecter pour accéder à cette page.</p>
<% } %>
<jsp:include page="footer.jsp" flush="true">
    <jsp:param name="footer" value="footer" />
</jsp:include> 
