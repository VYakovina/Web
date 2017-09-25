import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory =  (SessionFactory) Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager  entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Date date = new Date();

        Customer customer = new Customer();
        customer.setCustomerName("Test");
        customer.setActivated(date);
        customer.setBalance((float) 45.6);
        customer.setDeactivated(date);

        entityManager.persist(customer);
        entityManager.getTransaction().commit();
        entityManager.close();
        sessionFactory.close();
    }
}
