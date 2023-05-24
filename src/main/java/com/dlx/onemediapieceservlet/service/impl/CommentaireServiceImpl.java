package com.dlx.onemediapieceservlet.service.impl;

import java.util.Date;
import java.util.List;

import com.dlx.onemediapieceservlet.dao.Dao;
import com.dlx.onemediapieceservlet.dao.jpa.CommentaireDaoJpa;
import com.dlx.onemediapieceservlet.model.Article;
import com.dlx.onemediapieceservlet.model.Commentaire;
import com.dlx.onemediapieceservlet.model.Compte;
import com.dlx.onemediapieceservlet.service.AbstractService;
import com.dlx.onemediapieceservlet.service.CommentaireService;

public class CommentaireServiceImpl extends AbstractService<Commentaire> implements Dao<Commentaire>, CommentaireService{
	private static final CommentaireService INSTANCE = new CommentaireServiceImpl();
	
	@Override
	public Commentaire create(Article art, String contenu, Compte ct, boolean public_, Date date) {
		
		Commentaire cmt = new Commentaire();
		
		cmt.setContenu(contenu);
		
		cmt.setDate(date);
		
		cmt.setArticle(art);
		
		cmt.setModere(false);
		
		cmt.setPublic_(public_);
		cmt.setCompte(ct);
		
		cmt = getDao().save(cmt);
		
		return cmt;
	}

	@Override
	public Dao<Commentaire> getDao() {
		return CommentaireDaoJpa.getInstance();
	}

	@Override
	public String getTableName() {
		return "Commentaire";
	}

	@Override
	public Class<Commentaire> getClassName() {
		return Commentaire.class;
	}

	public static CommentaireService getInstance() {
		return INSTANCE;
	}

	@Override
	public List<Commentaire> findAllCmt(long idArt) {
		return  CommentaireDaoJpa.getInstance().findAllCmt(idArt);
	}

	@Override
	public List<Commentaire> findAllCmtPublic(long idArt) {
		// TODO Auto-generated method stub
		return CommentaireDaoJpa.getInstance().findAllCmtPublic(idArt);
	}





	
	
	

}
