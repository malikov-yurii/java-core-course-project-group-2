package main.dao;

import main.model.AbstractEntity;

import java.util.Collection;
import java.util.List;

public interface AbstractDAO<T extends AbstractEntity> {
    T save(T object);
    boolean delete(T object);
    boolean deleteAll(Collection<T> collection);
    boolean saveAll(Collection<T> collection);
    List<T> getList();
    boolean deleteById(long id);
    T get(long id);
}
