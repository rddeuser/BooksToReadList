/**
 * @author Becca Deuser - rddeuser
 * CIS175 - Fall 2021
 * Oct 7, 2021
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author bdeus
 *
 */
@Entity
@Table(name="reader")
public class Reader {
	@Id
	@GeneratedValue
	private int id;
	private String readerName;

	public Reader() {
		super();
	}

	public Reader(int id, String readerName) {
		super();
		this.id = id;
		this.readerName = readerName;
	}

	public Reader(String readerName) {
		super();
		this.readerName = readerName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReaderName() {
		return readerName;
	}
	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}
	@Override
	public String toString() {
		return "Shopper [id=" + id + ", readerName=" +
				readerName + "]";
	}
}
