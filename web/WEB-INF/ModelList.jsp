<%--
    Document   : ModelList
    Created on : 14 juin 2017, 09:33:49
    Author     : p1519286
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<p>Model List</p>
<a href="/ShoppingCart.jsp" mce_href="ShoppingCart.jsp">View Cart</a>
<p/>
<table width="75%" border="1">
  <tr>
    <td><form name="modelDetail1" method="POST" action="servlet/CartController">
            Model:
       <input type="hidden" name="modelNo" value="TF-MODEL1">
      <p>Description:
        <input type="hidden" name="description" value="Tech-Freaks imaginary model 1."></p>
      <p>Quantity:<input type="text" size="2" value="1" name="quantity"></p>
      <p>Price:
        $10.00<input type="hidden" name="price" value="10"></p><input type="hidden" name="action" value="add"><input type="submit" name="addToCart" value="Add To Cart">
      </form></td>
  </tr>
</table>
</body>
</html>
