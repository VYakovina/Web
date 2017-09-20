import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "Phone")
public class Phone {
    @Id
    @GeneratedValue

    @Column(name = "Row_id")
    private Integer Row_id;

    @Column(name = "phoneNumber")
    private Integer phoneNumber;

    public Integer getRow_id() {
        return Row_id;
    }

    public void setRow_id(Integer row_id) {
        Row_id = row_id;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id", foreignKey = @ForeignKey(name = "fk_phone_id"))
    private Customer customerPhone;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, mappedBy = "callPhone")
    private ArrayList<Call> callPhone = new ArrayList<>();
}
