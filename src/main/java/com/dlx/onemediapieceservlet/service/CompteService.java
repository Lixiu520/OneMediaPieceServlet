package com.dlx.onemediapieceservlet.service;


import com.dlx.onemediapieceservlet.dao.Dao;
import com.dlx.onemediapieceservlet.model.Compte;
import com.dlx.onemediapieceservlet.model.TypeCompte;

;
public interface CompteService extends Service<Compte>, Dao<Compte> {
	
	public Compte create(String pseudo, String email, String mdp, TypeCompte tc);
	
	public Dao<Compte>  getDao();

	public Compte findByEmailMDP(String email, String motDePass);

	
	





}
