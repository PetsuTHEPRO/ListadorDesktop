package com.infinitycorp.model.entity;

import java.util.Date;

public class CurrentUser {

	private static Long id;
    private static String name;
    private static String lastName;
    private static String user; 
    private static String email;
    private static String password;
    private static Date birthDate;

    public static void setClient(Client client) {
    	CurrentUser.id = client.getId();
    	CurrentUser.name = client.getName();
    	CurrentUser.lastName = client.getLastName();
    	CurrentUser.user = client.getUser();
    	CurrentUser.email = client.getEmail();
    	CurrentUser.password = client.getPassword();
    	CurrentUser.birthDate = client.getBirthDate();
    }

    public static void setId(Long id) {
        CurrentUser.id = id;
    }
    
    public static void setName(String name) {
        CurrentUser.name = name;
    }
    
    public static void setLastName(String lastName) {
        CurrentUser.lastName = lastName;
    }
    
    public static void setUser(String user) {
        CurrentUser.user = user;
    }
    
    public static void setEmail(String email) {
        CurrentUser.email = email;
    }

    public static void setPassword(String password) {
        CurrentUser.password = password;
    }
    
    public static void setBirthDate(Date birthDate) {
        CurrentUser.birthDate = birthDate;
    }
    
    public static Client getCurrentUser() {
    	return new Client(CurrentUser.id, CurrentUser.name, CurrentUser.lastName, CurrentUser.email, CurrentUser.user, CurrentUser.password, CurrentUser.birthDate);
    }

}