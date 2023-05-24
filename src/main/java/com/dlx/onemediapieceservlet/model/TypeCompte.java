package com.dlx.onemediapieceservlet.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TypeCompte database table.
 * 
 */
@Entity
@Table(name="TypeCompte")
@NamedQuery(name="TypeCompte.findAll", query="SELECT t FROM TypeCompte t")
public class TypeCompte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private long typeCompte;

	@Column(nullable=false, length=24)
	private String label;

	public TypeCompte() {
	}

	public long getTypeCompte() {
		return this.typeCompte;
	}

	public void setTypeCompte(long typeCompte) {
		this.typeCompte = typeCompte;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}