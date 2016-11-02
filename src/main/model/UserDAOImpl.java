package main.model;

import java.util.Collection;

public class UserDAOImpl extends AbstractDAOImpl<User> {

    private static Collection<User> users;

    private static UserDAOImpl singletonInstance;

    private UserDAOImpl(){

    }

    public static void initialize(Collection<User> collection){
        if (singletonInstance == null) {
            singletonInstance = new UserDAOImpl();
            users = collection;
        }
    }

    public static UserDAOImpl getInstance(){
        return singletonInstance;
    }

    public Collection<User> getUsers() {
        return users;
    }
}
