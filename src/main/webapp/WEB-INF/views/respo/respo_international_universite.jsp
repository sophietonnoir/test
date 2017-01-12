<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>

<c:if test="${not empty respoLoggedIn}">
	<title>Responsable - Universités</title>

	<!-- Page Content -->
	<div class="container">

		<!-- Page Header -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Université <small></small>
				</h1>
			</div>
		</div>
		<!-- /.row -->
		<!--style="border: 2px solid;"-->
		<div class="row">
			<input type="text" class="form-control" id="search">
			<div id="unilist" class="col-sm-12 col-md-12">
				<table class="table table-striped">
					<c:forEach var="universite" items="${universites}">
						<tr>
							<td><blockquote>
									<h3 id="parcours">${universite.getNomuniv()}</h3>
									<a href="${universite.getLienuniv()}">Lien vers les cours</a>&nbsp;&nbsp;&nbsp;&nbsp;<a
										href="respo_university_edit?id=${universite.getId()}"
										class="btn btn-default active modif" role="button">Modifier
										le lien</a>
								</blockquote></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>

		<!-- /.row -->

	</div>
	<!-- /.container -->
</c:if>
<c:if test="${empty respoLoggedIn}">
	<jsp:forward page="../error.jsp" />
</c:if>
<script src="resources/js/universite.js" type="text/javascript"></script>
