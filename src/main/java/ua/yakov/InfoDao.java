package ua.yakov;

import org.hibernate.Criteria;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import ua.yakov.GenericDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import static ua.yakov.UserPass_.userName;

public   class InfoDao<T, PK extends Serializable>  implements GenericDAO<T, PK> {

    private Session currentSession;
    private Transaction currentTransaction;
    private static EntityManager entityManager;


    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    private static SessionFactory getSessionFactory() {
        SessionFactory sessionFactory =  (SessionFactory) Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        return sessionFactory;
    }
    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    @Override
    public void persist(T entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(T entity) {
        getCurrentSession().update(entity);
    }

    public T findById(Class <T> clazz, PK id) {
        T obj = (T) getCurrentSession().get(clazz, id);
        return obj ;
    }

    @Override
    public void delete(T entity) {
        getCurrentSession().delete(entity);
    }

    public void deleteAll(Class<T> type) {
        List<T> entityList = findAll(type);
        for (T entity : entityList) {
            delete(entity);
        }
    }

    public  List <T> findAll (Class <T> clazz){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        TypedQuery<T> typedQuery = entityManager.createQuery(criteriaQuery);
        List<T> res  =  typedQuery.getResultList();
        return res;
    }




   /* public  UserPass exists ( String uname, String upass ){

         CriteriaBuilder cb = entityManager.getCriteriaBuilder();
         CriteriaQuery<UserPass> criteriaQuery = cb.createQuery(UserPass.class);
         Root<UserPass> from = criteriaQuery.from(UserPass.class);
         criteriaQuery.select(from);
         criteriaQuery.where(cb.equal(from.get(UserPass_.userName), uname));
         criteriaQuery.where(cb.equal(from.get(UserPass_.userPass), upass));

         TypedQuery<Long> tq = entityManager.createQuery(criteriaQuery);
        return tq.getSingleResult() > 0;

     }*/

}





