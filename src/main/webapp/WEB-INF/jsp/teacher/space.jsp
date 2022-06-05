<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ include file="../header.jsp"%>
<%@ include file="../headerProfile.jsp"%>

<!-- On défini le centre -->
<div class="container">
	<div class="row align-items-center">
		<div class="col">

			<div class="container">
				<h2>Gestion dépôts</h2>
				<div class="d-grid gap-2 col-6 mx-auto">
					<a class="btn btn-primary" href="/teacher/addRepository" role="button">Créer un nouveau dépôt</a>
					<a class="btn btn-primary" href="/teacher/manageRepository" role="button">Gestion dépôts</a>
					<a class="btn btn-primary" href="/teacher/addStudentList" role="button">Créer une liste d'étudiants</a>
					<a class="btn btn-primary" href="/teacher/manageStudentList" role="button">Gestione listes d'étudiants</a>
				</div>
			</div>

			<div class="container">
				<div class="container">
					<h2>Nouveaux mémoires attribués</h2>
					<div class="d-grid gap-2 col-6 mx-auto">
						<ul>
					<c:forEach items="${worksNews}" var="work">
						<li>
							${work.title}
							<a class="btn btn-primary" href="/teacher/acceptWork?${work.id}" role="button">Accepter</a>
							<a class="btn btn-primary" href="/admin/refuseWork?${work.id}" role="button">Refuser</a>
						</li>

					</c:forEach>
						</ul>
				</div>
				</div>

				<div class="container">
					<h2>Mémoire à évaluer</h2>
					<div class="d-grid gap-2 col-6 mx-auto">
						<ul>
							<c:forEach items="${worksWait}" var="work">
								<li>
									${work.title}
									<button class="btn btn-primary" href="/teacher/download?" role="button" disabled>Télécharger</button>
									<button class="btn btn-primary" href="/teacher/evaluateWork?${work.id}" role="button" disabled>Evaluer</button>
								</li>

							</c:forEach>
						</ul>
					</div>
				</div>

				<div class="container">
					<h2>Mémoires évalués</h2>
					<div class="d-grid gap-2 col-6 mx-auto">
						<ul>
							<c:forEach items="${worksEnd}" var="work">
								<li>
									${work.title}
									<button class="btn btn-primary" href="/teacher/download?" role="button" disabled>Télécharger</button>
									<button class="btn btn-primary" href="/teacher/detailWork?${work.id}" role="button" disabled>Voir commentaire</button>
								</li>

							</c:forEach>
						</ul>
					</div>
					<p>* Mémoire ou rapport de stage</p>
				</div>
			</div>

		</div>
	</div>
</div>

<%@ include file="../footer.jsp"%>