package service;

import javax.ejb.EJB;


import business.BookQuery;

public class UserRestService {
	@EJB
	private BookQuery metier;
	
}
