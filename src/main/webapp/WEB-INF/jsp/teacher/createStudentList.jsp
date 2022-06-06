<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ include file="../header.jsp"%>
<%@ include file="nav.jsp"%>
<div class="container">
    <div class="row align-items-center">
        <div class="col">

            <div class="container">
                <h2>Créer une liste d'étudiant</h2>

                <form method="POST" action="/createStudentList">
                    <div class="mb-3">
                        <label for="name" class="form-label">Nom</label>
                        <input type="text" class="form-control" id="name" name="name" required="required" placeholder="${repository.name}">
                    </div>
                  <div>
                    <p>Sélection d'étudiants</p>
                    <div class="mb-3">
                        <div class="row">
                            <div class="col">
                                <!-- Dropdawn for select student-->
                                <select class="form-select" aria-label="Default select example" id="chooseStudents" onchange="testBtnTC()">
                                    <option selected value="none" disabled>Selectionner un étudiant</option>
                                    <c:forEach items="${students}" var="student">
                                        <option value="${student.id}" id="teach-${student.id}"
                                        >${student.lastname} ${student.firstname}</option>
                                    </c:forEach>
                                </select>
                                <button onclick="addStudent($('#chooseStudents option:selected'))" type="button" id="btnTC" disabled>
                                    ajouter
                                </button>
                            </div>
                            <div class="col">
                                <!-- visualizer of select teacher-->
                                <p>Etudiant sélectionnés</p>
                                <div id="studentList">

                                </div>
                            </div>

                        </div>
                    </div>
                  </div>
                    <button type="submit" class="btn btn-primary">Créer</button>
                </form>
            </div>
            <script>
                        /* FCT : Student */
                        function testBtnTC(){
                            if($('#chooseStudents option:selected').val()!="none"){
                                document.getElementById('btnTC').disabled=false;
                            }else{
                                document.getElementById('btnTC').disabled=true;
                            }
                        }

                        function addStudent(student){
                            student.hide();
                            /* /!\ Must not be split in more lines /!\ */
                            var check = '<div class="form-check" id="student-div-'+student.val()+'"><input class="form-check-input" name="student_list" type="checkbox" id="student-c-'+student.val()+'" value="'+student.val()+'" onchange="removeStudent('+student.val()+')" checked><label class="form-check-label" /*for="student-c-'+student.val()+'"*/ >'+student.text()+'</label></div>'
                            $("#studentList").append(check);
                            $('#chooseStudents').prop('selectedIndex',0);
                            testBtnTC();
                        }

                        function removeStudent(id){
                            $("#student-"+id).show();
                            $("#student-div-"+id).remove();
                            testBtnTC();
                        }
                    </script>
        </div>
    </div>
</div>

<%@ include file="../footer.jsp"%>