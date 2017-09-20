import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue

    @Column(name = "Row_id")
    private Integer Row_id;

    @Column(name = "userName")
    private String userName;

    @Column(name = "userPass")
    private String userPass;

    public Integer getRow_id() {
        return Row_id;
    }

    public void setRow_id(Integer row_id) {
        Row_id = row_id;
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

    @ManyToOne
    @JoinColumn(name = "customer_id", foreignKey = @ForeignKey(name = "fk_user_id"))
    private Customer customerUser;

    @OneToMany (cascade = CascadeType.ALL,orphanRemoval = true, mappedBy = "userRoles")
    private ArrayList<Roles> userRoles = new ArrayList<>();
}
