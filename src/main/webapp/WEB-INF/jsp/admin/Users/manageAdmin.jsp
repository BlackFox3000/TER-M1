<%@ page pageEncoding="UTF-8" %>
<%@ include file="header.jsp"%>

manage admin

<c:url var="list" value="/course/list" />

<div class="container">
	<h1>Gestion administrateur</h1>

	<!-- On défini le centre -->
	<div class="container">
		<div class="row align-items-center">
			<div class="col">

				<c:forEach items="${users}" var="users">
					<p>
						${user.firstname} ${user.lastname}
						<a class="btn btn-primary" href="admin/editAdmin?id=${user.getAdmin().getId()}" role="button">Modifier</a>
					</p>
				</c:forEach>

			</div>
		</div>
	</div>
</div>

<%@ include file="footer.jsp"%>