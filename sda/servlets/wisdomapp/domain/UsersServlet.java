import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users")
public class UsersServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getAttribute(Constants.CURRENT_USER);
        if (user != null) {
            getServletContext().log("Użytkownik dostępny w żądaniu: " + user);
        }
        resp.sendRedirect(req.getContextPath() + "/user");
    }
}
