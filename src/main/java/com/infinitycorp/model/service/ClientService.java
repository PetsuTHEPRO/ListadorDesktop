
package com.infinitycorp.model.service;

import java.util.Optional;

import com.infinitycorp.model.DAO.ClientDAO;
import com.infinitycorp.model.entity.Client;
import com.infinitycorp.model.entity.CurrentUser;

public class ClientService {
    
    private final ClientDAO clientDAO;
  
    public ClientService() {
          this.clientDAO = new ClientDAO(HibernateUtil.getSessionFactory());
    }
    
    public boolean authenticate(String user, String password) {
    	if(clientDAO.verifyEmailAndPassword(user, password)) {
    		Optional.ofNullable(clientDAO.selectQueryWhereUser(user)).ifPresent(x -> CurrentUser.setClient(x));
    		return true;
    	}else {
        	return false;
    	}
    }
    
    public boolean checkIfClientExists(String user){
        return clientDAO.checkUserExists(user);
    }
    
    public boolean registerSucess(Client client){
    	return clientDAO.save(client);
    }
    
}
