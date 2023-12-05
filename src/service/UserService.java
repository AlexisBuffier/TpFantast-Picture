package service;

import java.util.HashMap;
import java.util.Map;

import entite.User;

public class UserService {
	
	Map<String, User> userList = new HashMap<>();

	public Map<String, User> getUserList()
	{
	    User UserAlexis 	= new User("Alexis", "123");
	    User UserValentin 	= new User("Valentin", "123");
	    
	    userList.put(UserAlexis.getPrenom(), UserAlexis);
	    userList.put(UserValentin.getPrenom(), UserValentin);
	    
	    return userList;
	}
	
	public User log(String nom, String mdp)
	{
		for(User user : userList.values())
		{
			if(user.getPrenom().equals(nom) && user.getMdp().equals(mdp))
			{
				User userConnecte = new User(nom, mdp);
				
				return userConnecte;
			}
		}
		return null;
	}
	
}
