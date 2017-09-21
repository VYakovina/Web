import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Payment {
    @Id
    @GeneratedValue

    @Column
    private Integer row_id;

    @Column
    private Date paymentDate;

    @Column
    private Integer paymentAmount;

    public Integer getRow_id() {
        return row_id;
    }

    public void setRow_id(Integer row_id) {
        this.row_id = row_id;
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
    @JoinColumn(name = "customer_id", foreignKey = @ForeignKey(name = "fk_payment_id"))
    private Customer customerPaymennt;

}
