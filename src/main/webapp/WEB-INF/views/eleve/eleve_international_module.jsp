<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<c:if test="${not empty eleveLoggedIn}">
	<title>Elève - Choix des modules</title>

	<!-- Page Content -->
	<div class="container">

		<!-- Page Header -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Choix des cours à l'étranger <small></small>
				</h1>
			</div>
		</div>
		<!-- /.row -->
		<c:choose>
			<c:when test="${ModuleDone==0}">
				<div class="row">
					<form action='eleve_ajoutmodules' method="POST">
						<div class="form-group form">
							<label for="universite">Choisissez votre université
								d'accueil : </label> <br> <select class="col-sm-4 col-md-4"
								name="universite" id="universite">
								<option value="universite">Nom de l'université</option>
								<c:forEach var="universite" items="${universite}">
									<option value="${universite.getNomuniv()}">${universite.getNomuniv()}</option>
								</c:forEach>
							</select>
						</div>
						<br>
						<div class="form-group">
							<label for="description">Choix des cours : </label>
							<textarea style="height: 120px" class="form-control"
								id="description" name="description"
								placeholder="Indiquer ici vos cours, leurs descriptions et le nombre de crédits correspondants"
								cols="" rows=""></textarea>
						</div>
						<div class="form-group">
							<label for="lien">Insérer ici le lien vers le catalogue
								de cours</label> <input type="text" class="form-control" id="lien"
								name="lien" placeholder="Lien">
						</div>
						<button type="submit"
							class="btn btn-default btn-lg btn-block active">Envoyer</button>

					</form>
				</div>
			</c:when>
			<c:when test="${ModuleDone==1}">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>Mon choix de cours</th>
							<th>Etat</th>
							<th>Commentaire</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><b>Université :</b> ${module.getNomuniv()} <br></br> <b>Cours
									choisis :</b> ${module.getDescription()} <br></br> <b>Date de
									soumission :</b> ${date}</td>
							<td><b>${module.getStatut()}</b></td>
							<td><b>${module.getCommentaire()}</b></td>
						</tr>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>
				<div class="row">
					<form action='eleve_ajoutmodules' method="POST">
						<div class="form-group form">
							<label for="universite">Choisissez votre université
								d'accueil : </label> <br> <select class="col-sm-4 col-md-4"
								name="universite" id="universite">
								<option value="universite">Nom de l'université</option>
								<c:forEach var="universite" items="${universite}">
									<option value="${universite.getNomuniv()}">${universite.getNomuniv()}</option>
								</c:forEach>
							</select>
						</div>
						<br>
						<div class="form-group">
							<label for="description">Choix des cours : </label>
							<textarea style="height: 120px" class="form-control"
								id="description" name="description"
								placeholder="Indiquer ici vos cours, leurs descriptions et le nombre de crédits correspondants"
								cols="" rows=""></textarea>
						</div>
						<div class="form-group">
							<label for="lien">Insérer ici le lien vers le catalogue
								de cours</label> <input type="text" class="form-control" id="lien"
								name="lien" placeholder="Lien">
						</div>
						<button type="submit"
							class="btn btn-default btn-lg btn-block active">Envoyer</button>

					</form>
				</div>
			</c:otherwise>
		</c:choose>

		<!-- /.row -->

	</div>
	<!-- /.container -->
</c:if>
<c:if test="${empty eleveLoggedIn}">
	<jsp:forward page="../error.jsp" />
</c:if>

<!-- jQuery -->
<script src="resources/js/jquery.js" type="text/javascript"></script>

<!-- Bootstrap Core JavaScript -->
<script src="resources/js/bootstrap.min.js" type="text/javascript"></script>

<body></body>
<html></html>