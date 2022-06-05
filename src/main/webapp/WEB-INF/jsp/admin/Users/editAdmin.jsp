<%@ include file="../../header.jsp"%>
<%@ include file="../nav.jsp"%>
<div class="container">
    <div class="row align-items-center">
        <div class="col">

            <div class="container">
                <h2>Modifier Admin</h2>

                <form method="POST" action="/createTeacher">
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Adresse mail</label>
                        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" value="${user.email}">
                        <div id="emailHelp" class="form-text" id="email"></div>
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Mot de passe</label>
                        <input type="email" class="form-control" id="password" value="${user.password}">
                    </div>
                    <button type="submit" class="btn btn-primary">modifier administrateur</button>
                </form>
            </div>
        </div>
    </div>
</div>
<%@ include file="../../footer.jsp"%>