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
<table class="container">
    <th colspan="2" class="row">Vos informations</th>
    <tr class="row">
        
    </tr>
    <c:forEach items="${liste}" var="infos">
        <div class="row">
            <div class="col-sm-4" style="background-color:lavender;">${infos['nomProduit']}</div>
        </div>
        
    </c:forEach>
</table>
<jsp:include page="footer.jsp" flush="true">
    <jsp:param name="footer" value="footer" />
</jsp:include> 
