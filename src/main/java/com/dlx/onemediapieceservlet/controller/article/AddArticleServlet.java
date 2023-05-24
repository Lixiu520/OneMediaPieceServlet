package com.dlx.onemediapieceservlet.controller.article;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
 * Servlet implementation class AddCompteServlet
 */
@WebServlet("/AddArticle")
public class AddArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private  final ArticleService serviceArt = ArticleServiceImpl.getInstance();


	private final String URL ="/WEB-INF/Article/addArticle.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddArticleServlet() {
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

		System.out.println(ct.getEmail());


		request.getServletContext().getRequestDispatcher(URL).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(); 

		Compte ct = (Compte) session.getAttribute("Compte");

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
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date currentDate = new Date(); // Obtient la date actuelle

		String formattedDate = dateFormat.format(currentDate);
		if(ct.getTypeCompte().getLabel() !=null && (ct.getTypeCompte().getTypeCompte()==1 ||ct.getTypeCompte().getTypeCompte()==67)){
			

			Article art;
			try {
				art = serviceArt.create(ct, titre, contenu, dateFormat.parse(formattedDate), public_);
				art = serviceArt.save(art);
				response.sendRedirect(request.getContextPath() + "/index");
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}else {
			response.sendRedirect(request.getContextPath() + "/indexVisiteur");
		}
		


	}

}
