package com.dlx.onemediapieceservlet.controller.typecompte;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dlx.onemediapieceservlet.model.Compte;
import com.dlx.onemediapieceservlet.model.TypeCompte;
import com.dlx.onemediapieceservlet.service.TypeCompteService;
import com.dlx.onemediapieceservlet.service.impl.TypeCompteServiceImpl;

/**
 * Servlet implementation class AddTypeCompteServelet
 */
@WebServlet("/AddTypeCompte")
public class AddTypeCompteServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private  final  TypeCompteService service = TypeCompteServiceImpl.getInstance();



	private final String URL ="/WEB-INF/TypeCompte/AddTypeCompte.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddTypeCompteServelet() {
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


		request.getServletContext().getRequestDispatcher(URL).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(); 

		Compte ct = (Compte) session.getAttribute("Compte");
		String label = request.getParameter("label");

		TypeCompte tc = new TypeCompte();

		if(ct!=null && ct.getTypeCompte().getTypeCompte()==1) {
			
			//System.out.println(">>>> " + label);

			tc = service.create(label);

			tc = service.save(tc);

			response.sendRedirect(request.getContextPath()+"/index");

		}



		

		//request.getServletContext().getRequestDispatcher("/WEB-INF/TypeCompteList.jsp").forward(request, response);
	}

}
