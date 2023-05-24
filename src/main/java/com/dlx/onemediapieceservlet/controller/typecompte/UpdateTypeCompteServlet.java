package com.dlx.onemediapieceservlet.controller.typecompte;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dlx.onemediapieceservlet.service.TypeCompteService;
import com.dlx.onemediapieceservlet.service.impl.TypeCompteServiceImpl;
import com.dlx.onemediapieceservlet.model.Compte;
import com.dlx.onemediapieceservlet.model.TypeCompte;

/**
 * Servlet implementation class UpdateTypeCompteServlet
 */
@WebServlet("/UpdateTypeCompte")
public class UpdateTypeCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final String URL = "/WEB-INF/TypeCompte/UpdateTypeCompte.jsp";

	private final TypeCompteService service =TypeCompteServiceImpl.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateTypeCompteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		// récupére l'id
		// tu select

		HttpSession session = request.getSession(); 

		Compte ct = (Compte) session.getAttribute("Compte");

		request.setAttribute("CompteS", ct);



		String id = request.getParameter("id");

		long idTypeCompte= Long.parseLong(id);

		TypeCompte tc = service.find(idTypeCompte);

		request.setAttribute("TC", tc);

		request.getServletContext().getRequestDispatcher(URL).forward(request, response);

		//response.sendRedirect(request.getContextPath()+"/TypeCompteList");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(); 

		Compte ct = (Compte) session.getAttribute("Compte");

		String typeCompteLabel = request.getParameter("typeCompteLabel");

		String id = request.getParameter("id");

		long idTypeCompte= Long.parseLong(id);

		TypeCompte tc = new TypeCompte();

		tc = service.find(idTypeCompte);

		tc.setLabel(typeCompteLabel);
		if(tc!=null && ct.getTypeCompte().getTypeCompte()==1) {
			tc = service.update(tc);

			//	System.out.print(tc.toString());

			//request.getServletContext().getRequestDispatcher(URL).forward(request, response);

			response.sendRedirect(request.getContextPath()+"/index");

		}


	}

}
