package security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.User;
import form.LoginForm;
import rmi.ClientRMI;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 7990443044881091384L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            redirectToHome(response);
            return;
        }

        if (request.getAttribute("form") == null) {
            LoginForm loginForm = new LoginForm();
            request.setAttribute("form", loginForm);
        }
        this.getServletContext().getRequestDispatcher("/pages/security/login.jsp").forward(request,
                response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LoginForm form = new LoginForm();
        request.setAttribute("form", form);
        form.handleRequest(request);

        if (form.isValid()) {
            User user = ClientRMI.getServer().getUser((String) form.value("username"),
                    (String) form.value("password"));
            if(user != null) {
                request.getSession().setAttribute("user", user);
                redirectToHome(response);
                return;
            }
        }

        /* Invalid user */
        request.setAttribute("formError", "Bad credentials.");
        doGet(request, response);
    }

    private void redirectToHome(HttpServletResponse response) throws IOException {
        response.sendRedirect(this.getServletContext().getContextPath());
    }

}
