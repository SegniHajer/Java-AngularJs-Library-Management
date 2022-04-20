package service;

import java.time.LocalDateTime;
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

import business.AdherentQuery;
import metier.entities.Adherent;

@Stateless

@Path("/adherent")
public class AdherentRestService {
	@EJB
	private AdherentQuery metier;
	
	@PUT
	@Path("/addAdherent")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/x-www-form-urlencoded")
	public Adherent addBook(@FormParam(value="nom")String nom,@FormParam(value="prenom") String prenom,@FormParam(value="numTel")String numTel,@FormParam(value="ville")String ville,@FormParam(value="codePostale")int codePostale){
		  Adherent adherant=new Adherent();
	      System.out.println("nom"+nom);
       
		adherant.setNom(nom);
		adherant.setPrenom(prenom);
		adherant.setNumTel(numTel);
		adherant.setVille(ville);
		adherant.setCodePostale(codePostale);
		adherant.setDateInscription(LocalDateTime.now());
		adherant.setEmprunteNumber(1);
		return metier.addAdherant(adherant);
	}
	
	@GET
	@Path("/adherent/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Adherent getAdherent(@PathParam(value="id")Long id) {
		return metier.getAdherant(id);
	}
	
	@GET
	@Path("/allAdherents")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Adherent> getAllAdherents() {
		return metier.getAllAdherant();
	}
	
	
	
	@PUT
	@Path("/updateAdherent")
	@Produces(MediaType.APPLICATION_JSON)
	public Adherent updateAdherent(@FormParam(value="id")Long id,@FormParam(value="name")String name,@FormParam(value="surname") String surname,@FormParam(value="numTel")String numTel,@FormParam(value="ville")String ville,@FormParam(value="codePostale")int codePostale,@FormParam(value="emprunteNumber")int emprunteNumber) {
		 LocalDateTime dateInscription=LocalDateTime.now();
		return metier.updateAdherant(id, name,  surname, numTel, dateInscription, ville, codePostale, emprunteNumber);
	}
	
	@DELETE
	@Path("/deleteBook/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteAdherant(@PathParam(value="id")Long id) {
		 metier.deleteAdherant(id);
	}
	
}
