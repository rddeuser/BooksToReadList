/**
 * @author Becca Deuser - rddeuser
 * CIS175 - Fall 2021
 * Oct 7, 2021
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Reader;

/**
 * @author bdeus
 *
 */
public class ReaderHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BooksToReadList");

	public void insertShopper(Reader r) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Reader> showAllReaders() {
		EntityManager em = emfactory.createEntityManager();
		List<Reader> allReaders = em.createQuery("SELECT r FROM Reader r").getResultList();
		return allReaders;
	}
	
	public Reader findReader(String nameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Reader> typedQuery = em.createQuery("select r from Reader r where r.readerName = :selectedName", Reader.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		
		Reader foundReader;
		try {
			foundReader = typedQuery.getSingleResult();
		} catch(NoResultException ex) {
			foundReader = new Reader(nameToLookUp);
		}
		em.close();
		
		return foundReader;
	}
}
