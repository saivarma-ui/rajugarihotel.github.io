package admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.Dish;
import rmi.ClientRMI;

/**
 * Servlet implementation class ImageServlet
 */
@WebServlet("/admin/image/get")
public class GetImageServlet extends HttpServlet {

    private static final long serialVersionUID = 681388994758625270L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int dishId = Integer.parseInt(request.getParameter("id"));
        Dish dish = ClientRMI.getServer().getDish(dishId);
        if (dish == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        
        byte[] image = ClientRMI.getServer().getImage(dish);
        
        response.setContentType("image/png");
        OutputStream output = response.getOutputStream();
        output.write(image);
        output.close();
    }
}
