<%@ page pageEncoding="UTF-8" %>
<%@ include file="../../header.jsp"%>
<%@ include file="../../headerProfile.jsp"%>

<div class="container">
    <h1>Gestion professeurs</h1>

    <!-- On défini le centre -->
    <div class="container">
        <div class="row align-items-center">
            <div class="col">

                <c:forEach items="${users}" var="user">
                    <p>
                        ${user.id} ${user.firstname} ${user.lastname} ${user.email}

                        <select class="form-select" aria-label="Default select example">
                            <option selected>Liste domaines</option>
                            <c:forEach items="${user.teacher.subjects}" var="subject">
                                <option value="${subject.id}">${subject.name}</option>
                            </c:forEach>
                        </select>
                    <form action="/admin/editRepository" method="get">
                        <select class="form-select" aria-label="Default select example" onchange="$('#btn-repo').show()">
                            <option selected disabled>Sélectionner un dépot</option>
                            <c:forEach items="${user.teacher.repositories}" var="repository">
                                <option value="${repository.id}">${repository.name}</option>
                            </c:forEach>
                        </select>
                        <button type="submit" id="btn-repo" style="display: none;">Modifier</button>
                    </form>
                    <form action="/admin/editWork" method="get">
                        <select class="form-select" name="id" aria-label="Default select example" onchange="$('#btn-work').show()">
                            <option selected disabled>Sélectionner un projet</option>
                            <c:forEach items="${user.teacher.supportedWorks}" var="work">
                                <option value="${work.id}">${work.title}</option>
                            </c:forEach>
                        </select>
                        <button type="submit" id="btn-work" style="display: none;">Modifier</button>
                    </form>
                    <select class="form-select" aria-label="Default select example">

                        <option selected name="id" disabled>Liste de liste étudiantes</option>
                        <c:forEach items="${user.teacher.studentLists}" var="studentList">
                            <option value="${studentList.id}">${studentList.name}</option>
                        </c:forEach>
                    </select>
                    <a class="btn btn-primary" href="/admin/editTeacher?id=${user.id}" role="button">Modifier</a>

                    </p>
                </c:forEach>


            </div>
        </div>
    </div>
</div>

<%@ include file="../../footer.jsp"%>