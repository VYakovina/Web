import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Status {
    @Id
    @GeneratedValue

    @Column
    private Integer id;

    @Column
    private String statusService;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatusService() {
        return statusService;
    }

    public void setStatusService(String statusService) {
        this.statusService = statusService;
    }

    public Package getPackagesStatus() {
        return packagesStatus;
    }

    public void setPackagesStatus(Package packagesStatus) {
        this.packagesStatus = packagesStatus;
    }

    @ManyToOne
    @JoinColumn(name = "packID", foreignKey = @ForeignKey(name = "fk_status_id"))
    private Package packagesStatus;
}
