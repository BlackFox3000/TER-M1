<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ include file="../header.jsp"%>
<%@ include file="../headerProfile.jsp"%>
<%@ include file="nav.jsp"%>
<div class="container">
    <div class="row align-items-center">
        <div class="col">

            <div class="container">
                <h2>Modifier dépots</h2>

                <form method="POST" action="/saveRepository">
                    <div class="mb-3">
                        <label for="name" class="form-label">Nom</label>
                        <input type="text" class="form-control" id="name" name="name" required="required" placeholder="${repository.name}">
                    </div>
                    <div class="mb-3">
                        <c:forEach items="${subjects}" var="subject">
                            <div class="form-check">
                                <c:if test='${fn:contains(repository.subjects, subject)}'>
                                    <input class="form-check-input" name="subject" type="checkbox" value="" id="${subject.id}" checked>
                                </c:if>
                                <c:if test='${not fn:contains(repository.subjects, subject)}'>
                                    <input class="form-check-input" name="subject" type="checkbox" value="" id="${subject.id}">
                                </c:if>
                                <label class="form-check-label" for="${subject.id}">
                                    ${subject.name}
                                </label>
                            </div>
                        </c:forEach>
                    </div>

                    <button type="submit" class="btn btn-primary">Enregistrer modifications</button>
                </form>
            </div>
        </div>
    </div>
</div>
<%@ include file="../footer.jsp"%>
