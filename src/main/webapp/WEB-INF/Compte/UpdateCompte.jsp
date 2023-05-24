<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
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
            <h1>Modification du compte</h1>
	  		<a href="http://localhost:8080/OneMediaPieceServlet/index"> <img src="img/boutonRetour.png" alt="home"></a>
        </div>
        <div class="formulaire">
           
           <figure>
                <fieldset>
                    <legend>Modification : </legend>
                    <form action="UpdateCompte" method="post" class="containerColunm updateCompte" >
                    
                    	<input type="hidden" name="id" value="${compte.compte }"/>
                        <label for="pseudonyme"> Pseudonyme * :<input name="pseudonyme" value="${compte.pseudo}"/></label>  
                         <label for="email"> Email * : <input name="compteEmail" value="${compte.email}"/></label> 
                        <label for="typeCompte">Type de compte :  	
							 
							    <select  name="TypeCompte" class="containerRow listTypeCompte">
							     <c:forEach items="${listTc}" var="typeCompte" varStatus="status">
							      <option value="${typeCompte.typeCompte}">${typeCompte.label}</option>
							      </c:forEach>	  	
							    </select>
							  
						</label>
                     		
								   
					
                        <label for="valider"> Valider? * : <input type="checkbox" name="valider" ${compte.valide  ? 'checked':""}></label> 
                        <label for="bani"> Bani? * : <input type="checkbox" name="bani" ${compte.bani  ? 'checked':""}> </label> 
                        <label for="signale"> Signaler ? * : <input type="checkbox" name="signale" ${compte.signale  ? 'checked':""}></label>  
                        <label for="supprimer"> Supprimer ? * : <input type="checkbox" name="supprimer" ${compte.suppressionDonnee  ? 'checked':""}></label> 
                         <label for="efface"> Effacer ? * : <input type="checkbox" name="efface"${compte.suppressionDonnee  ? 'checked':""}></label> 
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