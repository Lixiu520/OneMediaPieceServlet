package com.dlx.onemediapieceservlet.dao;

import java.util.List;


public interface Dao<T> {

	T save(T t);
	
	T update(T t);
	
	T delete(T t);
	
	List<T> findAll();
	
	T find(long id);


	
}
