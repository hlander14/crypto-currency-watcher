package by.myself.crypto.service;

import java.util.List;

public interface TrackService<T, K> {
    List<T> findAll();

    T findById(K id);

    void save(T entity);

    void delete(K id);
}
