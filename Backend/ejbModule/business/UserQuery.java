package business;

import java.util.List;

import metier.entities.User;

public interface UserQuery {
	/**
	 *  add User	
	 * @param b
	 * @return
	 */
	public User addUser(User b);

	/***
	 * 
	 * @param identifier
	 * @param name
	 * @return
	 */

	public User updateUser( Long id,String name);

	/**
	 * 
	 * @param id
	 * @return
	 */

	public User getUser(Long id);

	/**
	 * 
	 * @return all books
	 */

	public List<User> getAllUser();

	/***
	 * 
	 * @param identifier
	 */
	public void deleteUser(Long id);
}
