<%@ include file="../header.jsp"%>
create admin
<div class="container">
	<div class="row align-items-center">
		<div class="col">

			<div class="container">
				<h2>Creer un nouveau administrateur</h2>

				<form method="POST" action="/createAdmin">
					<div class="mb-3">
						<label for="exampleInputEmail1" class="form-label">Adresse mail</label>
						<input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
						<div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
					</div>
					<div class="mb-3">
						<label for="password" class="form-label">Mot de passe</label>
						<input type="email" class="form-control" id="password">
					</div>
					<div class="mb-3">
						<label for="securekey" class="form-label">Cle de securite</label>
						<input type="email" class="form-control" id="securekey">
					</div>
					<button type="submit" class="btn btn-primary">creer administrateur</button>
				</form>
			</div>
		</div>
	</div>
</div>
<%@ include file="../footer.jsp"%>