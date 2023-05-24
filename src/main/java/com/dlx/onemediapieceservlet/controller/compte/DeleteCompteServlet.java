package com.dlx.onemediapieceservlet.controller.compte;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dlx.onemediapieceservlet.service.impl.CompteServiceImpl;
import com.dlx.onemediapieceservlet.model.Compte;
import com.dlx.onemediapieceservlet.service.CompteService;

/**
 * Servlet implementation class DeleteCompteServlet
 */
@WebServlet("/DeleteCompte")
public class DeleteCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final CompteService service = CompteServiceImpl.getInstance();
  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCompteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 

		Compte ct1 = (Compte) session.getAttribute("Compte");

		request.setAttribute("CompteS", ct1);

		String id = request.getParameter("id");
		long idCompte = Long.parseLong(id);
		Compte ct = service.find(idCompte);
		if((ct != null)&&(ct.getTypeCompte().getTypeCompte()==1)){
			service.delete(ct);
		
		request.setAttribute("successMessage", "Type de compte supprimé avec succès.");
		
		
	} else {
		
		request.setAttribute("errorMessage", "Le type de compte spécifié n'a pas été trouvé.");
		
	}
		
		response.sendRedirect(request.getContextPath()+"/index");
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
