import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table
public class Status {
    @Id
    @GeneratedValue

    @Column
    private Integer row_id;

    @Column
    private String statusService;

    public Integer getRow_id() {
        return row_id;
    }

    public void setRow_id(Integer row_id) {
        this.row_id = row_id;
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
    @JoinColumn(name = "packages_id", foreignKey = @ForeignKey(name = "fk_status_id"))
    private Package packagesStatus;
}
