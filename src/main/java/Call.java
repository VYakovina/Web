import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Call")
public class Call {
    @Id
    @GeneratedValue

    @Column(name = "Row_id")
    private Integer Row_id;

    @Column(name = "callDate")
    private Date callDate;

    @Column(name = "phoneNumber")
    private Integer phoneNumber;

    public Integer getRow_id() {
        return Row_id;
    }

    public void setRow_id(Integer row_id) {
        Row_id = row_id;
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

    @ManyToOne
    @JoinColumn(name = "phone_id", foreignKey = @ForeignKey(name = "fk_call_id"))
    private Call callPhone;
}
