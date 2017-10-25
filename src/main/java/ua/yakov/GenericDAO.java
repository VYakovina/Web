package ua.yakov;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO <T, PK extends Serializable> {

    public void persist(T entity);
    public void update(T entity);
    public T findById(Class <T> clazz, PK id);
    public void delete(T entity);
    public void deleteAll(Class<T> type);

}
