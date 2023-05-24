package com.dlx.onemediapieceservlet.controller.compte;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dlx.onemediapieceservlet.model.Compte;
import com.dlx.onemediapieceservlet.model.TypeCompte;
import com.dlx.onemediapieceservlet.service.CompteService;
import com.dlx.onemediapieceservlet.service.TypeCompteService;
import com.dlx.onemediapieceservlet.service.impl.CompteServiceImpl;
import com.dlx.onemediapieceservlet.service.impl.TypeCompteServiceImpl;
/**
 * Servlet implementation class AddCompteServlet
 */
@WebServlet("/AddCompte")
public class AddCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private  final CompteService service = CompteServiceImpl.getInstance();
	
	private  final  TypeCompteService serviceTypeCompte = TypeCompteServiceImpl.getInstance();
	
	private final String URL ="/WEB-INF/Compte/addCompte.jsp";
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCompteServlet() {
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

	request.getServletContext().getRequestDispatcher(URL).forward(request, response);
	
	
	}
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String pseudonyme = request.getParameter("pseudonyme");
		String motDePass = request.getParameter("motDePass1");
		String idTypeCompte = request.getParameter("idTypeCompte");
		long id = Long.parseLong(idTypeCompte);
		TypeCompte tc = serviceTypeCompte.find(id) ;
		
		
		Compte ct = service.create(pseudonyme, email, motDePass,tc);
		
		ct = service.save(ct);
		
		response.sendRedirect(request.getContextPath() + "/index");
		
		
	}

}
