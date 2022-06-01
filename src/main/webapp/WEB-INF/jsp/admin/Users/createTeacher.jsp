<%@ include file="../../header.jsp"%>
create teacher
<div class="container">
	<div class="row align-items-center">
		<div class="col">

			<div class="container">
				<h2>Creer un nouveau professeur</h2>

				<form method="POST" action="/createTeacher">
					<div class="mb-3">
						<label for="firstname" class="form-label">Prenom</label>
						<input type="text" class="form-control" id="firstname">
					</div>
					<div class="mb-3">
						<label for="lastname" class="form-label">Nom</label>
						<input type="text" class="form-control" id="lastname">
					</div>
					<div class="mb-3">
						<label for="exampleInputEmail1" class="form-label">Adresse mail</label>
						<input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
						<div id="emailHelp" class="form-text" id="email">
					</div>
					<div class="mb-3">
						<label for="password" class="form-label">Mot de passe</label>
						<input type="email" class="form-control" id="password">
					</div>
					<button type="submit" class="btn btn-primary">creer administrateur</button>
				</form>
				<div class="mb-3">
                    <div class="form-check">
                         <c:forEach items="${subjects}" var="subject">
                              <input class="form-check-input" type="checkbox" value="" id="${subject.id}">
                              <label class="form-check-label" for="${subject.id}">
                                ${subject.name}
                              </label>
                         </c:forEach>
                    </div>
                </div>
			</div>
		</div>
	</div>
</div>
<%@ include file="../../footer.jsp"%>