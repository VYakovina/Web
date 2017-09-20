import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "Status")
public class Status {
    @Id
    @GeneratedValue(generator = "incrementator")
    @GenericGenerator(name = "incrementator", strategy = "increment")

    @Column(name = "Row_id")
    private Integer Row_id;

    @Column(name = "statusService")
    private String statusService;

    public Integer getRow_id() {
        return Row_id;
    }

    public void setRow_id(Integer row_id) {
        Row_id = row_id;
    }

    public String getStatusService() {
        return statusService;
    }

    public void setStatusService(String statusService) {
        this.statusService = statusService;
    }

    @ManyToOne
    @JoinColumn(name = "packages_id", foreignKey = @ForeignKey(name = "fk_status_id"))
    private Package packagesStatus;
}
