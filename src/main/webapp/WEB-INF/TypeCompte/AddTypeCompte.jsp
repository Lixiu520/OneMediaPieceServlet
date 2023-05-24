<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Creation Du type Compte</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
    <link rel="stylesheet" href="css/header.css" type="text/css">
    <link rel="stylesheet" href="css/footer.css" type="text/css">
</head>
<body>
	 <jsp:include page="../HeaderConnecte.jsp" />
	<section>
		<div class="titre containerRow">
			
			<a href=""> <img src="img/home.png" alt="home"></a>
			<h1>Création de type Compte</h1>
			
			<div>
				<a href="http://localhost:8080/OneMediaPieceServlet/index"> 
				<img src="img/flecheDroite.png" alt="suivant">
				</a>
			</div>
		</div>
		<div class="formulaire">
			<figure>
				<fieldset>
					<legend>Nouveau Type Compte : </legend>
					<form action="AddTypeCompte" accept-charset="UTF-8"
						method="post" class="containerColunm">

						<label for="label"> Nom du type compte * : </label> <input
							type="text"  name="label" required>

						<div class="submit">
							<input type="submit" value="Envoyer"> <img
								src="img/envoyer.png" alt="">
						</div>

					</form>
				</fieldset>
			</figure>
		</div>

	</section>
	 <jsp:include page="../Footer.jsp" />

</body>
</html>