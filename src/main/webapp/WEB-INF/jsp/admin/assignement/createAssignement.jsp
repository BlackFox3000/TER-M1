<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../header.jsp"%>
<%@ include file="../../headerProfile.jsp"%>


<div class="container" xmlns:form="http://www.w3.org/1999/xhtml">
    <div class="row align-items-center">
        <div class="col">

            <div class="container">
                <h2>Creer une nouvelle attribution</h2>

                <!-- Selectionner un depot -->
                <form method="GET" action="createAssignement">
                    <div class="mb-3">
                        <label for="name" class="form-label">Nom</label>
                        <input type="text" class="form-control" id="name" name="name" required="required">
                    </div>

                    <p>Sélection de dépot</p>
                    <div class="mb-3">
                        <div class="row">
                            <div class="col">
                                <!-- Dropdawn for select repo-->
                                <select class="form-select" aria-label="Default select example" id="chooseRepositories" onchange="testBtn()">
                                    <option selected value="none" disabled>Selectionner un dépot</option>
                                    <c:forEach items="${repositories}" var="repository">
                                        <option value="${repository.id}" id="repo-${repository.id}"
                                        >${repository.name}</option>
                                    </c:forEach>
                                </select>
                                <button onclick="addRepo($('#chooseRepositories option:selected'))" type="button" id="btn" disabled>
                                    ajouter
                                </button>
                            </div>
                            <div class="col">
                                <!-- visualizer of select repo-->
                                <p>Dépots sélectionnés</p>
                                <div id="repoList">

                                </div>
                            </div>

                        </div>
                    </div>

                    <p>Sélection d'enseignant</p>
                    <div class="mb-3">
                        <div class="row">
                            <div class="col">
                                <!-- Dropdawn for select profeseur-->
                                <select class="form-select" aria-label="Default select example" id="chooseTeachers" onchange="testBtnTC()">
                                    <option selected value="none" disabled>Selectionner un enseignant</option>
                                    <c:forEach items="${teachers}" var="teacher">
                                        <option value="${teacher.id}" id="teach-${teacher.id}"
                                        >${teacher.lastname} ${teacher.firstname}</option>
                                    </c:forEach>
                                </select>
                                <button onclick="addTeach($('#chooseTeachers option:selected'))" type="button" id="btnTC" disabled>
                                    ajouter
                                </button>
                            </div>
                            <div class="col">
                                <!-- visualizer of select teacher-->
                                <p>Enseignants sélectionnés</p>
                                <div id="teachList">

                                </div>
                            </div>

                        </div>
                    </div>

                    <button type="submit" class="btn btn-primary">Creer attribution</button>
                    <script>
                        /* FCT : Repository */
                        function testBtn(){
                            if($('#chooseRepositories option:selected').val()!="none"){
                                document.getElementById('btn').disabled=false;
                            }else{
                                document.getElementById('btn').disabled=true;
                            }
                        }

                        function addRepo(repo){
                            repo.hide();
                            /* /!\ Must not be split in more lines /!\ */
                            var check = '<div class="form-check" id="repo-div-'+repo.val()+'"><input class="form-check-input" name="repository_list" type="checkbox" id="repo-c-'+repo.val()+'" value="'+repo.val()+'" onchange="removeRepo('+repo.val()+')" checked><label class="form-check-label" /*for="repo-c-'+repo.val()+'"*/ >'+repo.text()+'</label></div>'
                            $("#repoList").append(check);
                            $('#chooseRepositories').prop('selectedIndex',0);
                            testBtn();
                        }

                        function removeRepo(id){
                            $("#repo-"+id).show();
                            $("#repo-div-"+id).remove();
                            testBtn();
                        }
                    </script>
                    <script>
                        /* FCT : Teacher */
                        function testBtnTC(){
                            if($('#chooseTeachers option:selected').val()!="none"){
                                document.getElementById('btnTC').disabled=false;
                            }else{
                                document.getElementById('btnTC').disabled=true;
                            }
                        }

                        function addTeach(teach){
                            teach.hide();
                            /* /!\ Must not be split in more lines /!\ */
                            var check = '<div class="form-check" id="teach-div-'+teach.val()+'"><input class="form-check-input" name="teacher_list" type="checkbox" id="teach-c-'+teach.val()+'" value="'+teach.val()+'" onchange="removeTeach('+teach.val()+')" checked><label class="form-check-label" /*for="teach-c-'+teach.val()+'"*/ >'+teach.text()+'</label></div>'
                            $("#teachList").append(check);
                            $('#chooseTeachers').prop('selectedIndex',0);
                            testBtnTC();
                        }

                        function removeTeach(id){
                            $("#teach-"+id).show();
                            $("#teach-div-"+id).remove();
                            testBtnTC();
                        }
                    </script>
                </form>
            </div>
        </div>
    </div>
</div>
<%@ include file="../../footer.jsp"%>