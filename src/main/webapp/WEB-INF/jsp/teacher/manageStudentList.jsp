<%@ page pageEncoding="UTF-8" %>
<%@ include file="../header.jsp"%>
<%@ include file="nav.jsp"%>
<div class="container">
    <h1>Gestion listes étudiants</h1>

    <!-- On défini le centre -->
    <div class="container">
        <div class="row align-items-center">
            <div class="col">

                <c:forEach items="${studentLists}" var="studentList">
                    <p>
                        ${studentList.id} ${studentList.name}
                        <a class="btn btn-primary" href="/teacher/editStudentList?id=${studentList.id}" role="button">Modifier</a>
                        <a class="btn btn-primary" href="/teacher/deleteStudentList?id=${studentList.id}" role="button">Supprimer</a>
                    </p>
                </c:forEach>

            </div>
        </div>
    </div>
</div>

<%@ include file="../footer.jsp"%>