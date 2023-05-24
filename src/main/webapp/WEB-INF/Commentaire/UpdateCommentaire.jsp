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
    <jsp:include page="../HeaderConnecte.jsp" />
    <section>
        <div class="titre containerRow">
            <a href=""> <img src="img/home.png" alt="home"></a>
            <h1>Mettre à jour votre Blog</h1>
            <div>
				<a href="http://localhost:8080/OneMediaPieceServlet/index"> 
				<img src="img/flecheDroite.png" alt="suivant">
				</a>
			</div>

        </div>
        <div class="formulaire">
            <figure>
                <fieldset>
                    <legend>Ecrivez votre article : </legend>
                    
                    <form action="UpdateArticle" method="post" class="containerColunm" >
                     	<label for="titre"> Titre * : </label> <input type="text" name="titre" value="${article.titre }" required>
                    
                    	<label for="contenu"> Votre text * :   </label> <input type="text" id="contenu" name="contenu" value="${article.contenu }"required>
                        
                        <label for="typeCompte">Modération : $(article.medere)</label>
                        
							 
                         <select  name="publique" class="containerColumn listTypeCompte" >
                          
                           <option value="${article.public_?'public':''} }">public</option>
                           <option value="${article.public_?'':'privé'} }">privé</option>
                           	
                          </select>
                          
                          <input name="dateCreation" value="${article.date }"/>
                            
                        
                        <div class="submit"><input type="submit" value="Envoyer" > <img src="img/envoyer.png" alt=""></div>

                    </form>
                </fieldset>
            </figure>
           

        </div>

    </section>
     <jsp:include page="../Footer.jsp" />
    <script src = "creationDuCompte.js"></script>
</body>
</html>