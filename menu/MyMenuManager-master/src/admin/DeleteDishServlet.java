package admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.Dish;
import form.SimpleForm;
import rmi.ClientRMI;

/**
 * Servlet implementation class DeleteDishServlet
 */
@WebServlet("/admin/dish/delete")
public class DeleteDishServlet extends HttpServlet {

    private static final long serialVersionUID = -1251923677208844438L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    Dish dish = this.getDish(request, response);
	    if(dish == null){
	        return;
	    }
	    
	    SimpleForm form = new SimpleForm();
	    request.setAttribute("form", form);
	    request.setAttribute("dish", dish);
		request.getServletContext().getRequestDispatcher("/pages/dish/delete.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    Dish dish = this.getDish(request, response);
        if(dish == null){
            return;
        }
        
	    SimpleForm form = new SimpleForm();
	    form.handleRequest(request);
        
	    if(form.isSubmitted() && form.isValid()) {
	        if(ClientRMI.getServer().deleteDish(dish)){
	            response.sendRedirect(request.getContextPath()+"/admin/dish");
	            return;
	        }
	        request.setAttribute("formError", "An unknown error occured. Please retry later.");
	    }
		doGet(request, response);
	}
	
	private Dish getDish(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Dish dish = null;
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            dish = ClientRMI.getServer().getDish(id);
            if(dish == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        } catch(NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        
        return dish;
    }

}
