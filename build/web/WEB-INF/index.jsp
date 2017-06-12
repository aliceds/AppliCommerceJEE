<%-- 
    Document   : index
    Created on : 9 juin 2017, 09:40:56
    Author     : Leen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" flush="true">
    <jsp:param name="header" value="header" />
</jsp:include>

<jsp:include page="menu.jsp" flush="true">
    <jsp:param name="menu" value="menu" />
</jsp:include> 

<jsp:include page="accueil.jsp" flush="true">
    <jsp:param name="accueil" value="accueil" />
</jsp:include>

<jsp:include page="footer.jsp" flush="true">
    <jsp:param name="footer" value="footer" />
</jsp:include> 