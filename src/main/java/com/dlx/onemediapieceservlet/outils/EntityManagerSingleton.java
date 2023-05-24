package com.dlx.onemediapieceservlet.outils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerSingleton {


	/** l'unique instance de mon singleton dans ma JVM */
    private final static EntityManagerSingleton INSTANCE = new EntityManagerSingleton();
    
    /** Mon entity manager relié à ma PU 'blog'  */
    private EntityManager entityManager;
    
    /** Constructor privé, on ne veut pas y accéder depuis l'xeterieur:  principle du singleton */
    private EntityManagerSingleton(){
        // JPA va scanner le fichier persistance.xml et récupérer la persistance unit (PU) qui s'appelle blog
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog");
        
        this.entityManager = emf.createEntityManager();
    }

    public static EntityManagerSingleton getInstance() {
    	
        return INSTANCE;
    }

    public EntityManager getEntityManager() {
    	
        return entityManager;
    }

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public EntityManagerSingleton(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	
}


