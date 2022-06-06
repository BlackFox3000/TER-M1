<%@ page pageEncoding="UTF-8" %>
<%@ include file="../../header.jsp"%>
<%@ include file="../nav.jsp"%>

<div class="container">
    <h1>Gestion domaines</h1>

    <!-- On défini le centre -->
    <div class="container">
        <div class="row align-items-center">
            <div class="col">

                <c:forEach items="${subjects}" var="subject">
                    <p>
                        ${subject.name}
                        <a class="btn btn-primary" href="/admin/editSubject?id=${subject.id}" role="button">Modifier</a>
                    </p>
                </c:forEach>

            </div>
        </div>
    </div>
</div>

<%@ include file="../../footer.jsp"%>