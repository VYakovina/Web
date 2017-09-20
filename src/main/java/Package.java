import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "Package")
public class Package {
    @Id
    @GeneratedValue

    @Column(name = "Row_id")
    private Integer Row_id;

    @Column(name = "packageName")
    private String packageName;

    public Integer getRow_id() {
        return Row_id;
    }

    public void setRow_id(Integer row_id) {
        Row_id = row_id;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    @OneToMany (cascade = CascadeType.ALL,orphanRemoval = true, mappedBy = "packagesPayment")
    private ArrayList<Payment> packagesPayment = new ArrayList<>();


    @OneToMany (cascade = CascadeType.ALL,orphanRemoval = true, mappedBy = "packagesStatus")
    private ArrayList<Status> packagesStatus = new ArrayList<>();

    @OneToMany(mappedBy = "rationalPack",cascade = CascadeType.ALL,orphanRemoval = true)
    private ArrayList<Relational> rationalPack = new ArrayList<>();
}
