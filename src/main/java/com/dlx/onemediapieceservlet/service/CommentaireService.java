package com.dlx.onemediapieceservlet.service;

import java.util.Date;
import java.util.List;

import com.dlx.onemediapieceservlet.dao.Dao;
import com.dlx.onemediapieceservlet.model.Article;
import com.dlx.onemediapieceservlet.model.Commentaire;
import com.dlx.onemediapieceservlet.model.Compte;

public interface CommentaireService extends Dao<Commentaire>, Service<Commentaire> {
	


	public Dao<Commentaire> getDao();

	public Commentaire create(Article art, String contenu, Compte ct, boolean public_, Date date);

	public List<Commentaire> findAllCmt(long idArt);

	public List<Commentaire> findAllCmtPublic(long idArt);
}
