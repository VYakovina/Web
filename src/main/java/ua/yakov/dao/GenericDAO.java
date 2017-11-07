package ua.yakov.dao;
import org.springframework.stereotype.Component;
import java.io.Serializable;

@Component
public interface GenericDao<T, PK extends Serializable> {

    public void persist(T entity);
    public void update(T entity);
    public T findById(Class <T> clazz, PK id);
    public void delete(T entity);
    public void deleteAll(Class<T> type);

}
