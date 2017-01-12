<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<c:if test="${not empty adminLoggedIn}">
	<title>Admin - Parcours</title>

	<!-- Page Content -->
	<div class="container">

		<!-- Page Header -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Parcours <small></small>
				</h1>
			</div>
		</div>
		<!-- /.row -->

		<!-- Projects Row 
	<div class="row">
		<div class="col-md-6 portfolio-item">
			<a href="admin_parcours_edit"><button type="button"
					class="btn btn-default">Ajouter un parcours</button></a>
		</div>
	</div>
	<!-- /.row -->

		<!-- Projects Row -->
		<div class="row">
			<table class="table">
				<thead>
					<tr>
						<th>Parcours</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="parc" items="${parcoursFound}">
						<tr>
							<td>${parc.getNomparcours()}</td>
							<td><a href="admin_parcours_edit?id=${parc.getId()}"
								class="glyphicon glyphicon-edit"></a><a
								href="admin_parcoursRemove?id=${parc.getId()}"
								class="glyphicon glyphicon-remove" style="margin-left: 30px"></a></td>
						</tr>
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