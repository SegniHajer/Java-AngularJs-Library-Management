package service;


import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import business.BookQuery;
import metier.entities.Book;
@Stateless
@Path("/book")
public class BookRestService {
	@EJB
	private BookQuery metier;
	
	@PUT
	@Path("/addBook")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/x-www-form-urlencoded")
	public Book addBook(@FormParam("title") String title,@FormParam("author") String author,@FormParam("theme") String theme ){
		  Book book=new Book();
		System.out.println("title"+title);
       
		book.setTitle(title);
		book.setAuthor(author);
		book.setTheme(theme);
		return metier.addBook(book);
	}
	
	
	/*@POST
	@Path("/book")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("multipart/form-data")
	//@Consumes(MediaType.APPLICATION_JSON)
	public Book addBook(String input) throws IOException {
		//String jsonStr = input.getFormDataPart("book", String.class,null);
		System.out.println("jsonobj");
		Object obj= new Object();
         Book book1=new Book();
		/*book.setTitle(title);
		book.setAuthor(author);
		return metier.addBook(book1);
	}*/
	
	@GET
	@Path("/findBook/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Book getBook(@PathParam(value="id")Long id) {
		return metier.getBook(id);
	}
	
	@GET
	@Path("/findBookByName/{title}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> findBookByName(@PathParam(value="title")String title) {
		return metier.findBookByName(title);
	}
	
	@GET
	@Path("/allBooks")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getAllBooks() {
		return metier.getAllBook();
	}
	
	
	
	@PUT
	@Path("/updateBook/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/x-www-form-urlencoded")
	public Book updateBook(@FormParam(value="id")Long id,@FormParam("title") String title,@FormParam("author") String author,@FormParam("theme") String theme) {
		return metier.updateStatusBook(id,title,author,theme);
	}
	
	@DELETE
	@Path("/deleteBook/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteBook(@PathParam(value="id")Long identifier) {
		 metier.deleteBook(identifier);
	}
	
}
