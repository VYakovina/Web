package ua.yakov.service;

import ua.yakov.entity.Customer;
import java.util.List;

public interface CustomerService {
    Customer addCustomer(Customer customer);
    void delete(int id);
    Customer getByName(String name);
    Customer editCustomer(Customer customer);
    List<Customer> getAll();
}
