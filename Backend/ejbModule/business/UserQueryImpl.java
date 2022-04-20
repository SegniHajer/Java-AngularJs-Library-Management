package business;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entities.Book;
import metier.entities.User;
@Stateless
public class UserQueryImpl implements UserQuery {
    @PersistenceContext
	EntityManager em;
	
	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		em.persist(user);
		return user;
	}

	@Override
	public User updateUser(Long id, String name) {
		User foundUser= getUser(id);
		foundUser.setName(name);
		return foundUser;
		// TODO Auto-generated method stub
	}

	@Override
	public User getUser(Long id) {
		User user= em.find(User.class, id);
	        if(user==null) throw new RuntimeException("l'utilisateur demandé n'existe pas ");
			return user;
		// TODO Auto-generated method stub
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		Query query= em.createQuery("select user from user user");
		return query.getResultList();	}

	@Override
	public void deleteUser(Long id) {
		
		// TODO Auto-generated method stub
		User b= getUser(id);
		em.remove(b);
		
	}

}
