<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
    rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

<c:url var="bootstrap_css" value="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" />
<c:url var="bootstrap_js" value="/webjars/bootstrap/5.1.3/js/bootstrap.min.js" />
<c:url var="jquery_js" value="/webjars/jquery/3.5.1/jquery.min.js" />
<c:url var="css" value="style.css" />

<html>
	<head>
        <meta charset="UTF-8">
        <title>Relecteurs AMU</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="${css}">
        <link rel="stylesheet" href="${bootstrap_css}">
        <link rel="icon" type="image/png" sizes="16x16" href="https://is1-ssl.mzstatic.com/image/thumb/Purple116/v4/e7/1e/8b/e71e8b4d-6707-e9de-e59e-1054d974873c/source/256x256bb.jpg">
        <script src="${jquery_js}"></script>
        <script src="${bootstrap_js}"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    </head>
    <body>

<%@ include file="navbar.jsp"%>

<header style="margin-top: 8vh; background-color: #35C3E7">
    <div class="header-title" style="text-align:center">
       <h1> Site attribution de mémoires AMU </h1>
    </div>

    <div class="container">
        <header class="d-flex justify-content-center py-3">
            <ul class="nav nav-pills">
                <li class="nav-item"><a href="#" class="nav-link active" aria-current="page">Home</a></li>
                <li class="nav-item"><a href="#" class="nav-link">Features</a></li>
                <li class="nav-item"><a href="#" class="nav-link">Pricing</a></li>
                <li class="nav-item"><a href="#" class="nav-link">FAQs</a></li>
                <li class="nav-item"><a href="#" class="nav-link">About</a></li>
            </ul>
        </header>
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
                <a class="nav-link" href="/">Se deconnecter</a>
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
                <a class="nav-link" href="/">Se deconnecter</a>
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
                <a class="nav-link" href="/">Se deconnecter</a>
              </div>
            </div>


    <%
        }
    %>
    </nav>

</header>