package main.dao;

import main.model.User;

import java.util.Collection;

public class UserDAOImpl extends AbstractDAOImpl<User> {

    private static UserDAOImpl singletonInstance;

    private UserDAOImpl() {
    }

    public static void initialize(Collection<User> collection) {
        if (singletonInstance == null) {
            singletonInstance = new UserDAOImpl();
            singletonInstance.saveAll(collection);
        }
    }

    public static UserDAOImpl getInstance() {
        return singletonInstance;
    }

    public User getUserById(long userId){
        return getList()
                .stream()
                .filter(user -> user.getId() == userId)
                .findFirst()
                .orElse(null);
    }
}
