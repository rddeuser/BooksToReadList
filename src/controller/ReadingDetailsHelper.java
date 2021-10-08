/**
 * @author Becca Deuser - rddeuser
 * CIS175 - Fall 2021
 * Oct 7, 2021
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Book;
import model.ReadingDetails;

/**
 * @author bdeus
 *
 */
public class ReadingDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BooksToReadList");

	public void insertNewReadingDetails(ReadingDetails d) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ReadingDetails> getLists() {
		EntityManager em = emfactory.createEntityManager();
		List<ReadingDetails> allDetails = em.createQuery("SELECT d FROM ReadingDetails d").getResultList();
		return allDetails;
	}
	
	public ReadingDetails searchForListDetails(int id) {
		//create entity manager
		EntityManager em = emfactory.createEntityManager();
		
		//find book with correct title
		em.getTransaction().begin();
		ReadingDetails foundReading = em.find(ReadingDetails.class, id);
		em.close();
		return foundReading;
	}//end search
	
	public ReadingDetails findReadingDetails(String listName) {
		//create entity manager
		EntityManager em = emfactory.createEntityManager();
		
		//find book with correct title
		em.getTransaction().begin();
		TypedQuery<ReadingDetails> typedQuery = em.createQuery("select rd from ReadingDetails rd where rd.listName = :selectedListName", ReadingDetails.class);
		typedQuery.setParameter("selectedListName", listName);
		
		//ensure only one result
		typedQuery.setMaxResults(1);
		
		//create readingDetails object
		ReadingDetails foundrd = typedQuery.getSingleResult();
		
		//close entity manager and return book
		em.close();
		return foundrd;
	}//end findReadingDetails
	
	public void deleteList(ReadingDetails toRemove) {
		//create entity manager
		EntityManager em = emfactory.createEntityManager();
		
		//create query to remove item
		em.getTransaction().begin();
		TypedQuery<ReadingDetails> typedQuery = em.createQuery("select d from ReadingDetails d where d.listName = :selectedName and d.reader = :selectedReader", ReadingDetails.class);
		
		//Substitute parameter with actual data from the toRemove item
		typedQuery.setParameter("selectedName", toRemove.getListName());
		typedQuery.setParameter("selectedReader", toRemove.getReader());
		
		//get only one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new reading details
		ReadingDetails result = typedQuery.getSingleResult();
		
		//remove the reading details
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}//end deleteList
	
	public void updateList(ReadingDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}//end updateList
}
