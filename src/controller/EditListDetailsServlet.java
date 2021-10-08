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
 * Servlet implementation class EditListDetailsServlet
 */
@WebServlet("/EditListDetailsServlet")
public class EditListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditListDetailsServlet() {
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
		ReadingDetailsHelper rdh = new ReadingDetailsHelper();
		BookHelper bh = new BookHelper();
		ReaderHelper rh = new ReaderHelper();
		
		String newListName = request.getParameter("listName");
		String readerName = request.getParameter("readerName");
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ReadingDetails toUpdate = rdh.searchForListDetails(tempId);
		
		Reader newReader = rh.findReader(readerName);
		
		try {
			String[] selectedItems = request.getParameterValues("allItemsToAdd");
			List<Book> selectedItemsInList = new ArrayList<Book>();
			
			for (int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				Book b = bh.findBook(selectedItems[i]);
				selectedItemsInList.add(b);
			}//end for
			
			toUpdate.setBooksToRead(selectedItemsInList);
		} catch (NullPointerException ex) {
			List<Book> selectedItemsInList = new ArrayList<Book>();
			toUpdate.setBooksToRead(selectedItemsInList);
		}
		
		toUpdate.setListName(newListName);
		toUpdate.setReader(newReader);
		
		rdh.updateList(toUpdate);
		
		getServletContext().getRequestDispatcher("/ViewAllListsServlet").forward(request, response);
	}

}
