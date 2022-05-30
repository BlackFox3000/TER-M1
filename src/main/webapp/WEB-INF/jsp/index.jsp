<%@ include file="header.jsp"%>

<c:url var="list" value="/course/list" />

<div class="container">
	<h1>Se connecter</h1>
	<p>
		<c:out value="${message}" />
	</p>

	<!-- On défini le centre -->
	<div class="container">
		<div class="row align-items-center">
			<div class="col">

				<!-- On défini le menu -->
				<div class="row align-items-start">
					<ul class="nav nav-tabs">
						<% if ( request.getParameter("connect") == null) { %>
						<li class="nav-item">
							<a class="nav-link active" aria-current="page" href="?connect=student"> <h3>  Espace Etudiant </h3> </a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="?connect=teacher"> <h3>  Espace Professeur </h3> </a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="?connect=admin"> <h3>  Espace Administrateur </h3> </a>
						</li>
						<% } else { %>

						<li class="nav-item">
							<% if ( request.getParameter("connect").equals("student")) { %>
								<a class="nav-link active" aria-current="page" href="?connect=student">
							<% }  else { %>
								<a class="nav-link" href="?connect=student">
							<% } %>
							  <h3>  Espace Etudiant </h3> </a>
						</li>
						<li class="nav-item">
							<% if ( request.getParameter("connect").equals("teacher")) { %>
							<a class="nav-link active" aria-current="page" href="?connect=teacher">
								<% }  else { %>
								<a class="nav-link" href="?connect=teacher">
									<% } %>
									<h3>  Espace Professeur </h3> </a>
						</li>
						<li class="nav-item">
							<% if ( request.getParameter("connect").equals("admin")) { %>
							<a class="nav-link active" aria-current="page" href="?connect=admin">
								<% }  else { %>
								<a class="nav-link" href="?connect=admin">
									<% } %>
									<h3>  Espace Administrator </h3> </a>
						</li>

						<% } %>
					</ul>

				</div>
				<!-- On défini l'espace formulaire -->
				<div class="row align-items-start">

					<!-- On défini le formulaire -->
					<div class="col align-self-center">

						<form method="POST" action="/connect">
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Email address</label>
								<input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
								<div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Password</label>
								<input type="password" class="form-control" id="password">
							</div>
							<% if ((request.getParameter("connect") != null))
							if (request.getParameter("connect").equals("admin")) { %>
							<div class="mb-3">
								<label for="exampleInputSecretCode" class="form-label">Code authentification/sms</label>
								<input type="text" class="form-control" id="secretCode">
							</div>
							 <% } %>
							<button type="submit" class="btn btn-primary">se connecter</button>
							<a href="forgotPassword" >mot de passe oublie?</a>
						</form>
					</div>
				</div>


			</div>
		</div>
	</div>

	<p>
		<a href="${list}">Course</a>
	</p>
</div>

<%@ include file="footer.jsp"%>
