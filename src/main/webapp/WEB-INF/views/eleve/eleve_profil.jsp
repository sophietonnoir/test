<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<c:if test="${not empty eleveLoggedIn}">
	<title>Elève - Mon profil</title>

	<!-- Page Content -->
	<div class="container">

		<!-- Page Header -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Fiche de l'élève <small></small>
				</h1>
			</div>
		</div>
		<!-- /.row -->

		<div class="row">
			<div class="col-sm-2 col-md-2">
				<img src="img/${fiche.getPhoto()}" alt=""
					class="img-rounded img-responsive" />
			</div>
			<div class="col-sm-4 col-md-4">
				<blockquote>
					<p>${user.getNom()}</p>
				</blockquote>
				<p>
					<i class="glyphicon glyphicon-info-sign"></i> N° étudiant :
					${user.getNumber()} <br /> <i class="glyphicon glyphicon-envelope"></i>
					${user.getMail()} <br /> <i class="glyphicon glyphicon-briefcase"></i>
					<c:out value="${fiche.getApprenti()}"></c:out> -- ${fiche.getEtape()} -- Promo
					${fiche.getPromotion()} -- ${fiche.getCursus()} <br /> <i
						class="glyphicon glyphicon-globe"></i> ${fiche.getAdresse()}
				</p>
				<br />
				<fieldset>
					<legend>Activités extrascolaires</legend>
					<p>${fiche.getActextra()}</p>
				</fieldset>

				<fieldset>
					<legend>CV</legend>
					<a href="doc/${fiche.getCV()}">${fiche.getCV()}</a>
				</fieldset>
				<br />
				<fieldset>
					<legend>Lettre de motivation</legend>
					<a href="doc/${fiche.getLettremotiv()}">${fiche.getLettremotiv()}</a>
				</fieldset>
			</div>
			<div class="col-sm-4 col-md-4">
				<fieldset>
					<legend>Compétences de stage</legend>
					<p>${fiche.getCompetences()}</p>
				</fieldset>

				<fieldset>
					<legend>Notes</legend>
					<p>${fiche.getNotes()}</p>
				</fieldset>
			</div>
			<div class="col-sm-2 col-md-2">
				<a href="eleve_profil_modify" class="btn btn-primary btn-lg active"
					role="button">Modifier ma fiche</a>
			</div>
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container -->

</c:if>
<c:if test="${empty eleveLoggedIn}">
	<jsp:forward page="../error.jsp" />
</c:if>