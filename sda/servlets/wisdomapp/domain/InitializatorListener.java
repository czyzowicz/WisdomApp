import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.*;


@WebListener
public class InitializatorListener implements ServletContextListener{


    private Map<String, User> users() {
        Map<String, User> users= new HashMap<>();
        users.put("jnowak", new User(1L, "jnowak","Jan","Nowak",30));
        users.put("kmarkowska", new User(2L,"kmarkowska","Katarzyna","Markowska",27));
        users.put("jkulig", new User(3L,"jkulig","Jacek","Kulig",45));
        return users;
    }
            private Set<String> keywords() {
            return new TreeSet<>(Arrays.asList(("package,import,class,interface,enum,public," +
                "protected,private,static,boolean,byte,char,short,int,long,float,double," +
                "final,transient,volatile,synchronized,synchronize,throws,throw,new," +"void")
                .split(",")));
        }
            private Set<String> technologies() {
            return new TreeSet<>(Arrays.asList(("Typy podstawowe,Struktura programu," +
                "Typy referencyjne,Liczby,Tekst,Strumienie,Tablice,Wyrażenia warunkowe," +
                "Pętle,Rekurencja,Wielowątkowość,Adnotacje,Interfejsy,Klasy,Obiekty," +
                "Dziedziczenie,Typy wyliczeniowe,Kolekcje,Wyrażenia lamba")
                .split(",")));
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute(Constants.ALL_USERS, users());
        sce.getServletContext().setAttribute(Constants.KEYWORDS, keywords());
        sce.getServletContext().setAttribute(Constants.TECHNOLOGIES, technologies());
    }
}
