/**
 * @author Becca Deuser - rddeuser
 * CIS175 - Fall 2021
 * Sep 16, 2021
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BooksToRead")
public class Book {
	@Id
	@GeneratedValue
	@Column(name="ID")
	//declare attributes
	private int id;
	@Column(name="TITLE")
	private String title;
	@Column(name="AUTHOR")
	private String author;
	@Column(name="EXCITEMENT")
	private int excitementRating;

	public Book() {
		this.author = "default";
	}//end default constructor

	public Book(String title, String author, int excitmentRating) {
		this.title = title;
		this.author = author;
		this.excitementRating = excitmentRating;
	}//end non-default constructor
	
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}//end non-default constructor

	public String getTitle() {
		return title;
	}//end getTitle

	public void setTitle(String title) {
		this.title = title;
	}//end setTitle

	public String getAuthor() {
		return author;
	}//end getAuthor

	public void setAuthor(String author) {
		this.author = author;
	}//end setAuthor

	public int getExcitementRating() {
		return excitementRating;
	}//end getExcitmentRating

	public void setExcitementRating(int excitmentRating) {
		this.excitementRating = excitmentRating;
	}//end setExcitmentRating
	
	public String returnItemAttributes() {
		return this.title + ", " + this.author + ", " + this.excitementRating;
	}//end returnItemAttributes
	
}//end Book
