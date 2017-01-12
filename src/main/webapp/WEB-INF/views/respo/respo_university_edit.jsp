<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>

<c:if test="${not empty respoLoggedIn}">
	<title>Responsable - Editer Université</title>
	<!-- Page Content -->
	<div class="container">

		<!-- Page Header -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Editer une université <small></small>
				</h1>
			</div>
		</div>
		<!-- /.row -->

		<!-- Projects Row -->
		<div class="row">
			<form action="respo_modifieruniv" method="POST">
				<div class="col-sm-4 col-md-4">
					<div class="form-group">
						<label for="nom">Nom de l'université: </label> <input type="text"
							class="form-control" id="nom" placeholder="Université"
							value="${universite.getNomuniv()}">
					</div>
					<div class="form-group">
						<label for="lien">Lien vers les cours proposés par
							l'université: </label> <input type="text" class="form-control" id="lien"
							name="lien" placeholder="Lien">
					</div>
					<input type="hidden" class="form-control" id="id" name="id"
						value="${universite.getId()}">

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
<c:if test="${empty respoLoggedIn}">
	<jsp:forward page="../error.jsp" />
</c:if>
