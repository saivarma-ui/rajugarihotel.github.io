package admin;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.Dish;
import bean.DishGroup;
import form.DishGroupForm;
import rmi.ClientRMI;

/**
 * Servlet implementation class ManageGroupServlet
 */
@WebServlet("/admin/group/manage")
public class ManageGroupServlet extends HttpServlet {

    private static final long serialVersionUID = 6123360496379607072L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<DishGroup> groups = ClientRMI.getServer().getGroups();
		List<Dish> dishes = ClientRMI.getServer().getDishes();
		Iterator<Dish> it = dishes.iterator();
		while(it.hasNext()) { // Remove grouped dishes
		    if(it.next().getGroupId() != null)
		        it.remove();
		}
		
		DishGroupForm newGroupForm = new DishGroupForm(new DishGroup()); 
		
		request.setAttribute("groups", groups);
		request.setAttribute("dishes", dishes);
		request.setAttribute("newForm", newGroupForm);
		request.getServletContext().getRequestDispatcher("/pages/group/index.jsp").forward(request, response);
	}

}
