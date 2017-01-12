<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<c:if test="${not empty adminLoggedIn}">
	<title>Admin - Ajouter Responsable</title>

	<!-- Page Content -->
	<div class="container">

		<!-- Page Header -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Ajouter un responsable <small></small>
				</h1>
			</div>
		</div>
		<!-- /.row -->

		<!-- Projects Row -->
		<div class="row">
			<form action="admin_ajouterrespo" method="POST">
				<div class="col-sm-4 col-md-4">
					<div class="form-group">
						<label for="nom">Nom du responsable: </label> <input type="text"
							class="form-control" id="nom" name="nom"
							placeholder="Responsable">
					</div>
					<div class="form-group">
						<label for="parcours">Choisissez le parcours : </label> <br>
						<select class="col-sm-12 col-md-12" name="parcours" id="parcours">
							<option value="parcours">Tous les parcours</option>
							<c:forEach var="parcours" items="${parcours}">
								<option value="${parcours.getId()}">${parcours.getNomparcours()}</option>
							</c:forEach>
						</select>
					</div>
					<br />
					<button type="submit"
						class="btn btn-default btn-lg btn-block active">Sauvegarder
						le responsable</button>
				</div>
			</form>
		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->
</c:if>
<c:if test="${empty adminLoggedIn}">
	<jsp:forward page="../error.jsp" />
</c:if>

<!-- jQuery -->
<script src="resources/js/jquery.js" type="text/javascript"></script>

<!-- Bootstrap Core JavaScript -->
<script src="resources/js/bootstrap.min.js" type="text/javascript"></script>

<body></body>

<html></html>