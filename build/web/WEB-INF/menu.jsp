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
        <li><a href="Accueil">Accueil</a></li>
        <li><a href="compte.jsp">Mon compte</a></li>
        <li><a href="panier.jsp">Mon Panier</a></li>
      </ul>

      <!-- Champs de connexion et déconnexion -->
      <ul class="nav navbar-nav navbar-right">
        <!--<?php if (!isset($_SESSION['logged']) && !isset($_SESSION['user'])) { ?>-->
          <li><a href="Connexion">Connexion</a></li>
          <li><a href="Inscription">Inscription</a></li>
        <!--<?php } else { ?>-->
          <li><a href="Deconnexion">Déconnexion</a></li>
        <!--<?php } ?>-->
      </ul>
    </div>
  </div>
</nav>
