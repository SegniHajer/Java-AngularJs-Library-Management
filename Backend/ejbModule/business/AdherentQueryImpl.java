package business;

import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entities.Adherent;
import metier.entities.Book;
@Stateless
public class AdherentQueryImpl implements AdherentQuery{
   /* @PersistenceContext
	EntityManager em;
	*/
	@PersistenceContext
	EntityManager em;
    
	@Override
	public Adherent addAdherant(Adherent adherant) {
		// TODO Auto-generated method stub
		em.persist(adherant);
		return adherant;	}

	@Override
	public Adherent updateAdherant(Long id,String name, String surname,String numTel,LocalDateTime dateInscription,String ville,int codePostale,int emprunteNumber) {
		Adherent foundAdherant= getAdherant(id);
		foundAdherant.setNom(name);
		foundAdherant.setPrenom(surname);
		foundAdherant.setEmprunteNumber(emprunteNumber);
		foundAdherant.setCodePostale(codePostale);
		foundAdherant.setNumTel(numTel);
		foundAdherant.setDateInscription(dateInscription);
		foundAdherant.setVille(ville);
		return foundAdherant;
	}

	@Override
	public Adherent getAdherant(Long id) {
		// TODO Auto-generated method stub
		Adherent adherant= em.find(Adherent.class, id);
	        if(adherant==null) throw new RuntimeException("auncun adherent trouv�");
			return adherant;
	}

	@Override
	public List<Adherent> getAllAdherant() {
		// TODO Auto-generated method stub
		Query query= em.createQuery("select ad from adherent ad");
		return query.getResultList();
	}

	@Override
	public void deleteAdherant(Long id) {
		// TODO Auto-generated method stub
		Adherent adherant= getAdherant(id);
		em.remove(adherant);
	}

}
