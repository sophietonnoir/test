<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<c:if test="${not empty adminLoggedIn}">
	<title>Admin - Accueil</title>
	<!-- Page Content -->
	<div class="container">
		<div class="element btn-group btn-group-lg">
			<button class="btn btn-success href_button"
				onclick="self.location.href='admin_universities'">
				<h1>Université</h1>
				<h5>Modifier, Supprimer</h5>
			</button>
			<button class="btn btn-success href_button"
				onclick="self.location.href='admin_temoignage'">
				<h1>Témoignage</h1>
				<h5>Valider, Supprimer</h5>
			</button>
			<button class="btn btn-success href_button"
				onclick="self.location.href='admin_AddNew'">
				<h1>Elèves</h1>
				<h5>Ajouter</h5>
			</button>
			<button class="btn btn-success href_button"
				onclick="self.location.href='admin_parcours'">
				<h1>Parcours</h1>
				<h5>Modifier, Supprimer</h5>
			</button>
			<button class="btn btn-success href_button"
				onclick="self.location.href='admin_respo'">
				<h2>Responsable de parcours</h2>
				<h5>Modifier, Supprimer</h5>
			</button>
		</div>
	</div>
</c:if>
<c:if test="${empty adminLoggedIn}">
	<jsp:forward page="../error.jsp" />
</c:if>

