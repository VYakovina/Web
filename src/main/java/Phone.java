import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
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
    private Integer row_id;

    @Column
    private String phoneNumber;

    public Integer getRow_id() {
        return row_id;
    }

    public void setRow_id(Integer row_id) {
        this.row_id = row_id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Customer getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(Customer customerPhone) {
        this.customerPhone = customerPhone;
    }

    public List<Call> getCallPhone() {
        return callPhone;
    }

    public void setCallPhone(List<Call> callPhone) {
        this.callPhone = callPhone;
    }

    public Package getPackagePhone() {
        return packagePhone;
    }

    public void setPackagePhone(Package packagePhone) {
        this.packagePhone = packagePhone;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id", foreignKey = @ForeignKey(name = "fk_phone_id"))
    private Customer customerPhone;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, mappedBy = "callPhone")
    private List<Call> callPhone = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "package_id", foreignKey = @ForeignKey(name = "fk_phone2_id"))
    private Package packagePhone;

}
