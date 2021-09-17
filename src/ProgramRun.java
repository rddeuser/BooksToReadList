import java.util.List;
import java.util.Scanner;

import controller.BookHelper;
import model.Book;

/**
 * @author Becca Deuser - rddeuser
 * CIS175 - Fall 2021
 * Sep 16, 2021
 */

public class ProgramRun {
	//add scanner and Book helper objects
	static Scanner input = new Scanner(System.in);
	static BookHelper bh = new BookHelper();
	
	//method to add book to list
	private static void insertBook() {
		//get input from user
		System.out.print("Enter the title of the book: ");
		String title = input.nextLine();
		
		System.out.print("Enter the author of the book: ");
		String author = input.nextLine();
		
		System.out.print("Enter how excited you are to read the book(1-10): ");
		int excitementRating = input.nextInt();
		
		//create book object and add object to table
		Book toInsert = new Book(title, author, excitementRating);
		bh.addBook(toInsert);
	}//end insertBook
	
	//method to view the books in the list
	private static void viewBookList() {
		//create a list of books
		List<Book> allBooks = bh.showAllBooks();
		
		//print the list of books one at a time
		for (Book singleBook: allBooks) {
			System.out.println(singleBook.returnItemAttributes());
		}//end for
	}//end viewBookList

	//method to delete a book
	private static void deleteBook() {
		//get input from user
		System.out.print("Enter the title of the book: ");
		String title = input.nextLine();
		
		System.out.print("Enter the author of the book: ");
		String author = input.nextLine();
		
		//create book object and add object to table
		Book toDelete = new Book(title, author);
		bh.removeBook(toDelete);
	}//end deleteBook

	//method to edit a book in the list
	private static void editBook() {
		//create book object
		Book toEdit = new Book();
		
		//get title from user
		System.out.print("Enter the title of the book you'd like to edit: ");
		String title = input.nextLine();
		
		//find book with correct title and return result
		toEdit = bh.findBook(title);
		System.out.println("Retrieved " + toEdit.returnItemAttributes());
				
		//ask user what they'd like to update
		System.out.println("1 : Update Title");
		System.out.println("2 : Update Author");
		System.out.println("3 : Update Excitement Rating");
		int update = input.nextInt();
		input.nextLine();

		//edit corresponding attribute
		if (update == 1) {
			System.out.print("New Title: ");
			String newTitle = input.nextLine();
			toEdit.setTitle(newTitle);
		}//end if
		else if (update == 2) {
			System.out.print("New Author: ");
			String newAuthor = input.nextLine();
			toEdit.setAuthor(newAuthor);
		}//end else if
		else {
			System.out.print("New Excitement Rating: ");
			int newExcitement = input.nextInt();
			toEdit.setExcitementRating(newExcitement);
		}//end else
		
		//update book
		bh.updateBook(toEdit);
	}//end editBook
	
	public static void main(String[] args) {
		//declare variables
		boolean repeat = true;
		
		//introduce the program
		System.out.println("~~~~~ Welcome to the Books to Read List! ~~~~~");
				
		while (repeat) {
			//display menu of options
			System.out.println("~~   Select your desired action   ~~");
			System.out.println("~ 1 ~  Add a book to the list      ~");
			System.out.println("~ 2 ~  Edit a book in the list     ~");
			System.out.println("~ 3 ~  Remove a book from the list ~");
			System.out.println("~ 4 ~  View the book list          ~");
			System.out.println("~ 5 ~  Leave the list program      ~");
			
			//get input from user
			System.out.print("~~   Your selection: ");
			int selection = input.nextInt();
			input.nextLine();

			switch(selection) {
			case 1:
				insertBook();
			break;
			case 2:
				editBook();
			break;
			case 3:
				deleteBook();
			break;
			case 4:
				viewBookList();
			break;
			default:
				bh.cleanUp();
				System.out.println("~~ Thanks, come again! ~~");
				repeat = false;
			break;
			}//end switch
			
		}//end while
		
	}//end main
	
}//end ProgramRun
