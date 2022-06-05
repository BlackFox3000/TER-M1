<%@ page pageEncoding="UTF-8" %>
<%@ include file="../../header.jsp"%>
<%@ include file="../../headerProfile.jsp"%>

<div class="container">
	<h1>Gestion administrateur</h1>

	<!-- On défini le centre -->
	<div class="container">
		<div class="row align-items-center">
			<div class="col">

				<c:forEach items="${users}" var="user">
					<p>
						${user.id} ${user.email}
						<a class="btn btn-primary" href="/admin/editAdmin?id=${user.id}" role="button">Modifier</a>
					</p>
				</c:forEach>

			</div>
		</div>
	</div>
</div>

<%@ include file="../../footer.jsp"%>