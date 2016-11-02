package main.model;

import java.util.List;

public class AbstractDAOImpl<T extends AbstractEntity>  implements AbstractDAO<T> {
    @Override
    public T save(T object) {
        return null;
    }

    @Override
    public void delete(T object) {

    }

    @Override
    public void deleteAll(List<T> list) {

    }

    @Override
    public void saveAll(List<T> list) {

    }

    @Override
    public List<T> getList() {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public T get(long id) {
        return null;
    }
}
