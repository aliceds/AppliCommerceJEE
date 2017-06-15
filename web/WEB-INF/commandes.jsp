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
<div class="container">
    <h2>Vos commandes</h2>
    <ul class="list-group">
        <c:forEach items="${listeCommandes}" var="cmd">
            <li class="list-group-item">
                <table class="table-produit">
                    <input type="hidden" name="numeroCommande" value="<c:out value="${cmd['numeroCommande']}"/>"/>
                    <tr>
                    <input type="hidden" name="dateCommande" value="<c:out value="${cmd['dateCommande']}"/>"/>
                    <input type="hidden" name="etat" value="<c:out value="${cmd['etat']}"/>"/>
                    </tr>
                    <tr>
                        <td class="col-md-6"><p>Commande n° : ${cmd['numeroCommande']}</p></td>
                    </tr>
                    <tr>
                        <td class="col-md-6"><p>Date de la commande : ${cmd['dateCommande']}</p></td>
                    </tr>
                    <tr>
                        <td class="col-md-6"><p>Etat : ${cmd['etat']}</p></td>
                    </tr>
                </table>
            </li>
        </c:forEach>
        
            
</div>  
<jsp:include page="footer.jsp" flush="true">
    <jsp:param name="footer" value="footer" />
</jsp:include> 
