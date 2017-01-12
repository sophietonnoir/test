<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<c:if test="${not empty respoLoggedIn}">
	<title>Responsable - Témoignages</title>

	<!-- Page Content -->
	<div class="container">

		<!-- Page Header -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Témoignages <small></small>
				</h1>
			</div>
		</div>
		<!-- /.row -->

		<!-- Projects Row -->
		<p>Cliquez sur une ligne pour afficher le témoignage</p>
		<table class="table">
			<thead>
				<tr>
					<th>Parcours</th>
					<th>Eleve</th>
					<th>Promotion</th>
					<th>Etat</th>
					<th>Actions <c:forEach var="temoignage" items="${temoignages}"
							varStatus="status">
							<tbody>
								<tr class="accordion-toggle" data-toggle="collapse"
									data-target="#collapse${status.count}">
									<td>${temoignage[0]}</td>
									<td>${temoignage[1]}</td>
									<td>${temoignage[2]}</td>
									<td>${temoignage[3]}</td>
									<td><a
										onclick="self.location.href='respo_temoignage_confirm?c=y&amp;id=${temoignagesId[status.count-1]}'"
										class="glyphicon glyphicon-ok"></a><a
										onclick="self.location.href='respo_temoignage_confirm?c=n&amp;id=${temoignagesId[status.count-1]}'"
										class="glyphicon glyphicon-remove" style="margin-left: 30px"></a>
									</td>
								</tr>
								<tr id="collapse${status.count}" class="collapse out">
									<td></td>
									<td colspan="4"><div>
											<p>${temoignage[4]}</p>
										</div></td>
								</tr>
							</tbody>
						</c:forEach>
					</th>
				</tr>
			</thead>
		</table>
	</div>
	<!-- /.row -->

	<!-- /.container -->

</c:if>
<c:if test="${empty respoLoggedIn}">
	<jsp:forward page="../error.jsp" />
</c:if>

<!-- jQuery -->
<script src="resources/js/jquery.js" type="text/javascript"></script>

<!-- Bootstrap Core JavaScript -->
<script src="resources/js/bootstrap.min.js" type="text/javascript"></script>
