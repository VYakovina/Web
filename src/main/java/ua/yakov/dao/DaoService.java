package ua.yakov.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.yakov.entity.UserPass;

import javax.transaction.Transactional;
import java.util.List;

@Component

public class DaoService<T>  {


    @Autowired
    private InfoDao <T,Integer> infoDao;

    @Transactional
    public void persist(T entity) {
        infoDao.persist(entity);
    }
    @Transactional
    public void update(T entity) {
        infoDao.update(entity);
    }
    @Transactional
    public T findById(Class <T> clazz, Integer id) {
        T obj =  infoDao.findById(clazz, id);
        return obj;
    }
    @Transactional
    public void delete(Class <T> clazz, Integer id) {
        T obj =  infoDao.findById(clazz, id);
        infoDao.delete(obj);
    }
    @Transactional
    public void deleteAll(Class <T> clazz) {
        infoDao.deleteAll(clazz);
    }
    @Transactional
    public  List <T> findAll (Class <T> clazz) {
        List<T> obj = infoDao.findAll(clazz);
        return  obj;
    }
    @Transactional
    public  UserPass exists (String uname, String upass) {
        UserPass obj = infoDao.exists(uname,upass);
        return obj;
    }
    @Transactional
    public  UserPass userExists (String rname) {
        UserPass obj = infoDao.userExists(rname);
        return obj;
    }


    public InfoDao infoDao() {
        return infoDao;

    }

}


