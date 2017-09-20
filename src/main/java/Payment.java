import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Payment")
public class Payment {
    @Id
    @GeneratedValue(generator = "incrementator")
    @GenericGenerator(name = "incrementator", strategy = "increment")

    @Column(name = "Row_id")
    private Integer Row_id;

    @Column(name = "paymentDate")
    private Date paymentDate;

   @Column(name = "paymentAmount")
    private Integer paymentAmount;

    public Integer getRow_id() {
        return Row_id;
    }

    public void setRow_id(Integer row_id) {
        Row_id = row_id;
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


    @ManyToOne
    @JoinColumn(name = "packages_id", foreignKey = @ForeignKey(name = "fk_payments_id"))
    private Package packagesPayment;
}
