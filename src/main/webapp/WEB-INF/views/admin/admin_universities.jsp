<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<c:if test="${not empty adminLoggedIn}">
	<title>Admin - Universités</title>


	<!-- Page Content -->
	<div class="container">

		<!-- Page Header -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Universités <small></small>
				</h1>
			</div>
		</div>
		<!-- /.row -->

		<!-- Projects Row -->
		<div class="row">
			<div class="col-md-6 portfolio-item">
				<a href="admin_university_add"><button type="button"
						class="btn btn-default">Ajouter une université</button></a>
			</div>
		</div>
		<!-- /.row -->

		<!-- Projects Row -->
		<div class="row">
			<table class="table">
				<thead>
					<tr>
						<th>Universités</th>
						<th>Lien vers les cours</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="universite" items="${universites}">
						<tr>
							<td>${universite.getNomuniv()}</td>
							<td><a href="${universite.getLienuniv()}">Lien vers les
									cours</a></td>&nbsp;&nbsp;&nbsp;&nbsp;
							<td><a href="admin_university_edit?id=${universite.getId()}"
								class="btn btn-default active modif" role="button">Modifier
									l'université</a></td>
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

