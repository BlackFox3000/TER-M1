<%@ include file="../../header.jsp"%>
<%@ include file="../nav.jsp"%>

<div class="container">
    <div class="row align-items-center">
        <div class="col">

            <div class="container">
                <h2>Creer un nouveau professeur</h2>

                <form method="POST" action="/admin/createTeacher">
                    <div class="mb-3">
                        <label for="firstname" class="form-label">Prenom</label>
                        <input type="text" name="firstname" class="form-control" id="firstname" required="required">
                    </div>
                    <div class="mb-3">
                        <label for="lastname" class="form-label">Nom</label>
                        <input type="text" name="lastname" class="form-control" id="lastname" required="required">
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Adresse mail</label>
                        <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                        <div id="emailHelp" class="form-text" id="email" required="required">
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Mot de passe</label>
                            <input type="password" name="password" class="form-control" id="password" required="required">
                        </div>

                        <div class="mb-3">
                            <c:forEach items="${subjects}" var="subject">
                                <div class="form-check">
                                    <input class="form-check-input" name="subject" type="checkbox" value="" id="${subject.id}">
                                    <label class="form-check-label" for="${subject.id}">
                                        ${subject.name}
                                    </label>
                                </div>
                            </c:forEach>
                        </div>
                        <button type="submit" class="btn btn-primary">creer professeur</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%@ include file="../../footer.jsp"%>