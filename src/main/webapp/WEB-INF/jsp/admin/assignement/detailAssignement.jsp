<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../header.jsp"%>
<%@ include file="../nav.jsp"%>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<div class="container" xmlns:form="http://www.w3.org/1999/xhtml">
    <div class="row align-items-center">
        <div class="col">

            <div class="container">
                <h2>Détail attribution</h2>

                <div class="alert alert-warning" role="alert">
                    <p>Une seule modification autorisée par ré-attribution de projet. </p>
                    <p>Les autres modifications ne seront pas sauvegardées au rechargement de la page</p>
                </div>
                <!-- Selectionner un depot -->
                <div class="mb-3">
                    <c:forEach items="${works}" var="work">
                        <div class="row">
                            <div class="col">
                                ${work.title}
                            </div>
                            <div class="col">
                                <form method="GET" action="editAssignement">
                                    <select class="form-select selectTeach" aria-label="Default select example"
                                            id="attributeTeacher"
                                            onchange="this.nextSibling.nextSibling.hidden = false">
                                        <option value="none" disabled>Selectionner un enseignant</option>
                                        <c:forEach items="${teachers}" var="teacher">

                                            <c:if test='${fn:contains(work.canceledTeachers, teacher.teacher)}'>
                                                <option value="${teacher.id}" id="teach-${work.id}-${teacher.id}"
                                                        style="background: #d26767;color: black;"
                                                        disabled>
                                                    <div class="alert alert-danger" role="alert">
                                                        ${teacher.lastname} ${teacher.firstname}
                                                    </div>
                                                </option>
                                            </c:if>

                                            <c:if test='${not fn:contains(work.canceledTeachers, teacher.teacher)}'>
                                                <c:if test='${fn:contains(teacher.teacher.supportedWorks,work)}'>
                                                    <option value="${teacher.id}" id="teach-${work.id}-${teacher.id}"
                                                            selected>${teacher.lastname} ${teacher.firstname}
                                                    </option>
                                                </c:if>
                                                <c:if test='${not fn:contains(teacher.teacher.supportedWorks,work)}'>
                                                    <option value="${teacher.id}" id="teach-${work.id}-${teacher.id}">
                                                        ${teacher.lastname} ${teacher.firstname}
                                                    </option>
                                                </c:if>
                                            </c:if>

                                        </c:forEach>
                                    </select>
                                    <button type="submit" class="btn btn-primary" hidden>Ré-Attribuer le projet</button>
                                </form>
                            </div>

                            <div class="col">
                                <p>${teacher.lastname}</p>
                            </div>
                            <div class="col">
                                <p>${teacher.firstname}</p>
                            </div>
                            <div class="col">
                                <p>${teacher.lastname}</p>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <script>
                   function AYS(){
                    swal({
                      title: "Confirmation",
                      text: "Vous êtes sur le point de quitter la page. Assurez-vous de sauvegarder toutes les modifications!",
                      icon: "warning",
                      buttons:  {cancel: "Rester", confirm: "Quitter"},
                      dangerMode: true,
                    })
                    .then((exit) => {
                      if (exit) {
                           // pas le temps de le voir
                            swal("Réponse validée!", {
                                                         icon: "success",
                                                    });
                            document.location.href="/admin/space"
                      }
                    }
                    );
                   }

                </script>
                <a class="btn btn-primary" role="button" onclick="AYS()">Quitter</a>

            </div>
        </div>
    </div>
</div>
