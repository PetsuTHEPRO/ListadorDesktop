
package com.infinitycorp.model.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.infinitycorp.model.entity.Client;


public class ClientDAO {

    private final SessionFactory sessionFactory;
    
    public ClientDAO(SessionFactory sessionFactory) {
    	this.sessionFactory = sessionFactory;
    }
    
    public Client selectQueryWhereUser(String user) {
    	try {
    		
    		Session session = sessionFactory.openSession();
    		Query query = session.createQuery("SELECT c FROM Client c WHERE c.user = :user");
    		query.setParameter("user", user);
    		Client client = (Client) query.uniqueResult();
    		session.close();
    		
    		return client;
    		
    	}catch(Exception ex){
    		System.out.println("Erro ao tentar executar a Query:" + ex);
    		return null;
    	}
    }
    
    public boolean save(Client client) {
    	
    	try {
    		Session session = sessionFactory.openSession();
        	Transaction transaction = session.beginTransaction();
        	session.merge(client);
        	transaction.commit();
        	session.close();
    	}catch(Exception ex) {
    		System.out.println("Erro ao tentar persistir o cliente: " + ex);
    		return false;
    	}
    	return true;
    }
    
    public boolean verifyEmailAndPassword(String user, String password) {
    	try {
    		Session session = sessionFactory.openSession();
    		Query query = session.createQuery("SELECT COUNT(*) FROM Client WHERE user = :user AND password = : password");
    		query.setParameter("user", user);
    		query.setParameter("password", password);
    		Long count = (Long) query.uniqueResult();
    		session.close();
    		
    		if (count > 0) {
	    	    return true;
	    	} else {
	    		return false;
	    	}
    		
    	}catch(Exception ex){
    		System.out.println("Erro ao tentar executar a Query" + ex);
    		return false;
    	}
    }

    public boolean checkUserExists(String user) {
    	try {
	    	Session session = sessionFactory.openSession();
	    	Query query = session.createQuery("SELECT COUNT(*) FROM Client WHERE user = :user");
	    	query.setParameter("user", user);
	    	Long count = (Long) query.uniqueResult();
	    	session.close();

	    	if (count > 0) {
	    	    return true;
	    	} else {
	    		return false;
	    	}
    	}catch(Exception ex) {
    		System.out.println("Erro ao tentar executar a Query" + ex);
    		return true;
    	}
    }

}
