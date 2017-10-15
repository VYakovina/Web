import org.hibernate.SessionFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory =  (SessionFactory) Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager  entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

                Date date = new Date();

                DaoService daoService = new DaoService();
                Customer cu = new Customer();
               // cu.setCustomerName("Tom");
               // daoService.persist(cu);
               // System.out.println(daoService.findById(Customer.class,4));

               // System.out.println(daoService.findById(Customer.class,4));
                Phone phone = new Phone();
                phone.setPhoneNumber("380981236547");

        phone.getCustomerPhone();


                daoService.persist(phone);
        /*        Phone cus = new Phone();
        cus.setPhoneNumber((long) 197542);
        daoService.persist(cus);*/

               /* DaoService daoService = new DaoService();
                System.out.println(daoService.findAll(Customer.class));*/

           /* List<Customer> customers1 = daoService.findAll();
            System.out.println("Customers Persisted are :");
            for (Customer c : customers1) {
                System.out.println("-" + c.toString());
            }*/

        sessionFactory.close();
        entityManager.close();
    }
}