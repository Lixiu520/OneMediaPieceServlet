package com.dlx.onemediapieceservlet.service.impl;

import com.dlx.onemediapieceservlet.dao.Dao;
import com.dlx.onemediapieceservlet.dao.jpa.ArticleDaoJpa;
import com.dlx.onemediapieceservlet.model.Article;
import com.dlx.onemediapieceservlet.service.AbstractService;
import com.dlx.onemediapieceservlet.service.ArticleService;
import com.dlx.onemediapieceservlet.model.Compte;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ArticleServiceImpl extends AbstractService<Article> implements  ArticleService ,Dao<Article> {

	private static final ArticleService INSTANCE = new ArticleServiceImpl();

	@Override
	public Article create(Compte ct, String titre, String contenu, Date date, boolean public_) {

		Article art = new Article();

		art.setCompte(ct);

		art.setContenu(contenu);

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = dateFormat.format(date);
		try {
			art.setDate(dateFormat.parse(formattedDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		art.setModere(false);

		art.setPublic_(public_);

		art.setTitre(titre);

		art = getDao().save(art);

		return art;
	}




	public static ArticleService getInstance() {
		return INSTANCE;
	}



	@Override
	public Dao<Article> getDao() {
		return ArticleDaoJpa.getInstance();
	}




	@Override
	public String getTableName() {
		return "Article";
	}




	@Override
	public Class<Article> getClassName() {
		return Article.class;
	}







	@Override
	public List<Article> findArticlesById(Compte ct) {

		return ArticleDaoJpa.getInstance().findArticlesById(ct);
	}




	@Override
	public List<Article> findArticlePublic() {
		// TODO Auto-generated method stub
		return ArticleDaoJpa.getInstance().findArticlePublic();
	}




	@Override
	public Compte findCtByArt(long idArticle) {
		// TODO Auto-generated method stub
		return ArticleDaoJpa.getInstance().findCtByArt(idArticle);
	}









}
