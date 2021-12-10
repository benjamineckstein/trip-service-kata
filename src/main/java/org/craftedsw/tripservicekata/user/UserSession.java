package org.craftedsw.tripservicekata.user;

import org.craftedsw.tripservicekata.exception.CollaboratorCallException;

public class UserSession {

	private static final UserSession userSession = new UserSession();
	
	public UserSession() {
	}
	
	public User getLoggedUser() {
		throw new CollaboratorCallException(
				"UserSession.getLoggedUser() should not be called in an unit test");
	}

}
