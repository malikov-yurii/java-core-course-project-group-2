package Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDAOImpl implements AbstractDAO<User> {

    private final Collection<User> users = new ArrayList<>();

    @Override
    public User save(User object) {
        return null;
    }

    @Override
    public void delete(User object) {

    }

    @Override
    public void deleteAll(List<User> list) {

    }

    @Override
    public void saveAll(List<User> list) {

    }

    @Override
    public List<User> getList() {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public User get(long id) {
        return null;
    }
}
