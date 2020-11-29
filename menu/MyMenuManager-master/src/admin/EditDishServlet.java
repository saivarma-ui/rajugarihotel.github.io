package admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import bean.Dish;
import form.DishForm;
import rmi.ClientRMI;

/**
 * Servlet implementation class EditDishServlet
 */
@WebServlet("/admin/dish/edit")
public class EditDishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

	    Dish dish = this.getDish(request, response);
	    if(dish == null) {
	        return;
	    }
	    request.setAttribute("dish", dish);
	            
        if (request.getAttribute("form") == null) {
            DishForm form = new DishForm(dish);
            request.setAttribute("form", form);
        }
        
        this.getServletContext().getRequestDispatcher("/pages/dish/edit.jsp").forward(request,
                response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Dish dish = this.getDish(request, response);
        if(dish == null)
            return;
        
        DishForm form = this.createForm(request, dish);
        form.handleRequest(request);

        if (form.isValid()) {
            dish = form.getData();
            ClientRMI.getServer().editDish(dish);
            request.setAttribute("formSuccess", "Dish successfully updated !");
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
    
    private DishForm createForm(HttpServletRequest request, Dish dish) {
        DishForm form = new DishForm(dish);
        request.setAttribute("form", form);
        return form;
    }
}
