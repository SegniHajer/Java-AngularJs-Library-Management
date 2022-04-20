package business;

import java.util.List;

import javax.ejb.Local;

import metier.entities.Book;
@Local
public interface BookQuery {
/**
 *  addd book	
 * @param b
 * @return
 */
public Book addBook(Book b);

/***
 * 
 * @param identifier
 * @param title
 * @param author
 * @param status
 * @return
 */

public Book updateStatusBook( Long id,String title, String author,String theme);

/**
 * 
 * @param identifier
 * @return
 */

public Book getBook(Long id);

/**
 * 
 * @return all books
 */

public List<Book> getAllBook();

/***
 * 
 * @param identifier
 */
public void deleteBook(Long identifier);

public List<Book> findBookByName(String name);
}
