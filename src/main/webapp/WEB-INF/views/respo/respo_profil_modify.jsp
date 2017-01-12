<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<c:if test="${not empty respoLoggedIn}">
	<title>Responsable - Modifier sa fiche</title>

	<div class="container">

		<!-- Page Header -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Modifier ma fiche <small></small>
				</h1>
			</div>
		</div>
		<!-- /.row -->

		<div class="row">
			<form action="form_modifierProfil" method="POST"
				enctype="multipart/form-data">
				<div class="col-sm-4 col-md-4">
					<div class="form-group">
						<label class="control-label">Choisissez votre photo</label> <input
							name="photo" id="photo" type="file" class="file">
					</div>
				</div>
				<div class="col-sm-4 col-md-4">
					<div class="form-group">

						<label for="nomParcours">Responsable du parcours ...</label> <select
							class="form-control" name="nomParcours" id="nomParcours">
							<c:forEach var="parcours" items="${Allparcours}">
								<option
									<c:if test="${parcours.getId().equals(user.getIdParcours())}">
                                selected="selected"</c:if>
									value="${parcours.getNomparcours()}">
									${parcours.getNomparcours()}</option>
							</c:forEach>
						</select>

					</div>
					<div class="form-group">
						<label for="numSalle">Bureau :</label> <input
							accept-charset="UTF-8" type="text" class="form-control"
							name="numSalle" id="numSalle" placeholder="Salle n°">
					</div>
				</div>
				<div class="col-sm-4 col-md-4">
					<button type="submit"
						class="btn btn-primary btn-lg btn-block active">Sauvegarder
						ma fiche</button>
				</div>
			</form>
		</div>
		<!-- /.row -->
	</div>
</c:if>
<c:if test="${empty respoLoggedIn}">
	<jsp:forward page="../error.jsp" />
</c:if>
<script src="resources/js/respo_modifierProfil.js"
	type="text/javascript"></script>