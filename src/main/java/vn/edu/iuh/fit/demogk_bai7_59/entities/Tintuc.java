package vn.edu.iuh.fit.demogk_bai7_59.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "tintuc")
public class Tintuc {
    @Id
    @Column(name = "MATT", nullable = false, length = 50)
    private String matt;

    @Column(name = "TIEUDE", nullable = false, length = 50)
    private String tieude;

    @Column(name = "NOIDUNGTT", length = 50)
    private String noidungtt;

    @Column(name = "LIENKET", length = 50)
    private String lienket;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "MADM", nullable = false)
    private Danhmuc madm;

    public Tintuc() {
    }

    public Tintuc(String matt, String tieude, String noidungtt, String lienket, Danhmuc madm) {
        this.matt = matt;
        this.tieude = tieude;
        this.noidungtt = noidungtt;
        this.lienket = lienket;
        this.madm = madm;
    }

    public String getMatt() {
        return matt;
    }

    public void setMatt(String matt) {
        this.matt = matt;
    }

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public String getNoidungtt() {
        return noidungtt;
    }

    public void setNoidungtt(String noidungtt) {
        this.noidungtt = noidungtt;
    }

    public String getLienket() {
        return lienket;
    }

    public void setLienket(String lienket) {
        this.lienket = lienket;
    }

    public Danhmuc getMadm() {
        return madm;
    }

    public void setMadm(Danhmuc madm) {
        this.madm = madm;
    }

    @Override
    public String toString() {
        return "Tintuc{" +
                "matt='" + matt + '\'' +
                ", tieude='" + tieude + '\'' +
                ", noidungtt='" + noidungtt + '\'' +
                ", lienket='" + lienket + '\'' +
                ", madm=" + madm +
                '}';
    }
}