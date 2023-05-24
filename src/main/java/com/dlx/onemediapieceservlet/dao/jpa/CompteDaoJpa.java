package com.dlx.onemediapieceservlet.dao.jpa;



import com.dlx.onemediapieceservlet.dao.AbstractDao;
import com.dlx.onemediapieceservlet.dao.Dao;
import com.dlx.onemediapieceservlet.model.Compte;


public class CompteDaoJpa extends AbstractDao<Compte> implements Dao<Compte> {

	private static final  CompteDaoJpa  INSTANCE = new CompteDaoJpa();

	@Override
	public String getTableName() {
		return "Compte";
	}

	@Override
	public Class<Compte> getClassName() {
		return Compte.class;
	}

	public static CompteDaoJpa getInstance() {
		return INSTANCE;
	}


	public Compte findByEmailMDP(String email, String motDePass) {

		Compte ct=null;


		String query = "Select t FROM " + getTableName() + " t WHERE t.email = :email";
		//System.out.println("Query: " + query);

		ct = (Compte) this.em.createQuery(query).setParameter("email", email).getSingleResult();

		if(ct!= null && ct.getMotDePasse().equals(motDePass)) {
			return ct;
		}else {
			return null;
		}
		/*	try {
		    ct= (Compte) this.em.createQuery("Select t FROM "+ getTableName() +" t WHERE t.email = :email").setParameter("email", email).getSingleResult();
		    if(ct!= null && ct.getMotDePasse().equals(motDePass)) {
				return ct;
			}else {
			return null;
			}

		} catch (Throwable e) {
		    throw e;

		}*/

	}


}
