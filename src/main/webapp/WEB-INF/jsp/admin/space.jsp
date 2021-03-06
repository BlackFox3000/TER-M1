<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ include file="../header.jsp"%>
<%@ include file="nav.jsp"%>

<!-- On défini le centre -->
<div class="container">
	<div class="row align-items-center">
		<div class="col">

			<a class="btn btn-primary" href="/admin/faker" role="button">Simuler les données</a>

			<div class="container">
				<h2>Gestion création</h2>
				<div class="d-grid gap-2 col-6 mx-auto">
					<a class="btn btn-primary" href="/admin/addAdmin" role="button">Ajouter un nouvel administrateur</a>
					<a class="btn btn-primary" href="/admin/addTeacher" role="button">Ajouter un nouveau professeur</a>
					<a class="btn btn-primary" href="/admin/addStudent" role="button">Ajouter un nouvel etudiant</a>

					<a class="btn btn-primary" href="/admin/addSubject" role="button">Ajouter un nouveau domaine</a>
					<a class="btn btn-primary" href="/admin/addAssignement" role="button">Creer une attribution</a>
				</div>
			</div>

			<div class="container">
				<div class="container">
					<h2>Gestion Utilisateurs</h2>
					<div class="d-grid gap-2 col-6 mx-auto">
						<a class="btn btn-primary" href="/admin/manageAdmin" role="button">Gestion administrateurs</a>
						<a class="btn btn-primary" href="/admin/manageTeacher" role="button">Gestion professeurs</a>
						<a class="btn btn-primary" href="/admin/manageStudent" role="button">Gestion étudiants</a>
					</div>
				</div>

				<div class="container">
					<h2>Autres gestions</h2>
					<div class="d-grid gap-2 col-6 mx-auto">
						<a class="btn btn-primary" href="/admin/manageSubject" role="button">Gestion domaines</a>
					</div>
				</div>

				<div class="container">
					<h2>Gestion projets*</h2>
					<div class="d-grid gap-2 col-6 mx-auto">
						<a class="btn btn-primary" href="/admin/manageWork" role="button">Gestion projets</a>
						<a class="btn btn-primary" href="/admin/manageRepository" role="button">Gestion dépôts</a>
						<a class="btn btn-primary" href="/admin/manageAssignement" role="button">Gestion attributions</a>
					</div>
					<p>* Mémoire ou rapport de stage</p>
				</div>
			</div>

		</div>
	</div>
</div>

<%@ include file="../footer.jsp"%>