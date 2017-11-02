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
public class Package {
    @Id
    @GeneratedValue

    @Column
    private Integer id;

    @Column
    private String packageName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
