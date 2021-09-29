package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;

/**
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/AddItemServlet")
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//declare variables
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		int excitement = Integer.parseInt(request.getParameter("excitement"));
		
		//create and add book
		Book toAdd = new Book(title, author, excitement);
		BookHelper helper = new BookHelper();
		helper.addBook(toAdd);
		
		//refresh index page
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
