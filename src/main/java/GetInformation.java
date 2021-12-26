import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Negin Mousavi
 */
public class GetInformation extends HttpServlet {

    UserService userService = new UserService();

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String family = request.getParameter("family");
        String age = request.getParameter("age");
        String gender = request.getParameter("gender");
        String pass = request.getParameter("pass");

        int result = userService.saveUser(name, family, age, gender, pass);
        if (result == 1) {
            out.println("<br>Record has been inserted");
        } else {
            out.println("failed to insert the data");
        }
    }
}
