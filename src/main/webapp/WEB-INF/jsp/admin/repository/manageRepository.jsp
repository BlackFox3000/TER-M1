<%@ page pageEncoding="UTF-8" %>
<%@ include file="../../header.jsp"%>
<%@ include file="../../headerProfile.jsp"%>

<div class="container">
	<h1>Gestion dépots</h1>

	<!-- On défini le centre -->
	<div class="container">
		<div class="row align-items-center">
			<div class="col">

				<c:forEach items="${repositories}" var="repo">
					<p>
						${repo.id} ${repo.name} propriétaire: ${repo.teacherOwner.id} (à améliorer ... en récupérant le nom prénom en fct de l'id)
						<a class="btn btn-primary" href="/admin/editRepository?id=${repo.id}" role="button">Details</a>
					</p>
				</c:forEach>

			</div>
		</div>
	</div>
</div>

<%@ include file="../../footer.jsp"%>