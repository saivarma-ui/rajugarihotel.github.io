package admin;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import bean.Dish;
import rmi.ClientRMI;

/**
 * Servlet implementation class ImageServlet
 */
@WebServlet("/admin/image")
@MultipartConfig(location = "/tmp", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024
        * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class ImageServlet extends HttpServlet {

    private static final long serialVersionUID = 681388994758625270L;

    /**
     * Upload an image
     * 
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int dishId = Integer.parseInt(request.getParameter("id"));
        Dish dish = ClientRMI.getServer().getDish(dishId);
        if (dish == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        final Part filePart = request.getPart("file");
        byte[] image = null;

        try {
            InputStream filecontent = filePart.getInputStream();
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            final byte[] bytes = new byte[1024];

            while (filecontent.read(bytes) != -1) {
                os.write(bytes);
            }

            image = os.toByteArray();
            
            filecontent.close();
            os.close();
        } catch (FileNotFoundException fne) {
            System.out.println("ERROR: " + fne.getMessage());
        }

        if (ClientRMI.getServer().editDishImage(dish, image)) {
            System.out.println("ImageServlet.doPost() : Image saved.");
        } else {
            System.out.println("ImageServlet.doPost() : Erreur");
        }
    }

}
