package com.dlx.onemediapieceservlet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the Article database table.
 * 
 */
@Entity
@Table(name="Article")
@NamedQuery(name="Article.findAll", query="SELECT a FROM Article a")
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private long article;

	@Column(nullable=false, length=8192)
	private String contenu;

	//@Temporal(TemporalType.TIMESTAMP)((((((?)))))
	@Column(nullable=false)
	private Date date;

	@Column(nullable=false)
	private boolean modere;

	@Column(name="public", nullable=false)
	private boolean public_;

	@Column(nullable=false, length=128)
	private String titre;

	//uni-directional many-to-one association to Compte
	@ManyToOne
	@JoinColumn(name="compte", nullable=false)
	private Compte compte;

	public Article() {
	}

	public long getArticle() {
		return this.article;
	}

	public void setArticle(long article) {
		this.article = article;
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

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Compte getCompte() {
		return this.compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

}