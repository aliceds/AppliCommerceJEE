<%-- 
    Document   : deconnexion
    Created on : 9 juin 2017, 16:04:49
    Author     : Leen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" flush="true">
    <jsp:param name="header" value="header" />
</jsp:include> 

<jsp:include page="menu.jsp" flush="true">
    <jsp:param name="menu" value="menu" />
</jsp:include> 

    <div class ="row">
        <p classe="indication">Vous avez été correctement déconnecté</p>
    </div>

<jsp:include page="footer.jsp" flush="true">
    <jsp:param name="footer" value="footer" />
</jsp:include> 
