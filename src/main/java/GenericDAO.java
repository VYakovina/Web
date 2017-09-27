import java.io.Serializable;
import java.util.List;

public interface GenericDAO <T, id extends Serializable> {

    public void persist(T entity);
    public void update(T entity);
    public T findById(id id);
    public void delete(T entity);
    public List<T> findAll();
    public void deleteAll();

}
