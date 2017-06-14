<%-- 
    Document   : panier
    Created on : 14 juin 2017, 09:33:33
    Author     : p1519286
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>Shopping Cart</p>
        <p><a href="/ModelList.jsp" mce_href="ModelList.jsp">Model List</a> </p>
        <table width="75%" border="1">
            <tr >
                <td>Model Description</td>
                <td>Quantity</td>
                <td>Unit Price</td>
                <td>Total</td>
            </tr>
            <jsp:useBean id="panier" scope="session" class="Beans.Panier" />
            <!--
            <c:if test="${cart.lineItemCount==0}">
                <tr>
                    <td colspan="4">- Cart is currently empty -<br/>
                </tr>
            </c:if>
            !-->
            <c:forEach var="cartItem" items="${cart.getCartItems()}">
                <form name="item" method="POST" action="servlet/CartController">
                    <tr>
                        <td><c:out value="${cartItem['nomProduit']}"/></td>
                    </tr>
                </form>
            </c:forEach>
        </table>
    </body>
</html>
