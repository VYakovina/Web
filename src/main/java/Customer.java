
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Customer {
    @Id
    @GeneratedValue

    @Column
    private Integer row_id;

    @Column
    private String customerName;

    @Column
    private float balance;

    @Column
    private Date activated;

    @Column
    private Date deactivated;

    public Customer() {
    }

    public Integer getRow_id() {
        return row_id;
    }

    public void setRow_id(Integer row_id) {
        this.row_id = row_id;
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

    public List<Phone> getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(List<Phone> customerPhone) {
        this.customerPhone = customerPhone;
    }

    public List<User> getCustomerUser() {
        return customerUser;
    }

    public void setCustomerUser(List<User> customerUser) {
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
    private List<User> customerUser = new ArrayList<>();

    @OneToMany (cascade = CascadeType.ALL,orphanRemoval = true, mappedBy = "customerPaymennt")
    private List<Payment> customerPayment = new ArrayList<>();

    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                '}';
    }
}

