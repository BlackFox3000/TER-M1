<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>

<c:url var="bootstrap_css" value="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" />
<c:url var="bootstrap_js" value="/webjars/bootstrap/5.1.3/js/bootstrap.min.js" />
<c:url var="jquery_js" value="/webjars/jquery/3.5.1/jquery.min.js" />
<c:url var="css" value="/style.css" />

<html>
	<head>

        <title>Relecteurs AMU</title>
        <link rel="stylesheet" href="${css}">
        <link rel="stylesheet" href="${bootstrap_css}">
        <link rel="icon" type="image/png" sizes="16x16" href="https://is1-ssl.mzstatic.com/image/thumb/Purple116/v4/e7/1e/8b/e71e8b4d-6707-e9de-e59e-1054d974873c/source/256x256bb.jpg">
        <script src="${jquery_js}"></script>
        <script src="${bootstrap_js}"></script>
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
            <a class="navbar-brand" href="/admin/space">Mon espace</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
              <div class="navbar-nav">
                <a class="nav-link" href="/admin/addAssignement">Créer une attribution</a>
                <a class="nav-link" href="/admin/manageAssignement">Gestion Attribution</a>
                <a class="nav-link" href="/">Se deconnecter</a>
              </div>
            </div>


    <%
        }
    %>
    </nav>

</header>