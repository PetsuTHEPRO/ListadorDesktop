package com.infinitycorp.controller.helpers;

import com.infinitycorp.model.entity.Client;
import com.infinitycorp.view.Login;

public class LoginHelper implements IHelper{
    
    private final Login view;
    
    public LoginHelper(Login view){
        this.view = view;
    }
    
    public Client getModelo(){
        
        String userClient = view.getTxtClient().getText();
        String passwordClient = view.getTxtPassword().getText();
        
        Client modelClient = new Client(0l, null, null, userClient, null, passwordClient, null);
        
        return modelClient;
        
    }
    
    public void setModelo(Client modelClient){
        
        String userClient = modelClient.getUser();
        String passwordClient = modelClient.getPassword();
        
        view.getTxtClient().setText(userClient);
        view.getTxtPassword().setText(passwordClient);
        
    }
    
    public void cleanScreen(){
        view.getTxtClient().setText("");
        view.getTxtPassword().setText("");
    }

    
}
