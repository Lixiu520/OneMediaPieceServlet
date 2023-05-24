<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
            <Ul class="containerRow ajuster" id="connection">
                <li class="containerRow connection " > 
                    <img src="img/parametre.png" alt="parametre">
                   
                    <p id="user" > ${CompteS.pseudo }</p>
                </li>
                 <li><a href="http://localhost:8080/OneMediaPieceServlet/Deconnection"><img class="logout" src="img/logout.png" alt="deconnection"></a></li>
                <li><img src="img/notice.png" alt="menu"></li>
                <li><img src="img/menu.png" alt="menu"></li>
            </Ul>
        </div>
    </header>