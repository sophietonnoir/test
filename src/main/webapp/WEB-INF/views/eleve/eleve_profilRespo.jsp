<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<c:if test="${not empty eleveLoggedIn}">
	<title>Elève - Profil responsable</title>

	<!-- Page Content -->
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
				<img src="img/${respoFiche.getPhoto()}" alt=""
					class="img-rounded img-responsive" />
			</div>
			<div class="col-sm-4 col-md-4">
				<blockquote>
					<p>${respo.getNom()}</p>
				</blockquote>
				<p>
					<i class="glyphicon glyphicon-envelope"></i> ${respo.getMail()} <br />
					<i class="glyphicon glyphicon-briefcase"></i> Responsable du
					parcours "${respoParcours.getNomparcours()}" <br /> <i
						class="glyphicon glyphicon-info-sign"></i> Bureau
					${respoFiche.getNumsalle()}
				</p>
			</div>
			<div class="col-sm-4 col-md-4">
				<a href="mailto:${respo.getMail()}?subject=GL?"
					class="btn btn-primary btn-lg btn-block active" role="button">Contacter
					le reponsable</a>
			</div>
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container -->

</c:if>
<c:if test="${empty eleveLoggedIn}">
	<jsp:forward page="../error.jsp" />
</c:if>