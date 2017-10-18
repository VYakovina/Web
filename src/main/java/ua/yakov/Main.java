package ua.yakov;
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


               /* DaoService daoService = new DaoService();
                Customer cu = new Customer();
                System.out.println(daoService.findById(Customer.class,1));*/
                //System.out.println(daoService.findById(Customer.class,1));
                /*cu.setCustomerName("Tom");
                    daoService.persist(cu);*/
                //System.out.println(daoService.findById(Customer.class,141));
               /* Phone phone = new Phone();
                phone.setPhoneNumber("380981236566");
                cu.setId(141);
                phone.setCustomerPhone(cu);
                daoService.persist(phone);*/


        sessionFactory.close();
        entityManager.close();
    }
}