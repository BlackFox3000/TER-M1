<%@ include file="../../header.jsp"%>
<%@ include file="../nav.jsp"%>
<div class="container">
    <div class="row align-items-center">
        <div class="col">

            <div class="container">
                <h2>Modifier enseignant</h2>

                <form method="POST" action="/createTeacher">
                    <div class="mb-3">
                        <label for="firstname" class="form-label">Prenom</label>
                        <input type="text" class="form-control" id="firstname" placeholder="${user.firstname}">
                    </div>
                    <div class="mb-3">
                        <label for="lastname" class="form-label">Nom</label>
                        <input type="text" class="form-control" id="lastname" placeholder="${user.lastname}">
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Adresse mail</label>
                        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="${user.email}">
                        <div id="emailHelp" class="form-text" ></div>
					</div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Mot de passe</label>
                            <input type="password" class="form-control" id="password" placeholder="${user.password}">
                        </div>
                        <div class="mb-3">
                            <c:forEach items="${subjects}" var="subject">
                                <div class="form-check">
                                    <c:if test='${fn:contains(user.teacher.subjects, subject)}'>
                                        <input name="subjects[]" class="form-check-input" type="checkbox" value="${subject.id}" id="${subject.id}" checked>
                                    </c:if>
                                    <c:if test='${not fn:contains(user.teacher.subjects, subject)}'>
                                        <input name="subjects[]" class="form-check-input" type="checkbox" value="${subject.id}" id="${subject.id}" >
                                    </c:if>
                                    <label class="form-check-label" for="${subject.id}">
                                        ${subject.name}
                                    </label>
                                </div>
                            </c:forEach>
                        </div>
                        <button type="submit" class="btn btn-primary">modifier enseignant</button>
                </form>
            </div>
        </div>
    </div>
</div>
<%@ include file="../../footer.jsp"%>