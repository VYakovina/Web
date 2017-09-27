import java.util.List;

public class DaoService<T>  {

    private static InfoDao infoDao;

    public DaoService() {
        infoDao = new InfoDao();
    }

    public void persist(T entity) {
        infoDao.openCurrentSessionwithTransaction();
        infoDao.persist(entity);
        infoDao.closeCurrentSessionwithTransaction();
    }

    public void update(T entity) {
        infoDao.openCurrentSessionwithTransaction();
        infoDao.update(entity);
        infoDao.closeCurrentSessionwithTransaction();
    }

    public T findById(Integer id) {
        infoDao.openCurrentSession();
        T obj = (T) infoDao.findById(id);
        infoDao.closeCurrentSession();
        return obj;
    }

    public void delete(Integer id) {
        infoDao.openCurrentSessionwithTransaction();
        T obj = (T) infoDao.findById(id);
        infoDao.delete(obj);
        infoDao.closeCurrentSessionwithTransaction();
    }

    public List<T> findAll() {
        infoDao.openCurrentSession();
        List<T> obj = infoDao.findAll();
        infoDao.closeCurrentSession();
        return obj;
    }

    public void deleteAll() {
        infoDao.openCurrentSessionwithTransaction();
        infoDao.deleteAll();
        infoDao.closeCurrentSessionwithTransaction();
    }

    public InfoDao infoDao() {
        return infoDao;

    }

}


