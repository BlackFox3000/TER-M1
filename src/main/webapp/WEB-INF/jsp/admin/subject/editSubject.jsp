<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../header.jsp"%>
<%@ include file="../../headerProfile.jsp"%>

<div class="container">
    <div class="row align-items-center">
        <div class="col">

            <div class="container">
                <h2>Modifier sujet</h2>

                <form method="POST" action="/saveSubject">
                    <div class="mb-3">
                        <label for="name" class="form-label">Nom</label>
                        <input type="text" class="form-control" id="name" name="name" required="required" placeholder="${subject.name}">
                    </div>

                    <button type="submit" class="btn btn-primary">Enregistrer modifications</button>
                </form>
            </div>
        </div>
    </div>
</div>
<%@ include file="../../footer.jsp"%>