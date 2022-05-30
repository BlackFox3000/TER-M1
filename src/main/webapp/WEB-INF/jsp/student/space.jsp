<%@ include file="../header.jsp"%>
Espace Etudiant

<!-- On défini le centre -->
<div id="form-add-work">
    <div class="container">
        <div class="row">
            <div class="col align-self-center">

                <h2>Deposer un memoire : </h2>

                <!-- On défini le formulaire -->
                <form method="POST" action="/addWork" enctype = "multipart/form-data">
                    <div class="">
                        <label for="name" class="form-label">Nom de votre mémoire</label>
                        <input type="text" class="form-control" id="name" aria-describedby="nameHelp">
                    </div>
                    <div class="mb-3">
                        <input type = "file" name = "Selectionner un fichier" size = "50" />
                    </div>
                    <div class="mb-3">
                        <select class="form-select" aria-label="selectSubject">
                            <option selected>Selectionner un depot</option>
                        <c:forEach items="${repositories}" var="repository">
                            <option value="${repository.id}">"${repository.name}"</option>
                        </c:forEach>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary">déposer mémoire</button>
                </form>
            </div>
        </div>
    </div>
</div>

<div id="list-works">
    <h2>Memoires deposes : </h2>
    <ul>
        <c:forEach items="${works}" var="work">
        <li>
            <c:out value="${work.title}" />
        </li>
        </c:forEach>
    </ul>
</div>
<%@ include file="../footer.jsp"%>