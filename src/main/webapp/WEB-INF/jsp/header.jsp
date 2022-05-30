<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
    rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

<c:url var="jquery_js" value="/webjars/jquery/3.5.1/jquery.min.js" />
<c:url var="css" value="/style.css" />

<html>
	<head>
	<meta charset="UTF-8">
	<title>Spring boot application</title>
	<link rel="stylesheet" href="${css}">
	<link rel="stylesheet" href="${bootstrap_css}">
	<script src="${jquery_js}"></script>
	<script src="${bootstrap_js}"></script>
</head>
<body>
<header>
    <div class="header-title" style="text-align:center">
       <h1> Site attribution de mémoires AMU <h1>
    </div>

            <nav class="navbar navbar-expand-lg bg-light">
              <div class="container-fluid">

    <%
        if (request.getParameter("space") == null) {

    %>
    <%
        } else if (request.getParameter("space").equals("student")) {
    %>
            <a class="navbar-brand" href="/student/space?space=student">Mon espace</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
              <div class="navbar-nav">
                <a class="nav-link disabled">Se deconnecter</a>
              </div>
            </div>
    <%
            } else if (request.getParameter("space").equals("teacher")) {
    %>
            <a class="navbar-brand" href="/">Mon espace</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
              <div class="navbar-nav">
                <a class="nav-link" href="#">Gestion dépots</a>
                <a class="nav-link" href="#">Gestion listes étudiants</a>
                <a class="nav-link disabled">Se deconnecter</a>
              </div>
            </div>
    <%
            } else if (request.getParameter("space").equals("admin")) {
    %>
            <a class="navbar-brand" href="/">Mon espace</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
              <div class="navbar-nav">
               <!-- <a class="nav-link active" aria-current="page" href="#">Home</a> --!>
                <a class="nav-link" href="#">Créer une attribution</a>
                <a class="nav-link" href="#">Gestion Attribution</a>
                <a class="nav-link disabled">Se deconnecter</a>
              </div>
            </div>


    <%
        }
    %>
        </nav>

</header>