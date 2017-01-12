<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>

<c:if test="${not empty adminLoggedIn}">
	<title>Admin - Ajouter Parcours</title>
	<!-- Page Content -->
	<div class="container">

		<!-- Page Header -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Ajouter un parcours <small></small>
				</h1>
			</div>
		</div>
		<!-- /.row -->

		<!-- Projects Row -->
		<div class="row">
			<form action="admin_modifierparcours" method="POST">
				<div class="col-sm-4 col-md-4">
					<div class="form-group">
						<label for="nom">Nom du parcours: </label> <input type="text"
							class="form-control" id="nom" name="nom" placeholder="Parcours">
					</div>
					<input type="hidden" class="form-control" id="id" name="id"
						value="${parcours.getId()}">
					<button type="submit"
						class="btn btn-default btn-lg btn-block active">Sauvegarder
						le parcours</button>
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