<%@ page pageEncoding="UTF-8" %>
<%@ include file="../../header.jsp"%>
<%@ include file="../../headerProfile.jsp"%>

<div class="container">
	<h1>Gestion attributions</h1>

	<!-- On défini le centre -->
	<div class="container">
		<div class="row align-items-center">
			<div class="col">

				<c:forEach items="${assignements}" var="assignement">
					<p>
						${assignement.id} ${assignement.name} ${assignement.statusA}
						<a class="btn btn-primary" href="/admin/detailAssignement?id=${assignement.id}" role="button">Details</a>
					</p>
				</c:forEach>

			</div>
		</div>
	</div>
</div>

<%@ include file="../../footer.jsp"%>