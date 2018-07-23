import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@WebServlet("/user/knowledge/add")
public class AddKnowledgeSourceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder form = new StringBuilder();
        form.append("<div><a href=\"/wapp/user/knowledge\">Powrót</a></div>\n");
        form.append("<div><form action=\"/wapp/user/knowledge/add\"method=\"post\">")
                .append("<p><h3>Dodaj źródło wiedzy</h3></p>\n")
                .append("<p>Nazwa: <input type=\"text\"name=\"Name\"required/></p>\n")
                .append("<p>Autor: <input type=\"text\"name=\"Author\"/></p>\n");
        // Wybór typu
        form.append("<div>Typ: <select name=\"Type\">\n");
        for (KnowledgeSource.SourceType type: KnowledgeSource.SourceType.values()) {
            form.append("<p><option value=\"")
                    .append(type.name())
                    .append("\">")
                    .append(type.getDesc())
                    .append("</option></p>\n");
        }
        form.append("</select></div>\n");
        // Wybór słów kluczowych
         form.append("<div>Słowa kluczowe: <br/><select name=\"Keywords\"")
                 .append("multiple=\"multiple\"size=\"10\">\n");
         for (String keyword: ((Set<String>) getServletContext().getAttribute(Constants.KEYWORDS))) {
             form.append("<option value=\"")
                     .append(keyword).append("\">")
                     .append(keyword).append("</option>\n");
         }
         form.append("</select></div>\n");
         // Wybór technologii
         form.append("<div>Technologie: <br/><select name=\"Technologies\"")
                 .append("multiple=\"multiple\"size=\"5\">\n");
         for (String technology: ((Set<String>) getServletContext().getAttribute(Constants.TECHNOLOGIES))) {
             form.append("<option value=\"")
                     .append(technology)
                     .append("\">")
                     .append(technology)
                     .append("</option>\n");
         }
         form.append("</select></div>\n");
         // Przyciski do wyczyszczenia i wysłania formularza
        form.append("<p><input type=\"reset\"value=\"Wyczyść\"/></p>\n")
                .append("<p><input type=\"submit\"value=\"Dodaj\"/></p>\n")
                .append("</form></div>");
        resp.getWriter().println(form.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<KnowledgeSource> knowledge = (List<KnowledgeSource>) req.getAttribute(Constants.USER_KNOWLEDGE);
        String type = req.getParameter("Type");
        String name = req.getParameter("Name");
        String author = req.getParameter("Author");
        KnowledgeSource newSource = new KnowledgeSource(name, author, KnowledgeSource.SourceType.valueOf(type));
        String[] keywords = req.getParameterValues("Keywords");
        String[] technologies = req.getParameterValues("Technologies");
        if (keywords != null && keywords.length > 0) {
            newSource.getKeywords().addAll(Arrays.asList(keywords));
        }
        if (technologies != null && technologies.length > 0) {
            newSource.getTechnologies().addAll(Arrays.asList(technologies));
        }
        knowledge.add(newSource);
        resp.getWriter().println("<div><p>Dodano</p></div>");
        resp.getWriter().println("<div><a href=\"/wapp/user/knowledge\">Powrót</a></div>");
    }
}
