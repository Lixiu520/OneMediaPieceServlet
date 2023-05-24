package com.dlx.onemediapieceservlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.dlx.onemediapieceservlet.model.Compte;
import com.dlx.onemediapieceservlet.service.CompteService;
import com.dlx.onemediapieceservlet.service.impl.CompteServiceImpl;

/**
 * Servlet implementation class ConnectionServlet
 */
@WebServlet("/Connection")
public class ConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String URL = "/WEB-INF/Compte/addCompte.jsp";
	private final CompteService service = CompteServiceImpl.getInstance();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConnectionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		request.getServletContext().getRequestDispatcher(URL).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String email = request.getParameter("email");

		String motDePass = request.getParameter("motDePass");

		System.out.println("email : " + email);
		
		System.out.println("motDePass : " + motDePass);

		Compte ct = service.findByEmailMDP(email, motDePass);

		System.out.println("ct : " + ct.toString());

		HttpSession session = request.getSession();

		session.setAttribute("Compte", ct);

		request.setAttribute("CompteS", ct);

		if(ct.getValide()&&((ct.getTypeCompte().getTypeCompte()==1)||ct.getTypeCompte().getTypeCompte()==67 )) {
			response.sendRedirect(request.getContextPath()+ "/index");
		} else if (ct.getValide()&&(ct.getTypeCompte().getTypeCompte()==68)){
			System.out.println("En attente de validation");
			System.out.println(ct.getValide());
			response.sendRedirect(request.getContextPath()+ "/indexVisiteur");
		}else {
			response.sendRedirect(request.getContextPath()+ "/Connection");
		}
	}


}
