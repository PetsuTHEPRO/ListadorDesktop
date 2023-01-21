
package com.infinitycorp.model.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.infinitycorp.model.entity.Client;


public class ClientDAO {

    //private final SessionFactory sessionFactory;
    
    public ClientDAO(SessionFactory sessionFactory) {
    	//this.sessionFactory = sessionFactory;
    }
    
    public boolean save(Client client) {
    	
    	try {
    		Configuration config = new Configuration().configure();
    		SessionFactory sessionFactory = config.buildSessionFactory();
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
    /*
    public boolean checkUserExists(Client client) {
    	Session session = sessionFactory.openSession();
    	Query query = session.createQuery("SELECT COUNT(*) FROM client WHERE user = :user");
    	query.setParameter("user", client.getUser());
    	Long count = (Long) query.uniqueResult();
    	session.close();

    	if (count > 0) {
    	    return true;
    	} else {
    		return false;
    	}
    }*/
    
}
