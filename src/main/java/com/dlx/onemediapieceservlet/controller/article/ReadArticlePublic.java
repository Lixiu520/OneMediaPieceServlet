package com.dlx.onemediapieceservlet.controller.article;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.dlx.onemediapieceservlet.model.Article;
import com.dlx.onemediapieceservlet.model.Commentaire;
import com.dlx.onemediapieceservlet.model.Compte;
import com.dlx.onemediapieceservlet.service.ArticleService;
import com.dlx.onemediapieceservlet.service.CommentaireService;
import com.dlx.onemediapieceservlet.service.impl.ArticleServiceImpl;
import com.dlx.onemediapieceservlet.service.impl.CommentaireServiceImpl;
/**
 * Servlet implementation class AddCompteServlet
 */
@WebServlet("/ReadArticlePublic")
public class ReadArticlePublic extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private  final ArticleService serviceArt = ArticleServiceImpl.getInstance();

	private final CommentaireService serviceCommentaire = CommentaireServiceImpl.getInstance();

	private final String URL ="/WEB-INF/Article/ReadArticle.jsp";
	private final String URL1 ="/WEB-INF/Article/indexVisiteur.jsp";


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReadArticlePublic() {
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

		if(ct!= null) {
			String idArticle = request.getParameter("idArt");
			//System.out.println("idArticle");

			long idArt=Long.parseLong(idArticle);

			Article art = serviceArt.find(idArt);
			String typePublication;
			if(art.getPublic_()) {
				typePublication="public";
			}else {
				typePublication ="privé";
			}

			request.setAttribute("article", art);
			//System.out.println(art.toString());
			request.setAttribute("typePublication", typePublication);

			List<Commentaire> commentairesPublic = serviceCommentaire.findAllCmtPublic(idArt);

			request.setAttribute("commentaires", commentairesPublic);
			//System.out.println(commentairesPublic);

			request.getServletContext().getRequestDispatcher(URL).forward(request, response);
		}else {
			request.getServletContext().getRequestDispatcher(URL1).forward(request, response);
		}



	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}
