
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class    KnowledgeSource {

    private String name;
    private String author;
    private SourceType type;
    private Set<String> keywords;
    private Set<String> technologies;

    public KnowledgeSource() {
        this.keywords = new TreeSet<>();
        this.technologies = new TreeSet();
    }

    public KnowledgeSource(String name, String author, SourceType type) {
        this.name = name;
        this.author = author;
        this.type = type;
        this.keywords = new TreeSet<>();
        this.technologies = new TreeSet();
    }

    @Override
    public String toString() {
        return "KnowledgeSource{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KnowledgeSource that = (KnowledgeSource) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(author, that.author) &&
                type == that.type;
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, author, type);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public SourceType getType() {
        return type;
    }

    public void setType(SourceType type) {
        this.type = type;
    }

    public Set<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(Set<String> keywords) {
        this.keywords = keywords;
    }

    public Set<String> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(Set<String> technologies) {
        this.technologies = technologies;
    }

    public enum SourceType {

        BOOK("Książka"),
        COURSE("Kurs"),
        WEB_MATERIAL("Strona www");

        private String desc;

        private SourceType(String desc) {
            this.desc = desc;
        }

        public String getDesc() {
            return this.desc;
        }
    }
}
