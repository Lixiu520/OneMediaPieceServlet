<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>list TypeCompte</title>
<!--<c:url var="url" value="css/listDeTypeCompte.css"></c:url>
<link rel="stylesheet" href="${url}" type="text/css">-->
 <link rel="stylesheet" href="css/style.css" type="text/css">
    <link rel="stylesheet" href="css/header.css" type="text/css">
    <link rel="stylesheet" href="css/footer.css" type="text/css">
</head>
<body>
	<header >
        <div class="alignement containerRow">
            <Ul class="bar containerRow">
                <li class="containerRow ">
                    <a href="">
                        <img src="img/arrow-circle-left.png" alt="flechgauche">
                    </a>  Aller au journal
                </li>
           
                <li>
                    OneMediaPiece Blog 
                </li>

            </Ul>
            <Ul class="containerRow ajuster" id="connection" >
               ${user}
            </Ul>
        </div>
    </header>
    <section id="monArt" class="${cacher}">
		<div class="titre containerRow ">
			<h1>Mes articles</h1>
			<a class="add" href="http://localhost:8080/OneMediaPieceServlet/AddArticle">
			<button> Add +</button>
			</a>
		</div>
		<div class="containerColumn scrollable-container">
			<div class="article containerColumn ">
				<c:forEach items ="${mesArticles }" var = "article">
				
					<div class="containerRow listArticle ">
						<a class="read" href="http://localhost:8080/OneMediaPieceServlet/ReadArticle?idArt=${article.article}">
							<button> ${article.titre } </button>
						</a>
						
						<div class="detail containerRow ">
							<a href="http://localhost:8080/OneMediaPieceServlet/UpdateArticle?idArt=${article.article }">
							<img src="img/boutonmodification.png">
							</a>
							<button class="imgSupprimer" onclick="if(confirm('Voulez-vous vraiment supprimer cet article')){location.href='http://localhost:8080/OneMediaPieceServlet/DeleteArticle?idArt=${article.article}'}">
								<img alt="supprimer" src="img/supprimer.png" >
							</button>
						</div>
					
					</div>
					
					
				</c:forEach>
			
			</div>
		</div>
		
	</section>
	
	<section>
			 <div class="titreTousLesBlogs ">
	           
	            <h1>Tous les blogs</h1>
	
	        </div>
	        <div class="filtre containerRow ">
	            <div class="containerRow">
	                <h4>Par date de mis à jour</h4>
	                <img src="img/arrow-drop-down.png" alt="">
	            </div>
	            <div class="containerRow ">
	                <h4>Par ordre alphabétique </h4>
	                <img src="img/arrow-drop-down.png" alt="">
	            </div>
	            <div class="containerRow ">
	                <h4>Par auteur </h4>
	                <img src="img/arrow-drop-down.png" alt="">
	            </div>
	
	            <div class=" containerRow">
	                <img src="img/search.png" alt="">
	                <div class="recherche containerRow">
	                    <input type="text" name="recherche" >
	                    <h4>OK</h4>
	                </div>
	            </div>
	        </div>
	        <div class="listDeArticle">
	           		 <div class="articles containerColumn scrollable-containerArticle">
	                
	                  <c:forEach items="${articlesPublic}" var="article">
		                  <div class = "containerRow listArticle">	
								<button class="dt" onclick="toggleDetail('${article.titre}',${article.article})">${article.titre}</button>
								<div class="containerRow">
									<p>${article.date}</p>
									<p>${article.compte.pseudo}</p>
								</div>
								
							</div>
	                  <div id="detail-${article.titre}-${article.article}" class ="dpNone containerColunm detailContainer ">
	                     	
	                        <label> titre: ${article.titre}</label>
	                        <label> contenu: ${article.contenu}</label>
	                        <label> date de création: ${article.date}</label>
	                        <label> public_: ${article.public_}</label>
	                        <label> Compte: ${article.compte.pseudo}</label>
	                     </div>
	                  </c:forEach>  
	                </div>
	           
                  
	   
	           </div>
				
	</section>

	 <jsp:include page="Footer.jsp" />
</body>
<script type="text/javascript" src="scripte.js"></script>
<script type="text/javascript" src="scripteIndexRedacteur.js"></script>
</html>