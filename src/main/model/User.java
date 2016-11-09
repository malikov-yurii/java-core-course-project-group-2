package main.model;

public class User extends NamedEntity {

    private String password;

    public User(String name, String password) {
        super(name);
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "Name='" + getName() + '\'' +
                ", id='" + getId() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return password.equals(user.password) && getName().equals(user.getName());
    }

    @Override
    public int hashCode() {
        int result = password.hashCode();
        result = 31 * result + getName().hashCode();
        return result;
    }
}
