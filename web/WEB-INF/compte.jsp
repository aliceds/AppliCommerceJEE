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
    <c:forEach items="${listeInfos}" var="infos">
        <div class="row">
            <tr>
                <td class="col-sm-4">${infos}</td><td class="col-sm-4"><input type="email" id="email" name="email" value="<c:out value="${infos}"/>" size="20" maxlength="60" disable/></td>
            </tr>
        </div>
        
    </c:forEach>
</table>
<jsp:include page="footer.jsp" flush="true">
    <jsp:param name="footer" value="footer" />
</jsp:include> 
