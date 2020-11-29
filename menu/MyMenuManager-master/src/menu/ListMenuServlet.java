package menu;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Dish;
import bean.DishGroup;
import rmi.ClientRMI;

/**
 * Servlet implementation class ListDishServlet
 */
@WebServlet("/menu")
public class ListMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListMenuServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<DishGroup> groups = ClientRMI.getServer().getGroups();
		List<Dish> dishes = ClientRMI.getServer().getUngroupedDishes();

		request.setAttribute("dish_groups", groups);
		request.setAttribute("dishes", dishes);


		this.getServletContext().getRequestDispatcher( "/pages/menu/menu.jsp" ).forward( request, response );
	}
}



