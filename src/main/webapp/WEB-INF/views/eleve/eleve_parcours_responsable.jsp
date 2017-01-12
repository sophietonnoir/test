<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${not empty eleveLoggedIn}">
	<link href="resources/css/temoignage.css" rel="stylesheet">
	<title>Elève - Les Responsables</title>
	<!-- Page Content -->
	<div class="container">
		<!-- Page Header -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Les Responsables de parcours <small></small>
				</h1>
			</div>
		</div>
		<!-- /.row -->

		<table class="table table-bordered">
			<thead>

				<tr>
					<th>Parcours</th>
					<th>Professeur associé</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="parc" items="${parcoursFound}">
					<c:forEach var="respo" items="${respoFound}">
						<c:if test="${parc.getId().equals(respo.getIdParcours())}">
							<tr>
								<td>${parc.getNomparcours()}</td>
								<td><a
									onclick="self.location.href='eleve_profilRespo?id=${respo.getId()}'">${respo.getNom()}</a>
								</td>
							</tr>
						</c:if>
					</c:forEach>
				</c:forEach>

			</tbody>
		</table>

	</div>

</c:if>
<c:if test="${empty eleveLoggedIn}">
	<jsp:forward page="../error.jsp" />
</c:if>

