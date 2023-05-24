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
 * Servlet implementation class DeleteTypeCompteServlet
 */
@WebServlet("/DeleteTypeCompte")
public class DeleteTypeCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private  final  TypeCompteService service = TypeCompteServiceImpl.getInstance();
	
	
         
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTypeCompteServlet() {
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

		
		String id = request.getParameter("id");
		
		long idTypeCompte = Long.parseLong(id);


		TypeCompte tc = service.find(idTypeCompte);

		if (tc != null && ct.getTypeCompte().getTypeCompte()==1) {
			
			service.delete(tc);
			
			request.setAttribute("successMessage", "Type de compte supprimé avec succès.");
			
		} else {
			
			request.setAttribute("errorMessage", "Le type de compte spécifié n'a pas été trouvé.");
		}
		
		
		//request.getServletContext().getRequestDispatcher(URL).forward(request, response);
		
		response.sendRedirect(request.getContextPath()+"/index");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		doGet(request, response);
	}

}
