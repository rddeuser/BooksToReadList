package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import model.Reader;
import model.ReadingDetails;

/**
 * Servlet implementation class ListNavigationServlet
 */
@WebServlet("/ListNavigationServlet")
public class ListNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListNavigationServlet() {
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
		ReadingDetailsHelper helper = new ReadingDetailsHelper();
		String act = request.getParameter("doThisToList");
		
		String path = "/ViewAllListsServlet";
		
		if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ReadingDetails toDelete = helper.searchForListDetails(tempId);
				helper.deleteList(toDelete);
			} catch (Exception e) {
				System.out.println("Forgot to select an item");
			}
		}
		else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ReadingDetails toEdit = helper.searchForListDetails(tempId);
				
				request.setAttribute("toEdit", toEdit);
				
				BookHelper bh = new BookHelper();
				request.setAttribute("allItems", bh.showAllBooks());
				
				if (bh.showAllBooks().isEmpty()) {
					request.setAttribute("allItems", " ");
				}//end if
			
				path = "/edit-list.jsp";
			} catch (Exception e) {
				System.out.println("Forgot to select an item");
			}
		}
		else if (act.equals("add")) {
			path = "/new-list.jsp";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
