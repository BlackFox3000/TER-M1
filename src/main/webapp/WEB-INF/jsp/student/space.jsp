<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ include file="../header.jsp"%>
<%@ include file="nav.jsp"%>

<!-- On défini le centre -->
<div id="form-add-work">
    <div class="container">
        <div class="row">
            <div class="col align-self-center">

                <h2>Déposer un memoire : </h2>

                <!-- On défini le formulaire -->
                <form method="POST" action="/student/space" enctype = "multipart/form-data">
                    <div class="">
                        <label for="name" class="form-label">Nom de votre mémoire</label>
                        <input type="text" name="title" class="form-control" id="name" aria-describedby="nameHelp">
                    </div>
                    <div class="mb-3">
                        <input type = "file" name = "Selectionner un fichier" size = "50" />
                    </div>
                    <div class="mb-3">
                        <select class="form-select" aria-label="selectSubject">
                            <option selected>Selectionner un depot</option>
                        <c:forEach items="${repositories1}" var="repository">
                            <option name=repository value="${repository.id}">"${repository.name}"</option>
                        </c:forEach>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary">Déposer un mémoire</button>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="container" id="list-works">
    <div class="row align-items-center">
        <h2>Mémoires déposés : </h2>
        <div class="col">
            <ul>
                <c:forEach items="${works}" var="work">
                    <li>
                        <c:out value="${work.title}" />
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
<%@ include file="../footer.jsp"%>