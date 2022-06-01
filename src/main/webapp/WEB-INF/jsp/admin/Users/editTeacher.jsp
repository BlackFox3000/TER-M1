<%@ include file="../../header.jsp"%>
edit teacher
<div class="container">
    <div class="row align-items-center">
        <div class="col">

            <div class="container">
                <h2>Modifier enseignant</h2>

                <form method="POST" action="/createTeacher">
                    <div class="mb-3">
                        <label for="firstname" class="form-label">Prenom</label>
                        <input type="text" class="form-control" id="firstname" value="${teacher.firstname}">
                    </div>
                    <div class="mb-3">
                        <label for="lastname" class="form-label">Nom</label>
                        <input type="text" class="form-control" id="lastname" value="${teacher.lastname}">
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Adresse mail</label>
                        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" value="${teacher.email}">
                        <div id="emailHelp" class="form-text" id="email"></div>
					</div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Mot de passe</label>
                            <input type="email" class="form-control" id="password" value="${teacher.password}">
                        </div>
                        <div class="mb-3">
                            <c:forEach items="${subjects}" var="subject">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="${subject.id}"
                                <% if (${teacher}.getSubjects().contains(${subject}) { %>
                                     checked>
                                <% } else { %>
                                    >
                                <% } %>
                                    <label class="form-check-label" for="${subject.id}">
                                        ${subject.name}
                                    </label>
                                </div>
                            </c:forEach>
                        </div>
                        <button type="submit" class="btn btn-primary">creer administrateur</button>
                </form>
            </div>
        </div>
    </div>
</div>
<%@ include file="../../footer.jsp"%>