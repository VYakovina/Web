package ua.yakov.service;

import ua.yakov.entity.Customer;
import ua.yakov.entity.Payment;
import ua.yakov.validation.CusUser;

import java.util.List;

public interface PaymentService {
    Integer makePayment(Customer customer, CusUser payment);
    Payment getPayment(int id, int customerID);
    void addPayment(Payment payment);
    Payment getPayment(int id);
    List<Payment> getAllPayments();
    List<Payment> getCustomerPayments(Customer customer);
    Integer create(CusUser resource);
    void updatePayment(Payment payment,CusUser paymentDTO);
    void deletePayment(int id);
}
