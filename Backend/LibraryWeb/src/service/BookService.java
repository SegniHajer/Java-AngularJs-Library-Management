package service;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import business.BookQuery;
import metier.entities.Book;

@WebService
public class BookService {
	@EJB
	private BookQuery metier;
	
	@WebMethod
	public void addBook(@WebParam(name="id")Long identifier,@WebParam(name="title")String title,
			@WebParam(name="author")String author,@WebParam(name="isAvailable")boolean status) {
		Book book= new Book();
		book.setId(identifier);
		book.setTitle(title);
		book.setAuthor(author);
		book.setAvailable(status);
		metier.addBook(book);
		
	}
/*	@WebMethod
	public Book updateStatusBook(@WebParam(name="id")Long identifier,@WebParam(name="isAvailable") boolean status) {
		return metier.updateStatusBook(identifier, status);
	}*/
	@WebMethod
	public Book getBook(@WebParam(name="id")Long identifier) {
		return metier.getBook(identifier);
	}
	@WebMethod
	public List<Book> getAllBook() {
		return metier.getAllBook();
	}
	@WebMethod
	public void deleteBook(@WebParam(name="id")Long identifier) {
		metier.deleteBook(identifier);
	}



}
