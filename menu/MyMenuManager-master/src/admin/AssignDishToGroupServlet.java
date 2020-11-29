package admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.Dish;
import bean.DishGroup;
import rmi.ClientRMI;
import rmi.ServerRMI;

/**
 * Servlet implementation class AssignDishToGroupServlet
 */
@WebServlet("/admin/group/assign")
public class AssignDishToGroupServlet extends HttpServlet {

    private static final long serialVersionUID = 5942760573265467374L;

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int groupId = Integer.parseInt(request.getParameter("group"));
        int dishId = Integer.parseInt(request.getParameter("dish"));
        
        System.out.printf("group : %d\tdish : %d\n", groupId, dishId);

        ServerRMI server = ClientRMI.getServer();
        DishGroup group = server.getGroup(groupId);
        Dish dish = server.getDish(dishId);
        
        if(group == null || dish == null) { // 404
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
            
        /* Save changes */
        group.addDish(dish);
        server.editGroup(group);
        
        // empty 200 response
	}

}
