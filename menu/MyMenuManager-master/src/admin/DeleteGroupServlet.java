package admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.DishGroup;
import form.SimpleForm;
import rmi.ClientRMI;

/**
 * Servlet implementation class DeleteDishServlet
 */
@WebServlet("/admin/group/delete")
public class DeleteGroupServlet extends HttpServlet {

    private static final long serialVersionUID = -1251923677208844438L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    DishGroup dish = this.getDishGroup(request, response);
	    if(dish == null){
	        return;
	    }
	    
	    SimpleForm form = new SimpleForm();
	    request.setAttribute("form", form);
	    request.setAttribute("group", dish);
		request.getServletContext().getRequestDispatcher("/pages/group/delete.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    DishGroup dish = this.getDishGroup(request, response);
        if(dish == null){
            return;
        }
        
	    SimpleForm form = new SimpleForm();
	    form.handleRequest(request);
        
	    if(form.isSubmitted() && form.isValid()) {
	        if(ClientRMI.getServer().deleteGroup(dish)){
	            response.sendRedirect(request.getContextPath()+"/admin/group/manage");
	            return;
	        }
	        request.setAttribute("formError", "An unknown error occured. Please retry later.");
	    }
		doGet(request, response);
	}
	
	private DishGroup getDishGroup(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DishGroup dish = null;
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            dish = ClientRMI.getServer().getGroup(id);
            if(dish == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        } catch(NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        
        return dish;
    }

}
