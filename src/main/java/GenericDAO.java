import java.io.Serializable;
import java.util.List;

public interface GenericDAO <T, row_id extends Serializable> {

    public void persist(T entity);
    public void update(T entity);
    public T findById(row_id id);
    public void delete(T entity);
    public List<T> findAll();
    public void deleteAll();

}
