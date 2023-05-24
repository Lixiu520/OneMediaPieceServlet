package com.dlx.onemediapieceservlet.dao.jpa;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;

import java.util.ArrayList;

import com.dlx.onemediapieceservlet.dao.AbstractDao;
import com.dlx.onemediapieceservlet.dao.Dao;
import com.dlx.onemediapieceservlet.model.Article;
import com.dlx.onemediapieceservlet.model.Compte;
import com.dlx.onemediapieceservlet.outils.EntityManagerSingleton;

public class ArticleDaoJpa extends AbstractDao<Article> implements Dao<Article> {

	private static final ArticleDaoJpa  INSTANCE = new ArticleDaoJpa();

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "Article";
	}

	@Override
	public Class<Article> getClassName() {
		return Article.class;
	}

	public static ArticleDaoJpa getInstance() {
		return INSTANCE;
	}


	
	public List<Article> findArticlesById(Compte ct){
		
		List<Article>  list1 =INSTANCE.findAll();
		List<Article> articlesByCompte = new ArrayList<Article>();
		for(Article art:list1) {
			if( art.getCompte().equals(ct) ) {
				System.out.println(art.getCompte().toString());
				articlesByCompte.add(art);
				
			}else {
				System.out.println("no article");
			}
		}
		
		return articlesByCompte;
		
		
	}

	public List<Article> findArticlePublic() {
		List<Article>  list1 =INSTANCE.findAll();
		List<Article> articlesPublic = new ArrayList<Article>();
		for(Article art:list1) {
			if( art.getPublic_()==true) {
				articlesPublic.add(art);
				
			}else {
				System.out.println("no article");
			}
		}
		
		return articlesPublic;
	}

	public Compte findCtByArt(long idArticle) {
		
		Compte ct=null;
		Article art=null;

		//String query = "Select t FROM " + getTableName() + " t WHERE t.article = :idArticle";
		//System.out.println("Query: " + query);

		//art = (Article) this.em.createQuery(query).setParameter("idArticle", idArticle).getSingleResult();
		art=this.find(idArticle);

		if(art!= null) {
			ct=art.getCompte();
			return ct ;
		}else {
			return null;
		}
		
		//EntityManager em=EntityManagerSingleton.getInstance().getEntityManager();
		
		
		
	};

}
