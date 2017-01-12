<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<c:if test="${not empty respoLoggedIn}">
	<title>Responsable - Mon profil</title>
	<div class="container">
		<!-- Page Header -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Modifier mon profil <small></small>
				</h1>
			</div>
		</div>
		<!-- /.row -->

		<div class="row">
			<div class="col-sm-4 col-md-4">
				<p>Votre profil a bien été mis à jour !</p>
				<a href="respo_profil"
					class="btn btn-primary btn-lg btn-block active" role="button">Voir
					ma fiche</a>
			</div>
		</div>
		<!-- /.row -->
	</div>
</c:if>
<c:if test="${empty respoLoggedIn}">
	<jsp:forward page="../error.jsp" />
</c:if>