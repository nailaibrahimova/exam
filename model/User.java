package exam.model;

public class User {
    private int id;
    private String login;
    private long password;
    private static int nextId = 0;

    public User() {
        id = getNextId();
    }

    public User(String login, String password) {
        id = getNextId();
        this.login = login;
        this.password = password.hashCode();
    }

    public int getId() {
        return id;
    }

    public static int getNextId() {
        nextId++;
        return nextId;
    }

    public String getLogin() {
        return login;
    }

    public User setLogin(String login) {
        this.login = login;
        return this;
    }

    public long getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password.hashCode();
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password=" + password +
                '}';
    }

}
