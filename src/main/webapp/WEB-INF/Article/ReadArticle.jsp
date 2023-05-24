<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Read article</title>
 	<link rel="stylesheet" href="css/style.css" type="text/css">
    <link rel="stylesheet" href="css/header.css" type="text/css">
    <link rel="stylesheet" href="css/footer.css" type="text/css">
</head>
<body>
   <jsp:include page="../HeaderConnecte.jsp" />
    <section>
        <div class="titre containerRow">
            <div>
				<a href="http://localhost:8080/OneMediaPieceServlet/index"> 
				<img src="img/Tournerleft.png" alt="precedent">
				</a>
				</div>
            <a href=""> <img src="img/home.png" alt="home"></a>
              
            <h1>${article.titre }</h1>
            	<div class="detail containerRow">
							<a href="http://localhost:8080/OneMediaPieceServlet/UpdateArticle?id=${article.article }">
								<img src="img/boutonmodification.png">
							</a>
							<button class="imgSupprimer" onclick="if(confirm('Voulez-vous vraiment supprimer cet article')){location.href='http://localhost:8080/OneMediaPieceServlet/DeleteCompte?id=${article.article}'}">
								<img  alt="supprimer" src="img/supprimer.png">
							</button>
						</div>
         

        </div>
        <div class="formulaire">
            <figure>
                <fieldset>
                    
                    <div class="containerColumn  article">
					
					
						<div class="containerColunm">
	                     	
	                        <label class="contenuDeArticle"> ${article.contenu}</label>
	                        <label class="typePublication">  ${typePublication}</label>
	                        <label class="auteur"> Auteur: ${article.compte.pseudo}</label>
	                        <label class="dateDeArticle"> écrit à : ${article.date}</label>
	                         <h4> Commentaires <label> <a class="add" href="http://localhost:8080/OneMediaPieceServlet/AddCommentaire?idArt=${article.article}">
									<button> <img src ="img/AddCommentaire.png"> </button>
									</a>
								</label></h4>
	                        <c:forEach items ="${commentaires}" var = "commentaire">
	                       
	                        <div  class="containerRow cmt">
								<label >  ${commentaire.contenu}</label>
								<label>  ${commentaire.compte.pseudo}</label>
							</div>
							</c:forEach>
							
	                       		 
						</div>
					</div>		 
                </fieldset>
            </figure>
           

        </div>

    </section>
					
				
     <jsp:include page="../Footer.jsp" />
    <script src = "creationDuCompte.js"></script>
</body>
</html>