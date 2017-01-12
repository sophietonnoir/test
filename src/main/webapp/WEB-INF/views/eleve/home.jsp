<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<c:if test="${not empty eleveLoggedIn}">
	<title>Elève - Accueil</title>
	<!-- Page Content -->
	<div class="container">
		<div class="element btn-group btn-group-lg">
			<button class="btn btn-success href_button"
				onclick="self.location.href='eleve_profil'">
				<h1>Ma fiche</h1>
				<h5>Mes informations personnelles</h5>
			</button>
			<button class="btn btn-success href_button"
				onclick="self.location.href='eleve_parcours'">
				<h1>Parcours</h1>
				<h5>Liste, Témoignages</h5>
			</button>
			<button class="btn btn-success href_button"
				onclick="self.location.href='eleve_international'">
				<h1>International</h1>
				<h5>Université, Modules</h5>
			</button>
		</div>
	</div>
</c:if>
<c:if test="${empty eleveLoggedIn}">
	<jsp:forward page="../error.jsp" />
</c:if>

