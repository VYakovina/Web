import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table
public class Roles {
    @Id
    @GeneratedValue

    @Column
    private Integer row_id;

    @Column
    private String nameRole;

    public Integer getRow_id() {
        return row_id;
    }

    public void setRow_id(Integer row_id) {
        this.row_id = row_id;
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
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_roles_id"))
    private User userRoles;
}
