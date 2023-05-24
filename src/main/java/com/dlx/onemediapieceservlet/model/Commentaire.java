package com.dlx.onemediapieceservlet.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Commentaire database table.
 * 
 */
@Entity
@Table(name="Commentaire")
@NamedQuery(name="Commentaire.findAll", query="SELECT c FROM Commentaire c")
public class Commentaire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private long commentaire;

	@Column(nullable=false, length=8192)
	private String contenu;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date date;

	@Column(nullable=false)
	private boolean modere;

	@Column(name="public", nullable=false)
	private boolean public_;

	//uni-directional many-to-one association to Article
	@ManyToOne
	@JoinColumn(name="Article_article", nullable=false)
	private Article article;

	//uni-directional many-to-one association to Compte
	@ManyToOne
	@JoinColumn(name="compte", nullable=false)
	private Compte compte;

	public Commentaire() {
	}

	public long getCommentaire() {
		return this.commentaire;
	}

	public void setCommentaire(long commentaire) {
		this.commentaire = commentaire;
	}

	public String getContenu() {
		return this.contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean getModere() {
		return this.modere;
	}

	public void setModere(boolean modere) {
		this.modere = modere;
	}

	public boolean getPublic_() {
		return this.public_;
	}

	public void setPublic_(boolean public_) {
		this.public_ = public_;
	}

	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Compte getCompte() {
		return this.compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

}