import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public   class InfoDao<T, PK extends Serializable>  implements GenericDAO <T, PK> {

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


}





