package ua.yakov.dao;

import org.springframework.stereotype.Component;
import ua.yakov.entity.UserPass;
import ua.yakov.UserPass_;
import ua.yakov.entity.UserPass_;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.io.Serializable;
import java.util.List;

@Component
public class InfoDao<T, PK extends Serializable> implements GenericDAO<T, PK> {

   @PersistenceContext
    private static EntityManager entityManager;

    @Override
    public void persist(T entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(T entity) {
        entityManager.merge(entity);
    }

    public T findById(Class<T> clazz, PK id) {
        T obj = (T) entityManager.find(clazz, id);
        return obj;
    }

    @Override
    public void delete(T entity) {
        entityManager.remove(entity);
    }

    public void deleteAll(Class<T> type) {
        List<T> entityList = findAll(type);
        for (T entity : entityList) {
            delete(entity);
        }
    }

    public List<T> findAll(Class<T> clazz) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        TypedQuery<T> typedQuery = entityManager.createQuery(criteriaQuery);
        List<T> res = typedQuery.getResultList();
        return res;
    }

    public UserPass exists(String uname, String upass) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserPass> criteriaQuery = cb.createQuery(UserPass.class);
        Root<UserPass> from = criteriaQuery.from(UserPass.class);
        Predicate predicate1 = cb.equal(from.get(UserPass_.userName), uname);
        Predicate predicate2 = cb.equal(from.get(UserPass_.userPass), upass);
        Predicate predicate = cb.and(predicate1, predicate2);
        criteriaQuery.where(predicate);
        TypedQuery<UserPass> tq = entityManager.createQuery(criteriaQuery);
        List<UserPass> res = tq.getResultList();
        if (res.isEmpty()) {
            return null;
        } else
            return res.get(0);
    }

    public UserPass userExists(String rname) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserPass> criteriaQuery = cb.createQuery(UserPass.class);
        Root<UserPass> from = criteriaQuery.from(UserPass.class);
        Predicate predicate = cb.equal(from.get(UserPass_.userName), rname);
        criteriaQuery.where(predicate);
        TypedQuery<UserPass> tq = entityManager.createQuery(criteriaQuery);
        List<UserPass> res = tq.getResultList();
        if (res.isEmpty()) {
            return null;
        } else
            return res.get(0);
    }


}





