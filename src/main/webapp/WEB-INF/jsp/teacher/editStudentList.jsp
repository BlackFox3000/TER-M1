<%@ page pageEncoding="UTF-8" %>
<%@ include file="../../header.jsp"%>
<%@ include file="../../headerProfile.jsp"%>

<div class="container">
    <h1>Gestion listes étudiants</h1>

    <!-- On défini le centre -->
    <div class="container">
        <div class="row align-items-center">
            <div class="col">

                <c:forEach items="${studentLists}" var="studentList">
                    <p>
                        ${studentList.id} ${studentList.name}
                        <select>
                            <option selected>Etudiants</option>
                            <c:forEach items="${studentLists.studentList}" var="student">
                                <option>${student.lastname} ${student.firstname}</option>
                            </c:forEach>
                        </select>
                        <a class="btn btn-primary" href="/teacher/editStudentList?id=${studentList.id}" role="button">Modifier</a>
                    </p>
                </c:forEach>

            </div>
        </div>
    </div>
</div>

<%@ include file="../../footer.jsp"%>