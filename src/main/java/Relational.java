import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Relational")
public class Relational {
    @Id
    @ManyToOne
    private Relational rationalPack;
    @Id
    @ManyToOne
    private Package packCustom;
}
