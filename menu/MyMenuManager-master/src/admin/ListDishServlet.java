package admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Dish;
import rmi.ClientRMI;

/**
 * Servlet implementation class ListDishServlet
 */
@WebServlet("/admin/dish")
public class ListDishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListDishServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		List<Dish> dishes = ClientRMI.getServer().getDishes();
		request.setAttribute("dishes", dishes);
		
		this.getServletContext().getRequestDispatcher( "/pages/dish/index.jsp" ).forward( request, response );
	}

}
