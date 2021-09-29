package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;

/**
 * Servlet implementation class EditItemServlet
 */
@WebServlet("/EditItemServlet")
public class EditItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookHelper helper = new BookHelper();
		
		String nTitle = request.getParameter("newTitle");
		String author = request.getParameter("author");
		int excitement = Integer.parseInt(request.getParameter("excitement"));
		
		String title = request.getParameter("title");
		Book toUpdate = helper.findBook(title);
		
		toUpdate.setTitle(nTitle);
		toUpdate.setAuthor(author);
		toUpdate.setExcitementRating(excitement);
		
		helper.updateBook(toUpdate);
		
		getServletContext().getRequestDispatcher("/ViewAllItemsServlet").forward(request, response);
	}

}
