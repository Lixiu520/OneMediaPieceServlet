package com.dlx.onemediapieceservlet.service.impl;

import com.dlx.onemediapieceservlet.dao.Dao;
import com.dlx.onemediapieceservlet.dao.jpa.TypeCompteDaoJpa;
import com.dlx.onemediapieceservlet.model.TypeCompte;
import com.dlx.onemediapieceservlet.service.AbstractService;
import com.dlx.onemediapieceservlet.service.TypeCompteService;

public class TypeCompteServiceImpl extends AbstractService<TypeCompte> implements TypeCompteService, Dao<TypeCompte> {

	public static final TypeCompteService  INSTANCE = new TypeCompteServiceImpl();

	@Override
	public TypeCompte create(String label) {
		TypeCompte tc = new TypeCompte();

		tc.setLabel(label);

		tc = getDao().save(tc);

		return tc;
	}

	@Override
	public Dao<TypeCompte> getDao() {
		return TypeCompteDaoJpa.getInstance();
	}

	public static TypeCompteService getInstance() {
		return INSTANCE;
	}

	@Override
	public String getTableName() {
		return "TypeCompte" ;
	}

	@Override
	public Class<TypeCompte> getClassName() {
		return TypeCompte.class;
	}




}
