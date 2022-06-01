<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid d-flex justify-content-center py-3">
        <ul class="nav nav-pills">
                <%
        if (request.getParameter("space") == null) {

    %>
                <%
        } else if (request.getParameter("space").equals("student")) {
    %>
            <a class="navbar-brand nav-link active" href="/student/space?space=student">Mon espace</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
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
                </div>
            </div>

                <%
        }
    %>
    </div>
    </ul>
</nav>
