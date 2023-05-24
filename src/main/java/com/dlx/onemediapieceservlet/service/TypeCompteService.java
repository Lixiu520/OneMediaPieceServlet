package com.dlx.onemediapieceservlet.service;

import com.dlx.onemediapieceservlet.dao.Dao;
import com.dlx.onemediapieceservlet.model.TypeCompte;

public interface TypeCompteService extends  Dao<TypeCompte>{
	
	public TypeCompte create(String label);
	
	public Dao<TypeCompte> getDao()
;

	
}
