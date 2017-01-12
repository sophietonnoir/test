<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>

<c:if test="${not empty adminLoggedIn}">
	<title>Admin - Ajouter Université</title>
	<!-- Page Content -->
	<div class="container">

		<!-- Page Header -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Ajouter une université <small></small>
				</h1>
			</div>
		</div>
		<!-- /.row -->

		<!-- Projects Row -->
		<div class="row">
			<form action="admin_ajouteruniv" method="POST">
				<div class="col-sm-4 col-md-4">
					<div class="form-group">
						<label for="nom">Nom de l'université: </label> <input type="text"
							class="form-control" id="nom" name="nom" placeholder="Université">
					</div>
					<div class="form-group">
						<label for="lien">Lien vers les cours proposés par
							l'université: </label> <input type="text" class="form-control" id="lien"
							name="lien" placeholder="Lien">
					</div>

					<button type="submit"
						class="btn btn-default btn-lg btn-block active">Sauvegarder
						l'université</button>
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