package edu.isep.JDBC;

public class UserManager {

	private static UserManager sharedInstance; 

	public static UserManager sharedInstance(){
		return initInstance();
	}

	public User currentUser;

	private UserManager() {

	}

	private static UserManager initInstance(){
		if ( sharedInstance == null ){
			sharedInstance = new UserManager();
		}
		return sharedInstance;
	}
}