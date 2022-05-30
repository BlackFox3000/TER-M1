<%@ include file="../header.jsp"%>
Espace Admin

<!-- On défini le centre -->
<div class="container">
	<div class="row align-items-center">
		<div class="col">

			<div class="container">
				<h2>Gestion création</h2>
				<div class="d-grid gap-2 col-6 mx-auto">
					<a class="btn btn-primary" href="addAdmin" role="button">Ajouter un nouveau administrateur</a>
					<a class="btn btn-primary" href="addTeacher" role="button">Ajouter un nouveau professeur</a>
					<a class="btn btn-primary" href="addStudent" role="button">Ajouter un nouveau etudiant</a>

					<a class="btn btn-primary" href="addSubject" role="button">Ajouter un nouveau domaine</a>
					<a class="btn btn-primary" href="addAssignement" role="button">Creer une attribution</a>
				</div>
			</div>

			<div class="container">
				<div class="container">
					<h2>Gestion Utilisateurs</h2>
					<div class="d-grid gap-2 col-6 mx-auto">
						<a class="btn btn-primary" href="manageAdmin" role="button">Gestion administrateurs</a>
						<a class="btn btn-primary" href="manageTeacher" role="button">Gestion professeurs</a>
						<a class="btn btn-primary" href="manageStudent" role="button">Gestion etudiants</a>
					</div>
				</div>

				<div class="container">
					<h2>Autres gestions</h2>
					<div class="d-grid gap-2 col-6 mx-auto">
						<a class="btn btn-primary" href="manageSubject" role="button">Gestion domaines</a>
					</div>
				</div>

				<div class="container">
					<h2>Gestion projets*</h2>
					<div class="d-grid gap-2 col-6 mx-auto">
						<a class="btn btn-primary" href="manageWork" role="button">Gestion projets</a>
						<a class="btn btn-primary" href="manageRepository" role="button">Gestion depots</a>
						<a class="btn btn-primary" href="manageAssignement" role="button">Gestion attributions</a>
					</div>
					<p>Mémoire ou rapport de stage</p>
				</div>
			</div>

		</div>
	</div>
</div>

<%@ include file="../footer.jsp"%>