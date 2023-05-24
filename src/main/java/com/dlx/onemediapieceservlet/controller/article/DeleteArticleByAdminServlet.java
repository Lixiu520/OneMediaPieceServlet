package com.dlx.onemediapieceservlet.controller.article;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dlx.onemediapieceservlet.service.impl.ArticleServiceImpl;
import com.dlx.onemediapieceservlet.model.Article;
import com.dlx.onemediapieceservlet.model.Compte;
import com.dlx.onemediapieceservlet.service.ArticleService;

/**
 * Servlet implementation class DeleteCompteServlet
 */
@WebServlet("/DeleteArticleByAdmin")
public class DeleteArticleByAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final ArticleService service = ArticleServiceImpl.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteArticleByAdminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(); 

		Compte ct = (Compte) session.getAttribute("Compte");

		request.setAttribute("CompteS", ct);
		
		String id = request.getParameter("idArt");
		
		long idArt = Long.parseLong(id);
		
		Compte ctArt = service.findCtByArt(idArt);
		
		Article art = service.find(idArt);
		
		
		if(ct != null && art!=null){
			if(ct.getTypeCompte().getTypeCompte() == 1||ct.getTypeCompte().getTypeCompte()==67 ) {
				service.delete(art);
				request.setAttribute("successMessage", "Type de article supprimé avec succès.");
				response.sendRedirect(request.getContextPath()+"/index");
				
			} else if(ctArt==ct){
				service.delete(art);
				request.setAttribute("errorMessage", "Merci de verifier tous les informations.");
				response.sendRedirect(request.getContextPath()+"/indexVisiteur");

			}

		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
