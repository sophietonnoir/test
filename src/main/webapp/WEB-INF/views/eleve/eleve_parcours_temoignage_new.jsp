<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<c:if test="${not empty eleveLoggedIn}">
	<title>Elève - Déposer Témoignage</title>
	<!-- Page Content -->
	<div class="container">

		<!-- Page Header -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Déposer un nouveau témoignage <small></small>
				</h1>
			</div>
		</div>
		<!-- /.row -->

		<div class="row">
			<form action='eleve_ajouttemoignage' method="POST">
				<div class="col-sm-7 col-md-7">
					<div class="form-group">
						<label for="parcours">Choisissez le parcours : </label> <br>
						<select class="col-sm-12 col-md-12" name="parcours" id="parcours">
							<option value="parcours">Tous les parcours</option>
							<c:forEach var="parcours" items="${parcours}">
								<option value="${parcours.getNomparcours()}">${parcours.getNomparcours()}</option>
							</c:forEach>
						</select>
					</div>
					<br></br>
					<div class="form-group">
						<label for="Commentaire">Votre témoignage : </label>
						<textarea style="height: 120px" class="form-control"
							id="Commentaire" name="Commentaire" placeholder="Témoignage"
							cols="" rows=""></textarea>
					</div>
				</div>
				<div class="col-sm-5 col-md-5">
					<button type="submit"
						class="btn btn-primary btn-lg btn-block active">Déposer
						votre témoignage</button>
				</div>
			</form>
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container -->

</c:if>
<c:if test="${empty eleveLoggedIn}">
	<jsp:forward page="../error.jsp" />
</c:if>
