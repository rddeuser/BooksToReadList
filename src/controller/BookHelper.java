/**
 * @author Becca Deuser - rddeuser
 * CIS175 - Fall 2021
 * Sep 16, 2021
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Book;

public class BookHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BooksToReadList");
	
	public void addBook(Book toInsert) {
		//create entity manager
		EntityManager em = emfactory.createEntityManager();
		
		//add book and commit changes
		em.getTransaction().begin();
		em.persist(toInsert);
		em.getTransaction().commit();
		
		//close entity manager
		em.close();
	}//end addBook

	public List<Book> showAllBooks() {
		//create entity manager
		EntityManager em = emfactory.createEntityManager();
		
		//create query for list of books
		List<Book> allItems = em.createQuery("SELECT i FROM Book i").getResultList();
		return allItems;
	}//end showAllBooks
	
	public void removeBook(Book toRemove) {
		//create entity manager
		EntityManager em = emfactory.createEntityManager();
		
		//create query to remove item
		em.getTransaction().begin();
		TypedQuery<Book> typedQuery = em.createQuery("select b from Book b where b.title = :selectedTitle and b.author = :selectedAuthor", Book.class);
		
		//Substitute parameter with actual data from the toRemove item
		typedQuery.setParameter("selectedTitle", toRemove.getTitle());
		typedQuery.setParameter("selectedAuthor", toRemove.getAuthor());
		
		//get only one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new book
		Book result = typedQuery.getSingleResult();
		
		//remove the book
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}//end removeBook
	
	public void updateBook(Book toEdit) {
		//create entity manager
		EntityManager em = emfactory.createEntityManager();
		
		//update book and commit changes
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		
		//close entity manager
		em.close();
	}//end updateBook

	public Book findBook(String title) {
		//create entity manager
		EntityManager em = emfactory.createEntityManager();
		
		//find book with correct title
		em.getTransaction().begin();
		TypedQuery<Book> typedQuery = em.createQuery("select b from Book b where b.title = :selectedTitle", Book.class);
		typedQuery.setParameter("selectedTitle", title);
		
		//ensure only one result
		typedQuery.setMaxResults(1);
		
		//create book
		Book foundBook = typedQuery.getSingleResult();
		
		//close entity manager and return book
		em.close();
		return foundBook;
	}//end findBook
	
	public void cleanUp(){
		emfactory.close();
	}//end cleanUp
	
}//end BookHelper
