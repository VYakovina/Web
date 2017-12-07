package ua.yakov.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.yakov.entity.Customer;
import ua.yakov.entity.Payment;
import ua.yakov.repository.CustomerRepository;
import ua.yakov.repository.PaymentRepository;
import ua.yakov.service.PaymentService;
import ua.yakov.validation.CusUser;

import java.util.List;
@Service(value = "paymentService")
public class PaymentImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void addPayment(Payment payment) {
        paymentRepository.saveAndFlush(payment);
    }

    @Override
    public Integer makePayment(Customer customer, CusUser paymentC) {
        if (customer == null) { return -1; }
    else {
            Payment payment = new Payment();
            payment.setCustomerPaymennt(customer);
            payment.setPaymentAmount(paymentC.getPaymentAmount());
            payment.setPaymentDate(paymentC.getPaymentDate());
            this.addPayment(payment);
            return payment.getId();
        }
    }

    @Override
    public Payment getPayment(int id, int customerID) {
        return paymentRepository.getCustomerPayment(id, customerID);
    }

    @Override
    public Payment getPayment(int id) {
        return paymentRepository.findOne(id);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public List<Payment> getCustomerPayments(Customer customer) {
        return paymentRepository.getCustomerPayments(customer.getId());
    }

    @Override
    public Integer create(CusUser resource) {
        Customer customer = customerRepository.findOne(resource.getCustomerId());
        return this.makePayment(customer, resource);
    }

    @Override
    public void updatePayment(Payment payment, CusUser paymentC) {
        if (payment != null) {
            payment.setPaymentAmount(paymentC.getPaymentAmount());
            payment.setPaymentDate(paymentC.getPaymentDate());
            Customer customer =customerRepository.findOne(paymentC.getCustomerId());
            if (customer != null) {
                payment.setCustomerPaymennt(customer);
            }
        paymentRepository.saveAndFlush(payment); }
    }

    @Override
    public void deletePayment(int id) {
        paymentRepository.delete(id);
        paymentRepository.flush();
    }
}
