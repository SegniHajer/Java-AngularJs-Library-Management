package service;

import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import business.AdherentQuery;
import business.BookQuery;
import business.EmprunteQuery;
import metier.entities.Adherent;
import metier.entities.Book;
import metier.entities.EmprunteLink;
@Transactional 
@Stateless
@Path("/emprunte")
public class EmprunteRestService {
	@EJB
	private EmprunteQuery metier;
	@EJB 
	private BookQuery bookQuery;
	@EJB 
	private AdherentQuery adherentQuery;
	
	@PUT
	@Path("/addEmprunte")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/x-www-form-urlencoded")
	public EmprunteLink addEmprunte(@FormParam("adherentId") Long adherentId, @FormParam("bookId") Long bookId){
	     final int EMPRUNTE_PERIOD=21;
		System.out.println("adherentId"+adherentId);
		EmprunteLink emprunte=new EmprunteLink();
		emprunte.setDateRetour(LocalDateTime.now().plusDays(EMPRUNTE_PERIOD));
		/*trouver l'adherent */
		Adherent adherent= adherentQuery.getAdherant(adherentId);
		emprunte.setAdherant(adherent);
		/*trouver le livre*/
		Book book= bookQuery.getBook(bookId);
		book.setAvailable(false);
		emprunte.setBook(book);
		

		return metier.addEmprunte(emprunte);
	}
	
	@GET
	@Path("/findEmprunte/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public EmprunteLink getEmprunte(@PathParam(value="id")Long id) {
		return metier.getEmprunte(id);
	}
	

	@GET
	@Path("/allEmpruntes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EmprunteLink> getAllEmpruntes() {
		return metier.getAllEmpruntes();
	}
	
	

	
}
