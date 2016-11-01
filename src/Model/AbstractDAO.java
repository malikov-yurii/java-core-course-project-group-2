package Model;

import java.util.List;

public interface AbstractDAO<T extends AbstractEntity> {
    T save(T object);
    void delete(T object);
    void deleteAll(List<T> list);
    void saveAll(List<T> list);
    List<T> getList();
    void deleteById(long id);
    T get(long id);
}
