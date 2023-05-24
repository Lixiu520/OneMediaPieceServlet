package com.dlx.onemediapieceservlet.controller.commentaire;

import java.io.IOException;
import java.util.Date;
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
 * Servlet implementation class AddTypeCompteServelet
 */
@WebServlet("/AddCommentaire")
public class AddCommentaireServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private  final  CommentaireService service = CommentaireServiceImpl.getInstance();
	
	private  final  ArticleService serviceArt = ArticleServiceImpl.getInstance();
	
	private final String URL ="/WEB-INF/Commentaire/addCommentaire.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCommentaireServelet() {
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
		String idArticle = request.getParameter("idArt");
		request.setAttribute("idArt", idArticle);
		request.getServletContext().getRequestDispatcher(URL).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 

		Compte ct = (Compte) session.getAttribute("Compte");
		
		String contenu = request.getParameter("contenu");
		String publique=request.getParameter("publique");
		boolean public_;
		if(publique.equals("public")){
			public_=true;
		}else {
			public_=false;
		}

		
		String idArticle = request.getParameter("idArt");
		long idArt;
		if(ct!=null) {
			if (idArticle != null && !idArticle.isEmpty()) {
				idArt = Long.parseLong(idArticle);
				System.out.println(idArticle);
				Article art = serviceArt.find(idArt);
				
			
			Commentaire cmt= service.create(art, contenu, ct, public_,new Date());
			
			cmt = service.save(cmt);
			
			List<Commentaire> commentaires =service.findAllCmt(idArt);
			
			request.setAttribute("commentaires", commentaires);
			
			
			System.out.println(cmt.toString());

			response.sendRedirect(request.getContextPath() + "/ReadArticle?idArt="+idArt);
			} else {
				System.out.println("erreur");
			}
			
		} else {
			System.out.println("merci d'inscrire");
		}
		
		
		//System.out.println(">>>> " + label);
		
		//request.getServletContext().getRequestDispatcher("/WEB-INF/TypeCompteList.jsp").forward(request, response);
	}

}
