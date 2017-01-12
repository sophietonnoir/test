<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<c:if test="${not empty adminLoggedIn}">
	<title>Admin - Ajout profil</title>

	<!-- Page Content -->
	<div class="container">

		<!-- Page Header -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Ajout d'élèves <small></small>
				</h1>
			</div>
		</div>
		<!-- /.row -->

		<!-- Projects Row -->
		<div class="row">
			<form method="POST" action='form_AddNew'
				enctype="multipart/form-data">
				<span class="form-group col-sm-12 col-md-12"> <select
					class="col-sm-4 col-md-4" name="tsearch">
						<option value="Parcours">Parcours actuellement
							disponibles</option>
						<c:forEach var="parcours" items="${parcours}">
							<option value="${parcours.getNomparcours()}">${parcours.getNomparcours()}</option>
						</c:forEach>
				</select>
				</span> <span class="form-group col-sm-12 col-md-12">
					<div class="col-sm-12 col-md-12 btn btn-default btn-file">
						<label class="control-label">Uploader le fichier excel
							contenant la liste des nouveaux élèves ici</label> <input
							id="addParcours" name="addParcours" type="file" class="file"
							name="addParcours" accept=".xls,.xlsx,.csv" />
					</div>
				</span> <span class="form-group col-sm-12 col-md-12">
					<div>

						<button type="submit"
							class="btn btn-default btn-lg btn-block active">Ajouter
							la liste</button>
					</div>
				</span>
			</form>
		</div>
		<span class="form-group col-sm-12 col-md-12"> </span>
	</div>
	<!-- /.row -->
</c:if>
<c:if test="${empty adminLoggedIn}">
	<jsp:forward page="../error.jsp" />
</c:if>
<script src="resources/js/admin_addNew.js" type="text/javascript"></script>