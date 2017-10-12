import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Package {
    @Id
    @GeneratedValue

    @Column
    private Integer row_id;

    @Column
    private String packageName;

    public Integer getRow_id() {
        return row_id;
    }

    public void setRow_id(Integer row_id) {
        this.row_id = row_id;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public List<Status> getPackagesStatus() {
        return packagesStatus;
    }

    public void setPackagesStatus(List<Status> packagesStatus) {
        this.packagesStatus = packagesStatus;
    }

    public List<Phone> getPackagePhone() {
        return packagePhone;
    }

    public void setPackagePhone(List<Phone> packagePhone) {
        this.packagePhone = packagePhone;
    }


    @OneToMany (cascade = CascadeType.ALL,orphanRemoval = true, mappedBy = "packagesStatus")
    private List<Status> packagesStatus = new ArrayList<>();

    @OneToMany (cascade = CascadeType.ALL,orphanRemoval = true, mappedBy = "packagePhone")
    private List<Phone> packagePhone = new ArrayList<>();

}
