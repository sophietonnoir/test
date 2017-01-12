<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${not empty respoLoggedIn}">
	<title>Responsable - Rechercher des élèves</title>
	<link href="resources/css/respo_eleve.css" rel="stylesheet">
	<div class="container">
		<!-- Page Header -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Rechercher des élèves</h1>
			</div>
		</div>
		<!-- /.row -->
		<div class="row">
			<div class="col-sm-4  col-md-offset-2">
				<form class="form-inline" action="">
					<div class="form-group">
						<label class="sr-only" for="eleveSearch"></label>
						<div class="input-group">
							<div class="input-group-addon">
								<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
							</div>
							<input type="text" class="form-control" id="eleveSearch"
								placeholder="Rechercher un élève">
						</div>
					</div>
				</form>
			</div>
			<div class="col-md-4 col-xs-offset-1 col-sm-push-1 col-md-push-0">
				<label class="checkbox"><input id="checkByParc"
					type="checkbox" value='${user.getIdParcours()}'>${user.getIdParcours()}
					Seulement mon parcours</label>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4 col-md-2 col-sm-push-8 col-md-push-10">
				<select id="promo" class="form-group form-control">
					<c:forEach var="promotion" items="${promotions}">
						<c:if test="${promotion!=''}">
							<option value="${promotion}">Promo ${promotion}</option>
						</c:if>

					</c:forEach>
				</select> <a
					href="mailto:
            <c:forEach var="eleve" items="${elevedeMonParcours}" >
            <c:if test="${(eleve.type).equals('eleve')}">
                ${eleve.getMail()}
            </c:if>
            </c:forEach>">
					<div class="glyphicon glyphicon-envelope">Contacter tous les
						élèves de mon parcours</div>
				</a>
			</div>
			<div class="col-sm-8 col-sm-pull-4 col-md-pull-0 ">
				<table class="table table-condensed table-hover table-bordered">
					<thead>
						<tr class="success">
							<th>Nom</th>
							<th>Prénom</th>
							<th>Email</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="eleve" items="${eleves}">
							<c:forEach var="fiche" items="${fiches}">
								<c:if test="${fiche.getUserId().equals(eleve.getId())}">

									<tr
										onclick="self.location.href='respo_eleve_profil?id=${eleve.getId()}'">
										<td>${eleve.getNomFamille()}</td>
										<td>${eleve.getPrenom()}</td>
										<td><a href="mailto:${eleve.getMail()}">${eleve.getMail()}</a>
										</td>
										<td class="hide">${eleve.getIdParcours()}</td>
										<td class="hide">${fiche.getPromotion()}</td>
									</tr>
								</c:if>

							</c:forEach>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</c:if>
<c:if test="${empty respoLoggedIn}">
	<jsp:forward page="../error.jsp" />
</c:if>
<script src="resources/js/respo_eleve.js" type="text/javascript"></script>