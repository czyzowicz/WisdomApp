import javax.jws.soap.SOAPBinding;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserKnowledgeFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        User user = (User) req.getAttribute(Constants.CURRENT_USER);
        req.setAttribute(Constants.USER_KNOWLEDGE, user.getKnowledge());
        chain.doFilter(req,res);
    }
}
