<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>

<title>Page d'erreur</title>

<!-- Page Content -->
<div class="container">

	<!-- Page Header -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">
				Désolé mais vous n'avez pas accès à cette page. <br/>
				
				<c:if test="${empty loggedInUser}">
				<small><a href="http://localhost:8080/speakisep/">Retour à la page d'accueil</a></small>
				</c:if>
				<c:if test="${not empty adminLoggedIn}">
				<small><a href="admin">Retour à la page d'accueil</a></small>
				</c:if>
				<c:if test="${not empty respoLoggedIn}">
				<small><a href="respo">Retour à la page d'accueil</a></small>
				</c:if>
				<c:if test="${not empty eleveLoggedIn}">
				<small><a href="eleve">Retour à la page d'accueil</a></small>
				</c:if>

			</h1>
		</div>
	</div>
	<!-- /.row -->
</div>
<!-- /.row -->

<!-- /.container -->

<!-- jQuery -->
<script src="resources/js/jquery.js" type="text/javascript"></script>

<!-- Bootstrap Core JavaScript -->
<script src="resources/js/bootstrap.min.js" type="text/javascript"></script>

<body></body>

<html></html>