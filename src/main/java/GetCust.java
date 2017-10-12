import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.List;

public class GetCust {

    /*private EntityManager entityManager;

    public void getPhonNum( ) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
        Root<Customer> root = criteriaQuery.from(Customer.class);
        Path<String> customPhone = root.get(Customer_.customerName);

        Join<Customer, Phone> userAndPhone  = root.join(Customer_.customerPhone);
        Path<String> numberPath  = customPhone.get(String.valueOf(Phone_.phoneNumber));

        criteriaQuery.select(criteriaBuilder
                .construct(Customer.class, customPhone, numberPath));

        criteriaQuery.where(criteriaBuilder
                .equal(root.get(Customer_.customerName), "Test"));
    }*/
}
