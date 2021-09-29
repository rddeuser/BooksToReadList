package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/NavigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookHelper helper = new BookHelper();
		String act = request.getParameter("doThisToItem");
		
		String path = "/ViewAllItemsServlet";
		
		if (act.equals("delete")) {
			try {
				String title = request.getParameter("title");
				Book toDelete = helper.findBook(title);
				helper.removeBook(toDelete);
			} catch (Exception e) {
				System.out.println("Forgot to select an item");
			}
		}
		else if (act.equals("edit")) {
			try {
				String title = request.getParameter("title");
				Book itemToEdit = new Book(title);
				request.setAttribute("itemToEdit", itemToEdit);
				path = "/edit-item.jsp";
			} catch (Exception e) {
				System.out.println("Forgot to select an item");
			}
		}
		else if (act.equals("add")) {
			path = "/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
