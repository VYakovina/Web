package ua.yakov;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
@Component
public class DaoService<T>  {

    private InfoDao <T,Integer> infoDao;

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

    public T findById(Class <T> clazz, Integer id) {
        infoDao.openCurrentSession();
        T obj =  infoDao.findById(clazz, id);
        infoDao.closeCurrentSession();
        return obj;
    }

    public void delete(Class <T> clazz, Integer id) {
        infoDao.openCurrentSessionwithTransaction();
        T obj =  infoDao.findById(clazz, id);
        infoDao.delete(obj);
        infoDao.closeCurrentSessionwithTransaction();
    }

    public void deleteAll(Class <T> clazz) {
        infoDao.openCurrentSessionwithTransaction();
        infoDao.deleteAll(clazz);
        infoDao.closeCurrentSessionwithTransaction();
    }

    public  List <T> findAll (Class <T> clazz) {
        infoDao.openCurrentSession();
        List<T> obj = infoDao.findAll(clazz);
        infoDao.closeCurrentSession();
        return  obj;
    }

    public  UserPass exists (String uname, String upass) {
        infoDao.openCurrentSession();
        UserPass obj = infoDao.exists(uname,upass);
        infoDao.closeCurrentSession();
        return obj;
    }

    public  UserPass userExists (String rname) {
        infoDao.openCurrentSession();
        UserPass obj = infoDao.userExists(rname);
        infoDao.closeCurrentSession();
        return obj;
    }


    public InfoDao infoDao() {
        return infoDao;

    }

}


