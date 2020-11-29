package admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.Dish;
import rmi.ClientRMI;
import rmi.ServerRMI;

/**
 * Servlet implementation class AssignDishToGroupServlet
 */
@WebServlet("/admin/group/unassign")
public class UnassignServlet extends HttpServlet {

    private static final long serialVersionUID = -8057806286184649420L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int dishId = Integer.parseInt(request.getParameter("dish"));
        System.out.println("UnassignServlet.doPost() > "+dishId);
        ServerRMI server = ClientRMI.getServer();
        Dish dish = server.getDish(dishId);
        
        if(dish == null) { // 404
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
            
        /* Save changes */
        dish.setGroupId(null);
        server.editDish(dish);
        
        // empty 200 response
	}

}
