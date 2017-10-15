import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User {
    @Id
    @GeneratedValue

    @Column
    private Integer id;

    @Column
    private String userName;

    @Column
    private String userPass;

    public Integer getRow_id() {
        return id;
    }

    public void setRow_id(Integer row_id) {
        this.id = row_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public Customer getCustomerUser() {
        return customerUser;
    }

    public void setCustomerUser(Customer customerUser) {
        this.customerUser = customerUser;
    }

    public List<Roles> getUserRoles() {
        return userRole;
    }

    public void setUserRoles(ArrayList<Roles> userRoles) {
        this.userRole = userRoles;
    }

    @ManyToOne
    @JoinColumn(name = "customID", foreignKey = @ForeignKey(name = "fk_user_id"))
    private Customer customerUser;

    @OneToMany (cascade = CascadeType.ALL,orphanRemoval = true, mappedBy = "userRoles")
    private List<Roles> userRole = new ArrayList<>();
}
