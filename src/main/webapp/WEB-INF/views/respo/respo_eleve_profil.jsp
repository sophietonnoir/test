<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<c:if test="${not empty respoLoggedIn}">
	<title>Responsable - Fiche de l'élève</title>
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
				<img src="img/${eleveFiche.getPhoto()}" alt=""
					class="img-rounded img-responsive" />
			</div>
			<div class="col-sm-4 col-md-4">
				<blockquote>
					<p>${eleve.nom}</p>
				</blockquote>
				<p>
					<i class="glyphicon glyphicon-info-sign"></i> N° étudiant :
					${eleve.getNumber()} <br /> <i
						class="glyphicon glyphicon-envelope"></i> ${eleve.getMail()} <br />
					<i class="glyphicon glyphicon-briefcase"></i>
					${eleveFiche.getApprenti()} -- ${eleveFiche.getEtape()} -- Promo
					${eleveFiche.getPromotion()} -- ${eleveFiche.getCursus()} <br /> <i
						class="glyphicon glyphicon-globe"></i> ${eleveFiche.getAdresse()}
				</p>
				<br />
				<fieldset>
					<legend>Activités extrascolaires</legend>
					<p>${eleveFiche.getActextra()}</p>
				</fieldset>

				<fieldset>
					<legend>CV</legend>
					<a href="doc/${eleveFiche.getCV()}">${eleveFiche.getCV()}</a>
				</fieldset>

				<fieldset>
					<legend>Lettre de motivation</legend>
					<a href="doc/${eleveFiche.getLettremotiv()}">${eleveFiche.getLettremotiv()}</a>
				</fieldset>
			</div>
			<div class="col-sm-4 col-md-4">
				<fieldset>
					<legend>Compétences de stage</legend>
					<p>${eleveFiche.getCompetences()}</p>
				</fieldset>

				<fieldset>
					<legend>Notes</legend>
					<p>${fiche.getNotes()}</p>
				</fieldset>
			</div>
			<div class="col-sm-2 col-md-2">
				<a href="mailto:${eleve.getMail()}"
					class="btn btn-primary btn-lg active" role="button">Contacter
					l'élève</a>
			</div>
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container -->
</c:if>
<c:if test="${empty respoLoggedIn}">
	<jsp:forward page="../error.jsp" />
</c:if>
