package com.dlx.onemediapieceservlet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dlx.onemediapieceservlet.model.Article;
import com.dlx.onemediapieceservlet.model.Compte;
import com.dlx.onemediapieceservlet.service.ArticleService;
import com.dlx.onemediapieceservlet.service.impl.ArticleServiceImpl;


/**
 * Servlet implementation class TypeCompteListServlet
 */
@WebServlet("/indexVisiteur")
public class IndexSansCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final ArticleService serviceArticle = ArticleServiceImpl.getInstance();

	private final String URL ="/WEB-INF/indexVisiteur.jsp";
	
	//private final String URLAdminModerateur ="/WEB-INF/index.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		HttpSession session = request.getSession(); 

		Compte ct = (Compte) session.getAttribute("Compte");
		request.setAttribute("CompteS", ct);
		String user;
		String cacher;
		if(ct==null){
			user="<li class='containerRow connection'><a href='http://localhost:8080/OneMediaPieceServlet/Connection' class='containerRow'>Sign In<img src='img/flechDroite.png' alt='flechright'></a></li><li><img src='img/notice.png' alt='notice'></li><li><img src='img/menu.png' alt='menu'></li>";
			System.out.println("pas encore connecté");
			cacher = "cacher";
		}else {
			user=" <li class='containerRow connection ' ><img src='img/parametre.png' alt='parametre'><p id='user' > "+ct.getPseudo()+"</p></li><li><a href='http://localhost:8080/OneMediaPieceServlet/Deconnection'><img class='logout' src='img/logout.png' alt='deconnection'></a></li><li><img src='img/notice.png' alt='menu'></li><li><img src='img/menu.png' alt='menu'></li>";
			List<Article> mesArticles = serviceArticle.findArticlesById(ct);
			cacher="";
			request.setAttribute("mesArticles", mesArticles);
		}
		
		request.setAttribute("user", user);
		request.setAttribute("cacher", cacher);
		
		List<Article> articles = serviceArticle.findArticlePublic();

		System.out.println(articles.toString());

		/*List<Commentaire> commentaires = new ArrayList<>();

		for(Article art: articles) {
			commentaires = serviceCommentaire.findAllCmt(art.getArticle());

			request.setAttribute("commentaires", commentaires);
		}

		 */
		request.setAttribute("articlesPublic", articles);
		if(ct!=null&&(ct.getTypeCompte().getTypeCompte()==1|| ct.getTypeCompte().getTypeCompte()==67)) {
			//request.getServletContext().getRequestDispatcher(URLAdminModerateur).forward(request, response);
			response.sendRedirect(request.getContextPath()+"/index");
		}else {
			request.getServletContext().getRequestDispatcher(URL).forward(request, response);
		}
		
		


	}



}
