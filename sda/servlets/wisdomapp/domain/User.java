
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class User {

    private Long ID;
    private String login;
    private String firstName;
    private String lastName;
    private int age;

    private List<KnowledgeSource> knowledge;

    public User() {
        ;
    }

    public User(Long ID, String login, String firstName, String lastName, int age) {
        this.ID = ID;
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.knowledge = new LinkedList<>();
    }

    public User(String login, String firstName, String lastName, int age) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(ID, user.ID) &&
                Objects.equals(login, user.login) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ID, login, firstName, lastName);
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<KnowledgeSource> getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(List<KnowledgeSource> knowledge) {
        this.knowledge = knowledge;
    }
}
