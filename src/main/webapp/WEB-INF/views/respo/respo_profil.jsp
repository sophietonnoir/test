<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<c:if test="${not empty respoLoggedIn}">
	<title>Responsable - Mon profil</title>
	<div class="container">
		<!-- Page Header -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Fiche du responsable <small></small>
				</h1>
			</div>
		</div>
		<!-- /.row -->

		<div class="row">
			<div class="col-sm-2 col-md-2">
				<img src="img/${fiche.getPhoto()}" alt=""
					class="img-rounded img-responsive" />
			</div>
			<div class="col-sm-4 col-md-4">
				<blockquote>
					<p>${user.getNom()}</p>
				</blockquote>
				<p>
					<i class="glyphicon glyphicon-envelope"></i> ${user.getMail()} <br />
					<i class="glyphicon glyphicon-briefcase"></i> Responsable du
					parcours "${parcours.getNomparcours()}" <br /> <i
						class="glyphicon glyphicon-info-sign"></i> Bureau
					${fiche.getNumsalle()}
				</p>
			</div>
			<div class="col-sm-4 col-md-4">
				<a href="respo_profil_modify"
					class="btn btn-primary btn-lg btn-block active" role="button">Modifier
					ma fiche</a>
			</div>
		</div>
		<!-- /.row -->
	</div>
</c:if>
<c:if test="${empty respoLoggedIn}">
	<jsp:forward page="../error.jsp" />
</c:if>