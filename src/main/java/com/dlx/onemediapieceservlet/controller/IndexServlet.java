package com.dlx.onemediapieceservlet.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dlx.onemediapieceservlet.model.TypeCompte;
import com.dlx.onemediapieceservlet.model.Compte;
import com.dlx.onemediapieceservlet.model.Article;
import com.dlx.onemediapieceservlet.service.ArticleService;
import com.dlx.onemediapieceservlet.service.CompteService;
import com.dlx.onemediapieceservlet.service.TypeCompteService;
import com.dlx.onemediapieceservlet.service.impl.ArticleServiceImpl;
import com.dlx.onemediapieceservlet.service.impl.CompteServiceImpl;
import com.dlx.onemediapieceservlet.service.impl.TypeCompteServiceImpl;


/**
 * Servlet implementation class TypeCompteListServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private  final  TypeCompteService serviceTypeCompte = TypeCompteServiceImpl.getInstance();

	private final CompteService serviceCompte = CompteServiceImpl.getInstance();

	private final ArticleService serviceArticle = ArticleServiceImpl.getInstance();

	private final String URLAdminModerateur ="/WEB-INF/index.jsp";
	
	private final String URL ="/WEB-INF/index.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(); 

		Compte ct = (Compte) session.getAttribute("Compte");

		request.setAttribute("CompteS", ct);

		
		List<TypeCompte> typeComptes = new ArrayList<>();

		typeComptes = serviceTypeCompte.findAll();

		request.setAttribute("typeComptes", typeComptes);

		List<Compte> comptes = new ArrayList<>();

		comptes = serviceCompte.findAll();

		request.setAttribute("Comptes", comptes);

		List<Article> articles = serviceArticle.findAll();

		System.out.println(articles.toString());

		/*List<Commentaire> commentaires = new ArrayList<>();

		for(Article art: articles) {
			commentaires = serviceCommentaire.findAllCmt(art.getArticle());

			request.setAttribute("commentaires", commentaires);
		}

		 */
		List<Article> articlesByCompte = serviceArticle.findArticlesById(ct);
		
		System.out.println(articlesByCompte.toString());


		request.setAttribute("tousArticles", articles);

		request.setAttribute("articles", articlesByCompte);


		if(ct!=null) {
			if(ct.getTypeCompte().getTypeCompte()==1|| ct.getTypeCompte().getTypeCompte()==67) {
				request.getServletContext().getRequestDispatcher(URLAdminModerateur).forward(request, response);
			}else {
				request.getServletContext().getRequestDispatcher(URL).forward(request, response);
			}
			
		}else {
			response.sendRedirect(request.getContextPath()+"/Connection");
		}
		

	}



}
