package com.dlx.onemediapieceservlet.service;

import java.util.Date;
import java.util.List;

import com.dlx.onemediapieceservlet.dao.Dao;
import com.dlx.onemediapieceservlet.model.Article;
import com.dlx.onemediapieceservlet.model.Compte;

public interface ArticleService extends Dao<Article>{
	
	
	
	public Dao<Article> getDao();

	

	public Article create(Compte ct, String titre, String contenu, Date date, boolean public_);

	public List<Article> findArticlesById(Compte ct);



	public List<Article> findArticlePublic();



	public Compte findCtByArt(long idArticle);





	
	

}
