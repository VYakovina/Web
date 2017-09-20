import javax.persistence.*;

@Entity
@Table(name = "Relational")
public class Relational {
    @Id
    @ManyToOne
    private Relational rationalPack;
    @Id
    @ManyToOne
    private Package packCustom;

    @Column(name = "numberPhone")
    private Integer numberPhome;

    public Relational getRationalPack() {
        return rationalPack;
    }

    public void setRationalPack(Relational rationalPack) {
        this.rationalPack = rationalPack;
    }

    public Package getPackCustom() {
        return packCustom;
    }

    public void setPackCustom(Package packCustom) {
        this.packCustom = packCustom;
    }

    public Integer getNumberPhome() {
        return numberPhome;
    }

    public void setNumberPhome(Integer numberPhome) {
        this.numberPhome = numberPhome;
    }
}
