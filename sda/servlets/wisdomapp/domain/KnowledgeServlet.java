import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/knowledge")
public class KnowledgeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user= (User) req.getAttribute(Constants.CURRENT_USER);
        List<KnowledgeSource> knowledge= user.getKnowledge();
        StringBuilder sb = new StringBuilder();
        sb.append("<div>\n");
        sb.append("<h2>Wiedza (Użytkownik ")
                .append(user.getLogin())
                .append(")</h2> (<a href=\"/wapp/user\">Powrót</a>)\n");
        sb.append("<div><br/><a href=\"/wapp/user/knowledge/add\">Dodaj nowe źródło</a>")
                .append("</br></div>\n");
        String msg= req.getParameter(Constants.INNER_MESSAGE);
        if(msg!= null) {
            sb.append("<div><p style=\"color: red\">")
                    .append(msg).append("<p></div>\n");
        }
        sb.append("<ol>\n");
        for (KnowledgeSource source: knowledge) {
            sb.append("<ul><p><b>")
                    .append(source.getName())
                    .append("</b>")
                    .append("<form action=\"/wapp/user/knowledge/remove\"method=\"post\">")
                    .append("<input type=\"hidden\"value=\"")
                    .append(source.getName())
                    .append("\"name=\"sourceName\"/>")
                    .append("<input type=\"submit\"value=\"Usuń\"/></form>")
                    .append("<li>Autor: ")
                    .append(source.getAuthor())
                    .append("</li>\n").append("<li>Typ: ")
                    .append(source.getType().getDesc())
                    .append("</li>\n").append("<li>Słowa kluczowe: ")
                    .append(source.getKeywords().stream().reduce((s, s2) -> s.concat(", ").concat(s2)).orElse                             (""))
                    .append("</li>\n")
                    .append("<li>Technologie: "
                    ).append(source.getTechnologies()
                    .stream().reduce((s,s2) -> s.concat(", ").concat(s2)).orElse(""))
                    .append("</li>\n").append("</p></ul>\n");
        }
        sb.append("</ol>\n");
        sb.append("</div>");
        resp.getWriter().println(sb.toString());
    }
}
