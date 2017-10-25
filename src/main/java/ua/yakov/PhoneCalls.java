package ua.yakov;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
@Component
@Entity
@Table
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PhoneCalls {
    @Id
    @GeneratedValue

    @Column
    private Integer id;

    @Column
    private Date callDate;

    @Column
    private BigInteger phoneNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer row_id) {
        this.id = id;
    }

    public Date getCallDate() {
        return callDate;
    }

    public void setCallDate(Date callDate) {
        this.callDate = callDate;
    }

    public BigInteger getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(BigInteger phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public PhoneCalls getCallPhone() {
        return callPhone;
    }

    public void setCallPhone(PhoneCalls callPhone) {
        this.callPhone = callPhone;
    }

    @ManyToOne
    @JoinColumn(name = "phonID", foreignKey = @ForeignKey(name = "fk_call_id"))
    private PhoneCalls callPhone;
}
