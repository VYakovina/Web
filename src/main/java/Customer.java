import antlr.collections.List;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(generator = "incrementator")
    @GenericGenerator(name = "incrementator", strategy = "increment")

    @Column (name = "Row_id")
    private Integer Row_id;

    @Column(name = "customerName")
    private String customerName;

    @Column(name = "Balance")
    private Float Balance;

    @Column(name = "Activated")
    private Date Activated;

    @Column (name = "Deactivated")
    private Date Deactivated;

    public Integer getRow_id() {
        return Row_id;
    }

    public void setRow_id(Integer row_id) {
        Row_id = row_id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Float getBalance() {
        return Balance;
    }

    public void setBalance(Float balance) {
        Balance = balance;
    }

    public Date getActivated() {
        return Activated;
    }

    public void setActivated(Date activated) {
        Activated = activated;
    }

    public Date getDeactivated() {
        return Deactivated;
    }

    public void setDeactivated(Date deactivated) {
        Deactivated = deactivated;
    }

    @OneToMany (cascade = CascadeType.ALL,orphanRemoval = true, mappedBy = "customerPhone")
    private ArrayList<Phone> customerPhone = new ArrayList<>();

    @OneToMany (cascade = CascadeType.ALL,orphanRemoval = true, mappedBy = "customerUser")
    private ArrayList<User> customerUser = new ArrayList<>();

    @OneToMany(mappedBy = "rationalPack",cascade = CascadeType.ALL,orphanRemoval = true)
    private ArrayList<Relational> rationalPack = new ArrayList<>();

}
