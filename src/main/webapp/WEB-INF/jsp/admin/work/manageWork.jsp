<%@ page pageEncoding="UTF-8" %>
<%@ include file="../../header.jsp"%>
<%@ include file="../nav.jsp"%>

<div class="container">
    <h1>Gestion projets</h1>

    <!-- On défini le centre -->
    <div class="container">
        <div class="row align-items-center">
            <div class="col">

                <c:forEach items="${works}" var="work">
                    <p>
                            ${work.title} ${work.statusW}
                        <select>
                            <option selected>Domaines</option>
                            <c:forEach items="${work.subjects}" var="subject">
                                <option>${subject.name}</option>
                            </c:forEach>
                        </select>
                        ${work.commentary}
                        <a class="btn btn-primary" href="/admin/editWork?id=${work.id}" role="button">Modifier</a>
                    </p>
                </c:forEach>

            </div>
        </div>
    </div>
</div>

<%@ include file="../../footer.jsp"%>