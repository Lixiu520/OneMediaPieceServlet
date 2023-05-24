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
	<jsp:include page="HeaderConnecte.jsp" />
	
	<div class="containerRow ctEtTc" >
		<section id="TC">
			<div class="titre containerRow  ">
				<a class="add" href="http://localhost:8080/OneMediaPieceServlet/AddTypeCompte"><button >Add </button> </a>
				<h1>List de type compte</h1>
			</div>
			<div class="containerColumn ">
				<div class=" containerColumn scrollable-container">
				<c:forEach items="${typeComptes}" var="typeCompte">
					<div class = "containerRow listTypeCompte">	
							<button class="dt" onclick="toggleDetail('${typeCompte.label}',${typeCompte.typeCompte})">${typeCompte.label}</button>
						
						
							<div class="detail containerRow">
						    	
						    	
							    <a class="nonWrap" href="http://localhost:8080/OneMediaPieceServlet/UpdateTypeCompte?id=${typeCompte.typeCompte}"> 
							    	<img src="img/boutonmodification.png">
							    </a>
							    
							   	<button  class="imgSupprimer" onclick="if(confirm('Voulez-vous vraiment supprimer ce type de compte?')){location.href='http://localhost:8080/OneMediaPieceServlet/DeleteTypeCompte?id=${typeCompte.typeCompte}'}"> 
				    			<img src ="img/supprimer.png">
								</button>
							</div>
					</div>
					<div id="detail-${typeCompte.label }-${typeCompte.typeCompte}" class ="dpNone detailContainer">
						<label> id : ${typeCompte.typeCompte} </label>
						<label>  label: ${typeCompte.label}</label>
					</div>
					
				  </c:forEach>
				</div>
			</div>
				
		</section >		
		<section id="Ct">			
		<div class="titre containerRow ">
				<a class="add" href="http://localhost:8080/OneMediaPieceServlet/AddCompte"><button > Add </button> </a>
				<h1>List de  compte</h1>
		</div>
		<div class="containerColumn ">
			<div class=" containerColumn scrollable-container">
		
				<c:forEach items="${Comptes}" var="compte">
					<div class = "containerRow listCompte">	
						<button class="dt" onclick="toggleDetail('${compte.pseudo}',${compte.compte})">${compte.pseudo}</button>
						
						<div class="detail containerRow">
					    
						    <a href="http://localhost:8080/OneMediaPieceServlet/UpdateCompte?id=${compte.compte}"> 
						    	<img src="img/boutonmodification.png">
						    </a>
						    
						   	<button class="imgSupprimer" onclick="if(confirm('Voulez-vous vraiment supprimer ce compte?')){location.href='http://localhost:8080/OneMediaPieceServlet/DeleteCompte?id=${compte.compte}'}"> 
			    			<img src ="img/supprimer.png" >
							</button>
							
						</div>
					</div>
					<div id="detail-${compte.pseudo}-${compte.compte}" class ="dpNone containerColunm detailContainer ">
						<label> id : ${compte.compte}</label>
						<label> pseudo: ${compte.pseudo}</label>
						<label> email: ${compte.email}</label>
						<label> signale: ${compte.signale}</label>
						<label> suppressionDonnee: ${compte.suppressionDonnee}</label>
						<label> valide: ${compte.valide}</label>
					</div>
					
				  </c:forEach>
			</div>
	</div>
	</section>
	</div>
	<section id="art">
		<div class="titre containerRow">
			<h1>Mes articles</h1>
			<a class="add" href="http://localhost:8080/OneMediaPieceServlet/AddArticle">
			<button> Add +</button>
			</a>
		</div>
		<div class="containerColumn scrollable-containerArticle">
			<div class="article containerColumn ">
				<c:forEach items ="${articles }" var = "article">
				
					<div class="containerRow listArticle ">
						<a class="read" href="http://localhost:8080/OneMediaPieceServlet/ReadArticle?idArt=${article.article}">
							<button> ${article.titre } </button>
						</a>
						
						<div class="detail containerRow ">
							<a href="http://localhost:8080/OneMediaPieceServlet/UpdateArticle?idArt=${article.article}">
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
	
	<section id="tousLesArticlesPublic">
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
	                
	                  <c:forEach items="${tousArticles}" var="article">
		                  <div class = "containerRow listArticle">	
								<a class="read" href="http://localhost:8080/OneMediaPieceServlet/ReadArticlePublic?idArt=${article.article}">
									<button> ${article.titre } </button>
								</a>
								<div class="detail containerRow">
							    
								    <p> 
								    	${article.compte.pseudo}
								    </p>
								    
								   
								    <p> 
								    	${article.date}
								    </p>
									
								</div>
							</div>
	                  
	                  </c:forEach>  
	                </div>
	           
                  
	   
	           </div>
	
	</section>

	 <jsp:include page="Footer.jsp" />
	
</body>
 <script src="scripte.js"></script>
</html>