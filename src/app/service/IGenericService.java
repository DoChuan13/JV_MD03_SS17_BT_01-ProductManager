package app.service;

import java.util.List;

public interface IGenericService<T> {
    List<T> findAll();

    void save(T t);

    T findById(int id);

    T delete(int id);

    void updateDatabase();
}
