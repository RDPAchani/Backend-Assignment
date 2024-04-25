package bookstore.bookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Bookstore {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    private int year;
    private String isbn;
    private double price;

    public Bookstore() {


	}

    public Bookstore( String title, String author, int year, String isbn, double price) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
        this.isbn = isbn;
        this.price=price;
	}

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

    public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

    public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

    public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
    
    public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


    @Override
	public String toString() {
		return "Bookstore [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", price=" + price + ", year=" + year + "]";
	}

}