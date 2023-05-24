package com.dlx.onemediapieceservlet.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Compte database table.
 * 
 */
@Entity
@Table(name="Compte")
@NamedQuery(name="Compte.findAll", query="SELECT c FROM Compte c")
public class Compte implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private long compte;

	@Column(nullable=false)
	private boolean bani;

	@Column(nullable=false)
	private boolean efface;

	@Column(nullable=false, length=256)
	private String email;

	@Column(nullable=false, length=128)
	private String motDePasse;

	@Column(nullable=false, length=45)
	private String pseudo;

	@Column(nullable=false)
	private boolean signale;

	@Column(nullable=false)
	private boolean suppressionDonnee;

	@Column(nullable=false)
	private boolean valide;

	//uni-directional many-to-one association to TypeCompte
	@ManyToOne
	@JoinColumn(name="typeCompte", nullable=false)
	private TypeCompte typeCompte;

	public Compte() {
	}

	public long getCompte() {
		return this.compte;
	}

	public void setCompte(long compte) {
		this.compte = compte;
	}

	public boolean getBani() {
		return this.bani;
	}

	public void setBani(boolean bani) {
		this.bani = bani;
	}

	public boolean getEfface() {
		return this.efface;
	}

	public void setEfface(boolean efface) {
		this.efface = efface;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return this.motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getPseudo() {
		return this.pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public boolean getSignale() {
		return this.signale;
	}

	public void setSignale(boolean signale) {
		this.signale = signale;
	}

	public boolean getSuppressionDonnee() {
		return this.suppressionDonnee;
	}

	public void setSuppressionDonnee(boolean suppressionDonnee) {
		this.suppressionDonnee = suppressionDonnee;
	}

	public boolean getValide() {
		return this.valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	public TypeCompte getTypeCompte() {
		return this.typeCompte;
	}

	public void setTypeCompte(TypeCompte typeCompte) {
		this.typeCompte = typeCompte;
	}

}