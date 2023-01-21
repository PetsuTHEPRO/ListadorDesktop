
package com.infinitycorp.model.service;

import com.infinitycorp.model.DAO.ClientDAO;
import com.infinitycorp.model.entity.Client;

public class ClientService {
    
    private final ClientDAO clientDAO;
  
    public ClientService() {
          this.clientDAO = new ClientDAO(HibernateUtil.getSessionFactory());
    }
    
    public boolean checkIfClientExists(Client client){
        return false;
    }
    
    public boolean registerSucess(Client client){
    	return clientDAO.save(client);
    }
    
}
