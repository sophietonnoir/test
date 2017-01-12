<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<c:if test="${not empty respoLoggedIn}">
	<title>Responsable - Validation module</title>

	<link href="resources/css/temoignage.css" rel="stylesheet">

	<!-- Page Content -->
	<div class="container">

		<!-- Page Header -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Validation des modules à l'étranger <small></small>
				</h1>
			</div>
		</div>
		<!-- /.row -->

		<form name="form1" method="POST" action="">
			<div class="row">
				<p id="infotem">
					<b>Nom de l'étudiant :</b> ${eleve.getNom()} <br></br> <b>Cours
						choisis :</b> ${module.getDescription()} <br></br> <b>Nom de
						l'université :</b> ${module.getNomuniv()}<br></br> <b>Lien vers le
						catalogue de cours :</b> <a href="${module.getLien()}">${module.getLien()}</a>
				</p>
				<br> <label for="Commentaire">Commentaire:</label>
				<textarea style="height: 120px" class="form-control"
					id="Commentaire" name="Commentaire"
					placeholder="Indiquer ici vos commentaires" cols="" rows=""></textarea>
				<br> <input type="hidden" name="id" value="${module.getId()}" />
				<button type="submit" value="bouton1" name="bouton1"
					class="btn btn-default btn-lg btn-block active"
					onclick="validerBouton1()">Valider les modules</button>
				<button type="submit" value="bouton2" name="bouton2"
					class="btn btn-default btn-lg btn-block active"
					onclick="validerBouton2()">Les modules ne correspondent
					pas aux critères</button>
			</div>
		</form>

		<!-- /.row -->

	</div>
	<!-- /.container -->
</c:if>
<c:if test="${empty respoLoggedIn}">
	<jsp:forward page="../error.jsp" />
</c:if>

<script type="text/javascript">
	function validerBouton1() {
		form1.action = "eleve_validationmodules";
		form1.submit();
	}
	function validerBouton2() {
		form1.action = "eleve_refusmodules";
		form1.submit();
	}
</script>