package admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import bean.DishGroup;
import rmi.ClientRMI;
import rmi.ServerRMI;

/**
 * Servlet implementation class CreateGroupServlet
 */
@WebServlet("/admin/group/create")
public class CreateGroupServlet extends HttpServlet {
	
    private static final long serialVersionUID = 1640553046647393610L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DishGroup group = new DishGroup();
		group.setName(request.getParameter("name"));
		
		response.setContentType("text/json");
		
		final GsonBuilder builder = new GsonBuilder();
		final Gson gson = builder.create();
		final ServerRMI server = ClientRMI.getServer();
		if(server.createGroup(group) == true) {
		    group = server.getGroup(group.getName());
		    response.getWriter().append(gson.toJson(group));
		    return;
		}
		
		response.setStatus(HttpServletResponse.SC_PRECONDITION_FAILED);
		response.getWriter().append("Invalid name.");
	}

}
