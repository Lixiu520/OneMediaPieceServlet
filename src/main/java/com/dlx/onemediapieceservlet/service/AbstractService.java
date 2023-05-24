package com.dlx.onemediapieceservlet.service;


import java.util.List;

import com.dlx.onemediapieceservlet.dao.AbstractDao;
import com.dlx.onemediapieceservlet.dao.Dao;

public abstract class AbstractService<T> extends AbstractDao<T> implements Service<T> ,Dao<T>{
	
	protected Dao<T> dao;


	@Override
	public T save(T t) {
		return getDao().save(t);
	}

	@Override
	public T update(T t) {
		return getDao().update(t);
	}

	@Override
	public T delete(T t) {
		return getDao().delete(t);
		
	}

	@Override
	public List<T> findAll() {
		return getDao().findAll();
	}

	@Override
	public T find(long id) {
		return getDao().find(id);
	}


	public abstract Dao<T> getDao();
	
}
