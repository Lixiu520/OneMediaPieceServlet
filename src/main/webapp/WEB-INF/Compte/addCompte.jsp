<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Creation Du compte</title>
 	<link rel="stylesheet" href="css/style.css" type="text/css">
    <link rel="stylesheet" href="css/header.css" type="text/css">
    <link rel="stylesheet" href="css/footer.css" type="text/css">
</head>
<body>
   <jsp:include page="../HeaderDeconnecte.jsp" />
    <section>
        <div class="titre containerRow">
            <a href=""> <img src="img/home.png" alt="home"></a>
            <h1>Bienvenu Chez OneMediaPiece Blog</h1>
            <div>
				<a href="http://localhost:8080/OneMediaPieceServlet/index"> 
				<img src="img/flecheDroite.png" alt="suivant">
				</a>
			</div>

        </div>
        <div class="formulaire">
            <figure>
                <fieldset>
                    <legend>Si vous n'avez pas encore un compte, inscrivez-vous : </legend>
                    
                    <form action="AddCompte" method="post" class="containerColunm" >
                        <label for="pseudonyme"> Pseudonyme * : </label> <input type="text"name="pseudonyme" required>
                        
                        <label for="email"> Email * :  </label> <input type="text" name="email" required >
                        
                        <label for="motDePass"> Votre mot de pass * :   </label> <input type="password" name="motDePass1" required>
                       
                        <label for="motDePass">Confirmation de votre mot de pass * : </label> <input type="password" name ="motDePass2" required> 
                        
                        <label for="typeCompte" >Role : Rédacteur </label>  <input type="hidden" name ="idTypeCompte" value="68"> 
                        
                        <div class="submit"><input type="submit" value="Envoyer" > <img src="img/envoyer.png" alt=""></div>

                    </form>
                </fieldset>
            </figure>
            <figure>
                <fieldset>
                    <legend>Si vous avez déjà un compte, connectez-vous : </legend>

                    <form action="Connection" method="post" class="containerColunm"  >
                       
                        <label for="email"> Email * :  </label><input type="text" name="email" required/>
                        
                        <label for="motDePass"> Votre mot de pass * : </label> <input type="password" name="motDePass" required/> 
                        
                        <div class="submit containerRow"> <a href=""><input type="submit" value="Envoyer " > <img src="img/envoyer.png" alt=""></a> </div>

                    </form>
                </fieldset>
            </figure>

        </div>

    </section>
     <jsp:include page="../Footer.jsp" />
    <script src = "creationDuCompte.js"></script>
</body>
</html>