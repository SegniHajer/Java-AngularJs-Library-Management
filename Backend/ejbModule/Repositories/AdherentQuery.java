package business;

import java.time.LocalDateTime;
import java.util.List;

import metier.entities.Adherent;

public interface AdherentQuery {
	/**
	 * 
	 * @param adherant
	 * @return
	 */
	public Adherent addAdherant(Adherent adherant);

	/**
	 * 
	 * @param id
	 * @param name
	 * @param surname
	 * @param emprunteActuelle
	 * @return
	 */

	public Adherent updateAdherant( Long id,String name, String surname,String numTel,LocalDateTime dateInscription,String ville,int codePostale,int emprunteNumber);

	/**
	 * 
	 * @param identifier
	 * @return
	 */

	public Adherent getAdherant(Long id);

	/**
	 * 
	 * @return all books
	 */

	public List<Adherent> getAllAdherant();

	/***
	 * 
	 * @param identifier
	 */
	public void deleteAdherant(Long id);
}
