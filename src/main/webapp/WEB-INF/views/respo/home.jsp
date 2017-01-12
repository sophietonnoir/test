<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<c:if test="${not empty respoLoggedIn}">
	<title>Responsable - Accueil</title>
	<div class="container">
		<div class="element btn-group btn-group-lg">
			<button class="btn btn-success href_button"
				onclick="self.location.href='respo_eleve'">
				<h1>Elèves</h1>
				<h5>Fiches, Infos</h5>
			</button>
			<button class="btn btn-success href_button"
				onclick="self.location.href='respo_profil'">
				<h1>Ma fiche</h1>
				<h5>&nbsp;</h5>
			</button>
			<button class="btn btn-success href_button"
				onclick="self.location.href='respo_international'">
				<h1>International</h1>
				<h5>Université, Modules</h5>
			</button>
			<button class="btn btn-success href_button"
				onclick="self.location.href='respo_temoignage'">
				<h1>Témoignages</h1>
			</button>
		</div>
	</div>
</c:if>
<c:if test="${empty respoLoggedIn}">
	<jsp:forward page="../error.jsp" />
</c:if>

