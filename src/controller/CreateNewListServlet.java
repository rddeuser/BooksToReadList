package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Book;
import model.Reader;
import model.ReadingDetails;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/CreateNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookHelper bh = new BookHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: " + listName);
		
		String readerName = request.getParameter("readerName");
		
		String[] selectedItems = request.getParameterValues("allItemsToAdd");
		List<Book> selectedItemsInList = new ArrayList<Book>();
		
		if(selectedItems != null && selectedItems.length > 0) {
			for (int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				Book b = bh.findBook(selectedItems[i]);
				selectedItemsInList.add(b);
			}//end for
		}//end if
		
		Reader reader = new Reader(readerName);
		ReadingDetails rd = new ReadingDetails(listName, reader);
		rd.setBooksToRead(selectedItemsInList);
		ReadingDetailsHelper rdh = new ReadingDetailsHelper();
		rdh.insertNewReadingDetails(rd);
		
		System.out.println("Success!");
		System.out.println(rd.toString());
		
		getServletContext().getRequestDispatcher("/ViewAllListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
