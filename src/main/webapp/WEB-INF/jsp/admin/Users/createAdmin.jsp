<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../header.jsp"%>
<%@ include file="../../headerProfile.jsp"%>
create admin
<div class="container">
	<div class="row align-items-center">
		<div class="col">

			<div class="container">
				<h2>Créer un nouvel administrateur</h2>

				<form method="POST" action="/createAdmin">
					<div class="mb-3">
						<label for="exampleInputEmail1" class="form-label">Adresse mail</label>
						<input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="required">
						<div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
					</div>
					<div class="mb-3">
						<label for="password" class="form-label">Mot de passe</label>
						<input type="email" class="form-control" id="password" required="required">
					</div>
					<div class="mb-3">
						<label for="securekey" class="form-label">Clé de securite</label>
						<input type="password" class="form-control" id="securekey" required="required">
					</div>
					<button type="submit" class="btn btn-primary">Ajouter un admin</button>
				</form>
			</div>
		</div>
	</div>
</div>
<%@ include file="../../footer.jsp"%>