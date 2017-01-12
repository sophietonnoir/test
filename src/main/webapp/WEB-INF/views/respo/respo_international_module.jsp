<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<c:if test="${not empty respoLoggedIn}">
	<title>Responsable - Liste validation modules</title>


	<!-- Page Content -->
	<div class="container">

		<!-- Page Header -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Validation des modules <small></small>
				</h1>
			</div>
		</div>
		<!-- /.row -->

		<!-- Projects Row -->

		<!-- /.row -->

		<!-- Projects Row -->
		<div class="row">
			<table class="table">
				<thead>
					<tr>
						<th>Nom de l'étudiant</th>
						<th>Université</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="module" items="${moduleFound}">
						<c:forEach var="eleve" items="${eleveFound}">
							<c:if test="${module.getUserId().equals(eleve.getId())}">
								<tr>
									<td><a
										onclick="self.location.href='respo_eleve_profil?id=${eleve.getId()}'">${eleve.getNom()}</a>
									</td>
									<td>${module.getNomuniv()}</td>
									<td><a href="respo_validation_module?id=${eleve.getId()}"><button
												type="button" class="btn btn-default">Voir ses
												modules</button></a></td>
								</tr>

							</c:if>
						</c:forEach>
					</c:forEach>

				</tbody>
			</table>
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container -->
</c:if>
<c:if test="${empty respoLoggedIn}">
	<jsp:forward page="../error.jsp" />
</c:if>

