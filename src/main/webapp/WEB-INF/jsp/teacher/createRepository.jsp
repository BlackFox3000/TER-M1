<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ include file="../header.jsp"%>
<%@ include file="nav.jsp"%>

<div class="container">
    <div class="row align-items-center">
        <div class="col">

            <div class="container">
                <h2>Créer dépot</h2>

                <form method="POST" action="/createRepository">
                    <div class="mb-3">
                        <label for="name" class="form-label">Nom</label>
                        <input type="text" class="form-control" id="name" name="name" required="required" placeholder="${repository.name}">
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

                    <button type="submit" class="btn btn-primary">Créer dépôt</button>
                </form>
            </div>
        </div>
    </div>
</div>
<%@ include file="../footer.jsp"%>