<%@ page pageEncoding="UTF-8" %>
<%@ include file="../../header.jsp"%>
<%@ include file="../nav.jsp"%>

<div class="container">
    <h1>Modifier projet</h1>

    <!-- On défini le centre -->
    <div class="container">
        <div class="row align-items-center">
            <div class="col">
                    <p>
                        <form action="/admin/saveWork" method="get">
                            <input type="text" value="${work.title}">

                            <select class="form-select" aria-label="Default select example">

                            <option disabled>Sélectionner un dépot</option>

                            <c:forEach items="${repositories}" var="repository">
                                <c:if test='${fn:contains(work, repository.works)}'>
                                    <option value="${work.id}" selected>${work.title}</option>
                                </c:if>
                                <c:if test='${not fn:contains(work, repository.works)}'>
                                    <option value="${work.id}">${work.title}</option>
                                </c:if>

                            </c:forEach>
                            </select>

                            <button type="submit">Modifier</button>

                        </form>
                    </p>
            </div>
        </div>
    </div>
</div>

<%@ include file="../../footer.jsp"%>