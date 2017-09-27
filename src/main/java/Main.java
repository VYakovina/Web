import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory =  (SessionFactory) Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
      EntityManager  entityManager = sessionFactory.createEntityManager();
      entityManager.getTransaction().begin();

        Date date = new Date();

        /*Customer customer = new Customer();
        customer.setCustomerName("Test");
        customer.setActivated(date);
        customer.setBalance((float) 45.6);
        customer.setDeactivated(date);

        entityManager.persist(customer);
        entityManager.getTransaction().commit();
        entityManager.close();
        sessionFactory.close();*/

       /* StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder().configure(new File("hibernate.cfg.xml")).build();

        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            session.beginTransaction();*/

            DaoService daoService = new DaoService();
            Customer customer1 = new Customer();
            customer1.setCustomerName("Test2344");
            daoService.persist(customer1);

        // System.out.println(daoService.findById(2));

            List<Customer> customers1 = daoService.findAll();
            System.out.println("Customers Persisted are :");
            for (Customer c : customers1) {
                System.out.println("-" + c.toString());
            }
        entityManager.close();
        sessionFactory.close();

    }
}