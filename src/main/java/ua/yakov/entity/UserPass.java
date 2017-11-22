package ua.yakov.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Component
@Entity
@Table
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UserPass {
    @Id
    @GeneratedValue

    @Column
    private Integer id;
    @Column
    private String username;
    @Column
    private String enabled;
    @Column
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
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
