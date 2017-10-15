import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Phone {
    @Id
    @GeneratedValue

    @Column
    private Integer id;

    @Column
    private BigInteger phoneNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigInteger getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(BigInteger phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Customer getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(Customer customerPhone) {
        this.customerPhone = customerPhone;
    }

    public List<PhoneCalls> getCallPhone() {
        return callPhone;
    }

    public void setCallPhone(List<PhoneCalls> callPhone) {
        this.callPhone = callPhone;
    }

    public Package getPackagePhone() {
        return packagePhone;
    }

    public void setPackagePhone(Package packagePhone) {
        this.packagePhone = packagePhone;
    }

    @ManyToOne
    @JoinColumn(name = "customID", foreignKey = @ForeignKey(name = "fk_phone_id"))
    private Customer customerPhone;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, mappedBy = "callPhone")
    private List<PhoneCalls> callPhone = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "packID", foreignKey = @ForeignKey(name = "fk_phone2_id"))
    private Package packagePhone;

}
