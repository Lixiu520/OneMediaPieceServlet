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
            <h1>Mettre à jour le type Compte</h1>
            <a href="http://localhost:8080/OneMediaPieceServlet/index"> <img src="img/boutonRetour.png" alt="home"></a>
        </div>
        <div class="formulaire">
            <figure>
                <fieldset>
                    <legend>Nouveau Type Compte : </legend>
                    <form action="UpdateTypeCompte" method="post" class="containerColunm" >
                        <label for="label"> Nouveau nom du type compte * : </label> 
                        <input type="text"  name="typeCompteLabel" required value="${TC.label }">
                        <div class="submit"><input type="submit" value="Mis à jour" > <img src="img/envoyer.png" alt=""></div>
						<input type="hidden" name="id" value="${TC.typeCompte}">
                    </form>
                </fieldset>
            </figure>
        </div>

    </section>
     <jsp:include page="../Footer.jsp" />
    
</body>
</html>