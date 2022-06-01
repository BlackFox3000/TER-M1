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
    <div class="header-title" style="text-align:center; padding-bottom: 3vh;">
        <img width="200" height="100" src="https://upload.wikimedia.org/wikipedia/fr/thumb/d/d4/Aix-Marseille_Universit%C3%A9_%28Logo%29.svg/1200px-Aix-Marseille_Universit%C3%A9_%28Logo%29.svg.png" alt="logo-amu"/>
       <h1 style="color: black"> Site attribution de mémoires AMU </h1>
    </div>
</header>