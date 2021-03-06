<%-- 
    Document   : menu
    Created on : 9 juin 2017, 09:45:04
    Author     : Leen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Navbar -->
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav navbar-left">
                <li><a href="Accueil"><i class="glyphicon glyphicon-home"></i> Accueil</a></li>
            </ul>

            <!-- Champs de connexion et déconnexion -->
            <ul class="nav navbar-nav navbar-right">
                <% if(session.getAttribute("mailUtilisateur") != null) { %>
                <li><a href="CompteInfos"><i class="glyphicon glyphicon-user"></i> Mon compte</a></li>
                <% } %>
                <li><a href="Panier"><i class="glyphicon glyphicon-shopping-cart"></i> Mon Panier</a></li>
                <% if (session.getAttribute("mailUtilisateur") == null) { %>
                <li><a href="Connexion"><i class="glyphicon glyphicon-log-in"></i> Connexion</a></li>
                <% } %>
                <% if (session.getAttribute("mailUtilisateur") == null) {%>
                <li><a href="Inscription"><i class="glyphicon glyphicon-plus"></i> Inscription</a></li>
                <% } %>
                <% if (session.getAttribute("mailUtilisateur") != null) { %>
                <li><a href="Deconnexion"><i class="glyphicon glyphicon glyphicon-log-out"></i> Déconnexion</a></li>
                <% }%>
            </ul>
        </div>
    </div>
</nav>
<section class="container">