package com.dlx.onemediapieceservlet.controller.compte;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class UpdateCompteServlet
 */
@WebServlet("/UpdateCompte")
public class UpdateCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String URL = "/WEB-INF/Compte/UpdateCompte.jsp";
	private static final CompteService serviceCt = CompteServiceImpl.getInstance();
	private static final TypeCompteService serviceTc = TypeCompteServiceImpl.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateCompteServlet() {
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

		
		String idCompte = request.getParameter("id");
		long idC = Long.parseLong(idCompte);

		Compte cT = serviceCt.find(idC);

		request.setAttribute("compte", cT);	
		List<TypeCompte> list=serviceTc.findAll();

		request.setAttribute("listTc", list);

		request.getServletContext().getRequestDispatcher(URL).forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(); 

		Compte ctSession = (Compte) session.getAttribute("Compte");
		
		String idCompte = request.getParameter("id");
		System.out.println(idCompte);
		long idC = Long.parseLong(idCompte);
		System.out.println(idC);

		Compte cT = serviceCt.find(idC);
		
		String email = request.getParameter("compteEmail");
		String pseudonyme = request.getParameter("pseudonyme");
		String idTypeCompte = request.getParameter("TypeCompte");

		String baniCocher = request.getParameter("bani");
		String validerCocher=request.getParameter("valider");
		String signaleCocher=request.getParameter("signale");
		String supprimerCocher=request.getParameter("supprimer");
		String effaceCocher=request.getParameter("efface");
		boolean bani,valider,signale, supprimer, efface;
		
		
		if (baniCocher !=null) {
			bani=true;
		} else {
			bani = false;
		}
		if (validerCocher!=null) {
			valider= true;
		} else {
			valider = false;
		}
		if (signaleCocher!=null) {
			signale= true;
		} else {
			signale = false;
		}
		if (supprimerCocher!=null) {
			supprimer= true;
		} else {
			supprimer = false;
		}
		if (effaceCocher!=null) {
			efface= true;
		} else {
			efface = false;
		}

		long id = Long.parseLong(idTypeCompte);
		TypeCompte tc = serviceTc.find(id);

		if(ctSession!=null) {
			if((ctSession.getTypeCompte().getTypeCompte()==1)||(ctSession==cT)) {
				cT.setBani(bani);
				cT.setEfface(efface);
				cT.setEmail(email);
				//cT.setMotDePasse()
				cT.setPseudo(pseudonyme);
				cT.setSignale(signale);
				cT.setSuppressionDonnee(supprimer);
				cT.setTypeCompte(tc);
				cT.setValide(valider);
				
				cT = serviceCt.update(cT);
				
				request.setAttribute("compte", cT);
				response.sendRedirect(request.getContextPath() + "/index");
				
			} else {
				System.out.println("merci de verifier vos droits");
			}
		}else {
			System.out.println("erreur");
		}
	
		
	}

}
