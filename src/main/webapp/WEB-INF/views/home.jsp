<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>

<title>Accueil</title>

<!-- Page Content -->
<div class="container">

	<!-- Page Header -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">
				Connexion <small></small>
			</h1>
		</div>
	</div>
	<!-- /.row -->

	<!-- Projects Row -->
	<div class="row">
		<div class="col-md-6 portfolio-item">
			${loginError}
			<div class="form-group form">
				<form action='login' method="post" commandName="form">
					<div>
						<label>Identifiant ISEP :</label> <input type="text" id="userId"
							name="userId" placeholder="Identifiant ISEP" class="form-control" />
					</div>
					<br>
					<div>
						<label>Mot de passe :</label> <input type="password" id="password"
							name="password" placeholder="Mot de passe" class="form-control" />
					</div>
					<br>
					<button id="loginButton" class="form-control">Se connecter</button>
				</form>
			</div>
			<!-- Gaut form test -->
			${loginError}
			<div class="form-group form">
				<form action='loginn' method="post" commandName="formm">
					<div>
						<label>Identifiant Gaut :</label> <input type="text" id="login"
							name="login" placeholder="Identifiant ISEP" class="form-control" />
					</div>
					<br>
					<div>
						<label>Mot de passe :</label> <input type="password"
							id="passwordd" name="password" placeholder="Mot de passe"
							class="form-control" />
					</div>
					<br>
					<div>
						<label>Nom</label> <input type="text" id="nom" name="nom"
							placeholder="Nom" class="form-control" />
					</div>
					<br>
					<div>
						<label>Prenom</label> <input type="text" id="prenom" name="prenom"
							placeholder="Prenom" class="form-control" />
					</div>
					<br>
					<div>
						<label>NomFamille</label> <input type="text" id="nomFamille"
							name="nomFamille" placeholder="NomFamille" class="form-control" />
					</div>
					<br>
					<div>
						<label>type</label> <input type="text" id="type" name="type"
							placeholder="type" class="form-control" />
					</div>
					<br>
					<div>
						<label>Numéro étudiant</label> <input type="text" id="number"
							name="number" placeholder="Numéro étudiant" class="form-control" />
					</div>
					<br>
					<div>
						<label>Mail</label> <input type="text" id="mail" name="mail"
							placeholder="Mail" class="form-control" />
					</div>
					<br>
					<button id="loginButtonn" class="form-control">Se
						connecter</button>
				</form>
			</div>
			<!-- Gaut form test -->
		</div>
		<div class="col-md-6 portfolio-item">

			<a href="#"> <!-- <img class="img-responsive" src="http://placehold.it/700x400" alt=""> -->
			</a>
			<h3 class="lien_parcours">
				<a href="http://www.isep.fr/parcours/index.html" target="_blank">Lien
					vers les parcours</a>
			</h3>
			<p></p>
		</div>
	</div>
	<!-- /.row -->
</div>
<!-- /.container -->