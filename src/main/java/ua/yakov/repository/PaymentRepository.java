package ua.yakov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.yakov.entity.Payment;
import java.util.List;


public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    @Query("select c from Payment c where c.customerPaymennt = :id")
    List<Payment> getCustomerPayments(@Param("id") int id);

    @Query("select p from Payment p "
            + " where p.customerPaymennt = :customerId and p.id = :id")
    Payment getCustomerPayment(@Param("id") int id, @Param("customerId") int customerId);
}
