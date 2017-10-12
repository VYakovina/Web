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
                System.out.println(daoService.findById(Customer.class,4));

                System.out.println(daoService.findById(Customer.class,4));
               /* Phone phone = new Phone();
                phone.setPhoneNumber((long)3456677);
                cu.setRow_id(1);
                phone.setCustomerPhone(cu);
                daoService.persist(phone);*/
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


/*
        Phone ph = new Phone();
        Customer cus = new Customer();
        DaoService  daoService = new DaoService<>();
        ph.setPhoneNumber(2589631);
        cus.setCustomerName("Tolya");
        cus.setActivated(date);
        cus.setBalance(45);
        cus.setPhone(2589631);
        daoService.persist(cus);
        daoService.persist(ph);
*/


        sessionFactory.close();

    }
}