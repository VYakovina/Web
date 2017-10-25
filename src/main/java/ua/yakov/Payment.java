package ua.yakov;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;
@Component
@Entity
@Table
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Payment {
    @Id
    @GeneratedValue

    @Column
    private Integer id;

    @Column
    private Date paymentDate;

    @Column
    private Integer paymentAmount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Integer getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Integer paymentAmount) {
        this.paymentAmount = paymentAmount;
    }


    public Customer getCustomerPaymennt() {
        return customerPaymennt;
    }

    public void setCustomerPaymennt(Customer customerPaymennt) {
        this.customerPaymennt = customerPaymennt;
    }

    @ManyToOne
    @JoinColumn(name = "customID", foreignKey = @ForeignKey(name = "fk_payment_id"))
    private Customer customerPaymennt;

}
