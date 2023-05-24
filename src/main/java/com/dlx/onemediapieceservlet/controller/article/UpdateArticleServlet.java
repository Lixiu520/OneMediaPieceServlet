package com.dlx.onemediapieceservlet.controller.article;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dlx.onemediapieceservlet.model.Article;
import com.dlx.onemediapieceservlet.model.Compte;
import com.dlx.onemediapieceservlet.service.ArticleService;
import com.dlx.onemediapieceservlet.service.CompteService;
import com.dlx.onemediapieceservlet.service.impl.ArticleServiceImpl;
import com.dlx.onemediapieceservlet.service.impl.CompteServiceImpl;

/**
 * Servlet implementation class UpdateCompteServlet
 */
@WebServlet("/UpdateArticle")
public class UpdateArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String URLAuteur = "/WEB-INF/Article/UpdateArticleAuteur.jsp";
	private final String URL = "/WEB-INF/Article/UpdateArticle.jsp";
	private  final ArticleService serviceArt =ArticleServiceImpl.getInstance();
	private final CompteService serviceCompte = CompteServiceImpl.getInstance();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateArticleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession(); 

		Compte ct = (Compte) session.getAttribute("Compte");

		request.setAttribute("CompteS", ct);


		String idArt = request.getParameter("idArt");
		long idArticle = Long.parseLong(idArt);
		request.setAttribute("idArt", idArt);
		Article art = serviceArt.find(idArticle);

		request.setAttribute("article", art);	

		
		
		
		if(ct!=null) {
			if(ct.getTypeCompte().getTypeCompte() == 1||ct.getTypeCompte().getTypeCompte()==67 ) {
				request.getServletContext().getRequestDispatcher(URL).forward(request, response);
			} else {
				request.getServletContext().getRequestDispatcher(URLAuteur).forward(request, response);
			}
		}else {
			System.out.println("Vous n'avez pas droit de modifier");
		}





	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(); 

		Compte ct = (Compte) session.getAttribute("Compte");

		request.setAttribute("CompteS", ct);

		String idArticle = request.getParameter("idArt");
		//System.out.println(idArticle);
		long idArt = Long.parseLong(idArticle);
		//System.out.println(idArt);
		Compte cmtArticle=serviceArt.findCtByArt(idArt);
		Article art = serviceArt.find(idArt);
		String titre = request.getParameter("titre");
		String contenu = request.getParameter("contenu");


		//String modere = request.getParameter("modere");
		String publique=request.getParameter("publique");
		boolean public_;
		if(publique.equals("public")){
			public_=true;
		}else {
			public_=false;
		}
		art.setContenu(contenu);
		art.setTitre(titre);
		art.setPublic_(public_);


				
		
		if(ct!=null) {
			if(ct.getTypeCompte().getTypeCompte() == 1||ct.getTypeCompte().getTypeCompte()==67) {
				art = serviceArt.update(art);
				request.setAttribute("idArt", idArt);
				request.setAttribute("article", art);

				response.sendRedirect(request.getContextPath() + "/index");
				
			} else if(ct==cmtArticle){
				art = serviceArt.update(art);
				request.setAttribute("idArt", idArt);
				request.setAttribute("article", art);
				response.sendRedirect(request.getContextPath() + "/indexVisiteur");
			}
		}else {
			System.out.println("Vous n'avez pas droit de modifier");
		}


	}

}
