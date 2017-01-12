<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<c:if test="${not empty eleveLoggedIn}">
	<title>Elève - Parcours</title>
	<!-- Page Content -->
	<div class="container">
		<div class="element btn-group btn-group-lg">
			<button class="btn btn-success href_button"
				onclick="self.location.href='http://www.isep.fr/parcours/index.html'">
				<h1>Liste des parcours</h1>
				<h5>Tableau comparatif</h5>
			</button>
			<button class="btn btn-success href_button"
				onclick="self.location.href='eleve_parcours_responsable'">
				<h2>Responsable de parcours</h2>
				<h5>Nom, Contact</h5>
			</button>
			<button class="btn btn-success href_button"
				onclick="self.location.href='eleve_parcours_temoignage'">
				<h1>Témoignages</h1>
				<h5>d'anciens élèves</h5>
			</button>
		</div>
	</div>

</c:if>
<c:if test="${empty eleveLoggedIn}">
	<jsp:forward page="../error.jsp" />
</c:if>
