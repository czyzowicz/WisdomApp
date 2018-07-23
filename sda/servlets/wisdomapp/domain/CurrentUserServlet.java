import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class CurrentUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user= (User) req.getAttribute(Constants.CURRENT_USER);
        StringBuilder sb = new StringBuilder();
        sb.append("<div>\n");
        sb.append("<spanstyle=\"text-size: 10px\"><a href=\"/wapp/logout\">Wyloguj</a></span>")
                .append("<h2>Użytkownik(ID:")
                .append(user.getID())
                .append(")</h2>\n")
                .append("<ul>");
        sb.append("<div>\n");
        sb.append("<h2>Użytkownik (ID:")
                .append(user.getID()).append(")</h2>\n")
                .append("<ul>").append("<li><h4>Login: ")
                .append(user.getLogin()).append("</h4></li>\n")
                .append("<li><h4>Imię: ")
                .append(user.getFirstName())
                .append("</h4></li>\n")
                .append("<li><h4>Nazwisko: ")
                .append(user.getLastName())
                .append("</h4></li>\n")
                .append("<li><h4>Wiek: ")
                .append(user.getAge())
                .append("</h4></li>\n")
                .append("<li><h4><a href=\"/wapp/user/knowledge\">Zarządzanie wiedzą</a>")
                .append("</h4></li>")
                .append("<li><h4>Podsumowanie wiedzy:</h4><br/>\n");
        sb.append("</li>\n");
        sb.append("</ul>\n");
        sb.append("</div>\n");
        resp.getWriter().println(sb.toString());
    }
}
