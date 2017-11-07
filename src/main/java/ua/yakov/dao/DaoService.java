package ua.yakov.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.yakov.entity.UserPass;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class DaoService<T>  {


    @Autowired
    private Dao<T,Integer> dao;

    @Transactional
    public void persist(T entity) {
        dao.persist(entity);
    }
    @Transactional
    public void update(T entity) {
        dao.update(entity);
    }

    public T findById(Class <T> clazz, Integer id) {
        T obj =  dao.findById(clazz, id);
        return obj;
    }
    @Transactional
    public void delete(Class <T> clazz, Integer id) {
        T obj =  dao.findById(clazz, id);
        dao.delete(obj);
    }
    @Transactional
    public void deleteAll(Class <T> clazz) {
        dao.deleteAll(clazz);
    }

    public  List <T> findAll (Class <T> clazz) {
        List<T> obj = dao.findAll(clazz);
        return  obj;
    }

    public   UserPass exists (String uname, String upass) {
         UserPass obj = dao.exists(uname,upass);
        return obj;
    }

    public   UserPass userExists (String uname) {
         UserPass obj = dao.userExists(uname);
        return obj;
    }


    public Dao Dao() {
        return dao;

    }

}


