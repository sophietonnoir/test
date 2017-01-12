<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<c:if test="${not empty respoLoggedIn}">
	<title>Responsable - Accueil</title>
	<div class="container">
		<div class="element btn-group btn-group-lg">
			<button class="btn btn-success href_button"
				onclick="self.location.href='respo_international_universite'">
				<h1>Université</h1>
			</button>
			<button class="btn btn-success href_button"
				onclick="self.location.href='respo_international_module'">
				<h1>Modules</h1>
			</button>
		</div>
	</div>
</c:if>
<c:if test="${empty respoLoggedIn}">
	<jsp:forward page="../error.jsp" />
</c:if>
