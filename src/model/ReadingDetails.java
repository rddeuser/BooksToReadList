/**
 * @author Becca Deuser - rddeuser
 * CIS175 - Fall 2021
 * Oct 7, 2021
 */
package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author bdeus
 *
 */
@Entity
public class ReadingDetails {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	@ManyToOne (cascade=CascadeType.PERSIST)
	private Reader reader;
	@JoinTable
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Book> booksToRead;
	
	public ReadingDetails() {
		
	}//end default constructor

	public ReadingDetails(int id, String listName, Reader reader, List<Book> booksToRead) {
		this.id = id;
		this.listName = listName;
		this.reader = reader;
		this.booksToRead = booksToRead;
	}//end constructor

	public ReadingDetails(String listName, Reader reader, List<Book> booksToRead) {
		this.listName = listName;
		this.reader = reader;
		this.booksToRead = booksToRead;
	}//end constructor

	public ReadingDetails(String listName, Reader reader) {
		this.listName = listName;
		this.reader = reader;
	}//end constructor

	public int getId() {
		return id;
	}//end getId

	public void setId(int id) {
		this.id = id;
	}//end setId

	public String getListName() {
		return listName;
	}//end getListName

	public void setListName(String listName) {
		this.listName = listName;
	}//end setListName

	public Reader getReader() {
		return reader;
	}//end getReader

	public void setReader(Reader reader) {
		this.reader = reader;
	}//end setReader

	public List<Book> getBooksToRead() {
		return booksToRead;
	}//end getBooksToRead

	public void setBooksToRead(List<Book> booksToRead) {
		this.booksToRead = booksToRead;
	}//end setBooksToRead

	@Override
	public String toString() {
		return "ReadingDetails [id=" + id + ", listName=" + listName + ", reader=" + reader + ", booksToRead="
				+ booksToRead + "]";
	}//end toString
	
}
