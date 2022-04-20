package business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entities.Book;
@Stateless(name="Lib")
public class BookQueryImpl implements BookQuery {
    @PersistenceContext
	EntityManager em;
	
	
	@Override
	public Book addBook(Book b) {
		em.persist(b);
		return b;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Book updateStatusBook(Long identifier,String title, String author,String theme) {
				Book foundBook= getBook(identifier);
				foundBook.setTheme(theme);
				foundBook.setTitle(title);
				foundBook.setAuthor(author);
				return foundBook;
	}

	@Override
	public Book getBook(Long id) {
        Book b= em.find(Book.class, id);
        if(b==null) throw new RuntimeException("le livre n'existe pas dans la bibliotheque");
		return b;
	}
	
	@Override
	public List<Book> getAllBook() {
		Query query= em.createQuery("select b from book b");
		return query.getResultList();
	}
	
	@Override
	public void deleteBook(Long identifier) {
		Book b= getBook(identifier);
		em.remove(b);
	}

	@Override
	public List<Book> findBookByName(String title) {
		// TODO Auto-generated method stub
		Query query= em.createQuery("select b from book b where lower(b.title) like :title");
		query.setParameter("title", "%" + title + "%");
		return query.getResultList();
	}



}
