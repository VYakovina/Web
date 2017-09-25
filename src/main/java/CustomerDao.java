import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


import java.util.List;

public class CustomerDao implements GenericDAO <Customer, Integer> {

    private Session currentSession;
    private Transaction currentTransaction;

    public CustomerDao( ) {
    }

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
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
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
    public void persist(Customer entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Customer entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Customer findById(Integer id) {
        Customer customer = (Customer) getCurrentSession().get(Customer.class, id);
        return customer;
    }

    @Override
    public void delete(Customer entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<Customer> findAll() {
        List<Customer> customers = (List<Customer>) getCurrentSession().createQuery("from Customer").list();
        return customers;
    }

    public void deleteAll() {
        List<Customer> entityList = findAll();
        for (Customer entity : entityList) {
            delete(entity);

        }

    }

}




