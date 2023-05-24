package com.dlx.onemediapieceservlet.dao.jpa;

import com.dlx.onemediapieceservlet.dao.Dao;
import com.dlx.onemediapieceservlet.model.TypeCompte;
import com.dlx.onemediapieceservlet.dao.AbstractDao;

public class TypeCompteDaoJpa extends AbstractDao<TypeCompte> implements Dao<TypeCompte> {

	private static final  Dao<TypeCompte>  INSTANCE = new TypeCompteDaoJpa();	
	
	

	@Override
	public String getTableName() {

		return "TypeCompte";
	}

	public static Dao<TypeCompte> getInstance() {
		
		return INSTANCE;
	}

	@Override
	public Class<TypeCompte> getClassName() {
		return TypeCompte.class;
	}

	
}
