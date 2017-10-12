import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Call {
    @Id
    @GeneratedValue

    @Column
    private Integer row_id;

    @Column
    private Date callDate;

    @Column
    private Integer phoneNumber;

    public Integer getRow_id() {
        return row_id;
    }

    public void setRow_id(Integer row_id) {
        this.row_id = row_id;
    }

    public Date getCallDate() {
        return callDate;
    }

    public void setCallDate(Date callDate) {
        this.callDate = callDate;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Call getCallPhone() {
        return callPhone;
    }

    public void setCallPhone(Call callPhone) {
        this.callPhone = callPhone;
    }

    @ManyToOne
    @JoinColumn(name = "phone_id", foreignKey = @ForeignKey(name = "fk_call_id"))
    private Call callPhone;
}
