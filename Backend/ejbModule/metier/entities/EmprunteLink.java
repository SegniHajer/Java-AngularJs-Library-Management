package metier.entities;

import java.io.Serializable;
import java.lang.Long;
import java.time.LocalDateTime;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: EmprunteLink
 *
 */
@Entity(name="emprunte")

public class EmprunteLink implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	

    @ManyToOne
    @JoinColumn(name = "book_id")
    Book book;
 
  
	@ManyToOne
    @JoinColumn(name = "adherant_id")
    Adherent adherant;
 
   
	LocalDateTime dateEmprunt;
    

	LocalDateTime dateRetour;

	private static final long serialVersionUID = 1L;

	public EmprunteLink() {
		super();
	} 
	public Book getBook() {
			return book;
		}
	public void setBook(Book book) {
			this.book = book;
		}
		
	public Adherent getAdherant() {
				return adherant;
			}
	public void setAdherant(Adherent adherant) {
				this.adherant = adherant;
			}			
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    public LocalDateTime getDateEmprunt() {
		return dateEmprunt;
	}
	public void setDateEmprunt(LocalDateTime dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}
	
    
	public LocalDateTime getDateRetour() {
		return dateRetour;
	}
	public void setDateRetour(LocalDateTime dateRetour) {
		this.dateRetour = dateRetour;
	}
}
