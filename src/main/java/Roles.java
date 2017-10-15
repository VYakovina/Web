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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
