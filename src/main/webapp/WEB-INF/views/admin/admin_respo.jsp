<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<c:if test="${not empty adminLoggedIn}">
	<title>Admin - Responsables</title>

	<!-- Page Content -->
	<div class="container">

		<!-- Page Header -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Responsables de parcours <small></small>
				</h1>
			</div>
		</div>
		<!-- /.row -->

		<!-- Projects Row
	<div class="row">
		<div class="col-md-6 portfolio-item">
			<a href="admin_respo_add"><button type="button"
					class="btn btn-default">Ajouter un responsable</button></a>
		</div>
	</div>
	<!-- /.row -->

		<!-- Projects Row -->
		<div class="row">
			<table class="table">
				<thead>
					<tr>
						<th>Nom du responsable</th>
						<th>Parcours</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="parc" items="${parcoursFound}">
						<c:forEach var="respo" items="${respoFound}">
							<c:if test="${parc.getId().equals(respo.getIdParcours())}">
								<tr>
									<td><a
										onclick="self.location.href='eleve_profilRespo?id=${respo.getId()}'">${respo.getNom()}</a>
									</td>
									<td>${parc.getNomparcours()}</td>
									<td><a href="admin_respoEdit?id=${respo.getId()}"
										class="glyphicon glyphicon-edit"></a><a
										href="admin_respo_delete?id=${respo.getId()}"
										class="glyphicon glyphicon-remove" style="margin-left: 30px"></a>
									</td>
								</tr>
							</c:if>
						</c:forEach>
					</c:forEach>
				</tbody>
				<tbody>
				</tbody>
			</table>
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