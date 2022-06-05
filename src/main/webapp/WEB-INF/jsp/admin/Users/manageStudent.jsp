<%@ page pageEncoding="UTF-8" %>
<%@ include file="../../header.jsp"%>
<%@ include file="../../headerProfile.jsp"%>

<div class="container">
    <h1>Gestion etudiant</h1>

    <!-- On défini le centre -->
    <div class="container">
        <div class="row align-items-center">
            <div class="col">

                <c:forEach items="${users}" var="user">
                    <p>
                    <form action="/admin/editWork" method="get">
                        ${user.id} ${user.firstname} ${user.lastname} ${user.email}
                        <select class="form-select" aria-label="Default select example">

                        <option selected>Sélectionner un projet</option>
                        <c:forEach items="${user.student.personnalWorks}" var="work">
                            <option value="${work.id}">${work.title}</option>

                        </c:forEach>
                        </select>
                        <button type="submit">Modifier</button>

                    </form>
                    <a class="btn btn-primary" href="/admin/editStudent?id=${user.id}" role="button">Modifier</a>
                    </p>
                </c:forEach>

            </div>
        </div>
    </div>
</div>

<%@ include file="../../footer.jsp"%>