package main.dao;

import main.model.User;

import java.util.Collection;

public class UserDAOImpl extends AbstractDAOImpl<User> {

    private static UserDAOImpl singletonInstance;

    private UserDAOImpl(){

    }

    public static void initialize(Collection<User> collection){
        if (singletonInstance == null) {
            singletonInstance = new UserDAOImpl();
            singletonInstance.setCollection(collection);
        }
    }

    public static UserDAOImpl getInstance(){
        return singletonInstance;
    }

    public static Collection<User> getUsers() {
        return singletonInstance.getCollection();
    }

/*
    we already have same method. Fell free to use it ->       public T save(T object)
    public static void saveUser(User user) {
        if (singletonInstance == null) {
            singletonInstance = new UserDAOImpl();
        }
        singletonInstance.save(user);
        System.out.println("User is saved");
    }
    */
}
