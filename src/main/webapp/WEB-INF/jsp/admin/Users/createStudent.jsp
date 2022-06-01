<%@ include file="../../header.jsp"%>
<%@ include file="../../headerProfile.jsp"%>
create student
<div class="container">
	<div class="row align-items-center">
		<div class="col">

			<div class="container">
				<h2>Creer un nouveau etudiant</h2>

				<form method="POST" action="/createStudent">
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
			</div>
		</div>
	</div>
</div>
<%@ include file="../../footer.jsp"%>