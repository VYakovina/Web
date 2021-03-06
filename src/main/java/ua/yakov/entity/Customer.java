package ua.yakov.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Entity
@Table
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Customer {
    @Id
    @GeneratedValue

    @Column
    private Integer id;

    @Column
    private String customerName;

    @Column
    private float balance;

    @Column
    private Date activated;

    @Column
    private Date deactivated;

    @Column
    private String email;

    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public Date getActivated() {
        return activated;
    }

    public void setActivated(Date activated) {
        this.activated = activated;
    }

    public Date getDeactivated() {
        return deactivated;
    }

    public void setDeactivated(Date deactivated) {
        this.deactivated = deactivated;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Phone> getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(List<Phone> customerPhone) {
        this.customerPhone = customerPhone;
    }

    public List<UserPass> getCustomerUser() {
        return customerUser;
    }

    public void setCustomerUser(List<UserPass> customerUser) {
        this.customerUser = customerUser;
    }

    public List<Payment> getCustomerPayment() {
        return customerPayment;
    }

    public void setCustomerPayment(List<Payment> customerPayment) {
        this.customerPayment = customerPayment;
    }

    @OneToMany (cascade = CascadeType.ALL,orphanRemoval = true, mappedBy = "customerPhone")
    private List<Phone> customerPhone = new ArrayList<>();

    @OneToMany (cascade = CascadeType.ALL,orphanRemoval = true, mappedBy = "customerUser")
    private List<UserPass> customerUser = new ArrayList<>();

    @OneToMany (cascade = CascadeType.ALL,orphanRemoval = true, mappedBy = "customerPaymennt")
    private List<Payment> customerPayment = new ArrayList<>();

    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                '}';
    }
}

