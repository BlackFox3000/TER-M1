<%@ include file="../../header.jsp"%>
<%@ include file="../nav.jsp"%>
<div class="container">
    <div class="row align-items-center">
        <div class="col">

            <div class="container">
                <h2>Creer un nouveau domaine</h2>

                <form action="/admin/createSubject" method="POST">
                    <div class="mb-3">
                        <label for="name" class="form-label">Nom</label>
                        <input type="text" name="name" class="form-control" id="name" required="required">
                    </div>

                    <button type="submit" class="btn btn-primary">Ajouter un domaine</button>
                </form>
            </div>

            <div class="container">
                <ul class="list-group">
                    <c:forEach items="${subjects}" var="subject">
                        <li class="list-group-item">${subject.name}</li>
                    </c:forEach>
                </ul>
            <div>

        </div>
    </div>
</div>
<%@ include file="../../footer.jsp"%>