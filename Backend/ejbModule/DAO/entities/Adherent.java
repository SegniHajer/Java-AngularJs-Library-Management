package metier.entities;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Adherent
 *
 */
@Entity(name="adherent")

public class Adherent implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private String numTel;
	private LocalDateTime dateInscription;
	private String ville;
	private int codePostale;

	private int emprunteNumber;
	@OneToMany(mappedBy = "adherant")
	private Set<EmprunteLink> empruntes;
	 
	private static final long serialVersionUID = 1L;

	public Adherent() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}   
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	public LocalDateTime getDateInscription() {
		return dateInscription;
	}
	public void setDateInscription(LocalDateTime dateInscription) {
		this.dateInscription = dateInscription;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public int getCodePostale() {
		return codePostale;
	}
	public void setCodePostale(int codePostale) {
		this.codePostale = codePostale;
	}

	public void setEmprunteNumber(int emprunteNumber) {
		this.emprunteNumber = emprunteNumber;
	}
	public int getEmprunteNumber() {
		return emprunteNumber;
	}
}
