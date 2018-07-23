import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.Map;


public class UserCredentialsFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res,
                            FilterChain chain) throws IOException, ServletException {
        Principal userPrincipal = req.getUserPrincipal();
        if (userPrincipal != null) {
            String userName = userPrincipal.getName();
            User user = ((Map<String, User>) getServletContext()
                    .getAttribute(Constants.ALL_USERS)).get(userName);
            if (user == null) {
                res.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                        "Nie istnieje użytkownik o loginie " + userName);
                return;
            }
            req.setAttribute(Constants.CURRENT_USER, user);
            getServletContext().log("Dodano użytkownika " + userName + " do żądania");

        }
        else {
            getServletContext().log("Nie ma użytkownika");
        }
        chain.doFilter(req, res);
    }
}