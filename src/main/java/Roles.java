import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Roles {
    @Id
    @GeneratedValue

    @Column
    private Integer id;

    @Column
    private String nameRole;

    public Integer getRow_id() {
        return id;
    }

    public void setRow_id(Integer row_id) {
        this.id = row_id;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    public User getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(User userRoles) {
        this.userRoles = userRoles;
    }

    @ManyToOne
    @JoinColumn(name = "userID", foreignKey = @ForeignKey(name = "fk_roles_id"))
    private User userRoles;
}
