package metier.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Book
 *
 */
@Entity(name="book")
public class Book implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String author;
	private String Theme;
	boolean available=true;
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "book")
	private Set<EmprunteLink> empruntes;
	
	public Book() {
		super();
	}   
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}   
	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public String getTheme() {
		return Theme;
	}
	public void setTheme(String Theme) {
		this.Theme = Theme;
	}
	
}
