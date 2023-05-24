package com.dlx.onemediapieceservlet.dao.jpa;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import java.util.ArrayList;
import com.dlx.onemediapieceservlet.dao.AbstractDao;
import com.dlx.onemediapieceservlet.dao.Dao;
import com.dlx.onemediapieceservlet.model.Commentaire;
import com.dlx.onemediapieceservlet.model.Commentaire_;
import com.dlx.onemediapieceservlet.model.Compte;

public class CommentaireDaoJpa extends AbstractDao<Commentaire> implements Dao<Commentaire> {

	private static final  CommentaireDaoJpa  INSTANCE = new CommentaireDaoJpa();

	@Override
	public String getTableName() {
		return "Commentaire";
	}

	@Override
	public Class<Commentaire> getClassName() {
		return Commentaire.class;
	}

	public static CommentaireDaoJpa getInstance() {
		return INSTANCE;
	}


	@SuppressWarnings("unchecked")
	public  List<Commentaire> findAllCmt(long idArt) {
		List<Commentaire> cmts = null;
		String query = "Select t FROM " + getTableName() + " t WHERE t.article.article = :idArt";
		//System.out.println("Query: " + query);

		try {
			cmts = (List<Commentaire>)this.em.createQuery(query).setParameter("idArt", idArt).getResultList()	;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			throw e;
		}

		return cmts;
	}

	public List<Commentaire> findAllCmtPublic(long idArt) {
		List<Commentaire> cmts = INSTANCE.findAllCmt(idArt);
		List<Commentaire> cmtsPublic = new ArrayList<Commentaire>();
		for(Commentaire cmt : cmts) {
			if(cmt.getPublic_()) {
				cmtsPublic.add(cmt);
			}else {
				System.out.println("no commentaire");
			}
		}
		return cmtsPublic;
	}

	public List<Commentaire> findCommentaireFetchCompte(Long idArticle) {
       // EntityManager em = EntityManagerSingleton.getInstance().getEntityManager();
         CriteriaBuilder builder = this.em.getCriteriaBuilder();
         CriteriaQuery<Commentaire> query = builder.createQuery(Commentaire.class); // SELECT Commentaire.*, (( + le fetch ))
         Root<Commentaire> root = query.from(Commentaire.class); // FROM Commentaire c
         query.select(root); // A ce moment je donne l'ordre à ma requete de faire le fro : SELECT Article.* FROM
         
        
         Fetch<Commentaire, Compte> fetchCompte = root.fetch(Commentaire_.compte, JoinType.INNER); // Permet 2 choses,
         // Rajoute un INNER JOIN Compte cpt ON = c.compte = cpt.compte
         // puis modifie le select en : SELECT Commentaire.*, Compte.*
         
         // et là on va construire le where pour filter les commentaires avec l'id de l'article
         query.where(builder.equal(root.get(Commentaire_.article), idArticle));
         // Rajoute le WHERE cpt.id = idArtlce
         
         return this.em.createQuery(query).getResultList();    
    }
   //  List<Commentaire> findCommentaireFetchCompte(Long idArticle); 

}
