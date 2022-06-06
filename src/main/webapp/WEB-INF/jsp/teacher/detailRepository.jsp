<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ include file="../header.jsp"%>
<%@ include file="nav.jsp"%>

<div class="container">
    <div class="row align-items-center">
        <div class="col">

            <div class="container">
                <h2>Détail dépots</h2>

                    <div class="mb-3">
                        ${repository.name}
                        <ul>
                            <c:forEach items="${repository.subjects}" var="subject">
                                <li>${subject.name}</li>
                            </c:forEach>
                        </ul>
                    </div>
                <div><ul>
                <c:forEach items="${repository.works}" var="work">
                <form method="POST" action="/deleteWork">
                        ${work.title}
                    <button type="submit" class="btn btn-primary">supprimer projet</button>
                </form>
                </c:forEach>
                </ul></div>
            </div>
        </div>
    </div>
</div>
<%@ include file="../footer.jsp"%>