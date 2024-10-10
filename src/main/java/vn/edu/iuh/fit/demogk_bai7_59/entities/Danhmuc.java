package vn.edu.iuh.fit.demogk_bai7_59.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "danhmuc")
public class Danhmuc {
    @Id
    @Column(name = "MADM", nullable = false, length = 50)
    private String madm;

    @Column(name = "TENDANHMUC", nullable = false, length = 50)
    private String tendanhmuc;

    @Column(name = "NGUOIQUANLY", nullable = false, length = 50)
    private String nguoiquanly;

    @Column(name = "GHICHU", length = 100)
    private String ghichu;

    public Danhmuc() {
    }

    public Danhmuc(String madm) {
        this.madm = madm;
    }

    public Danhmuc(String madm, String tendanhmuc, String nguoiquanly, String ghichu) {
        this.madm = madm;
        this.tendanhmuc = tendanhmuc;
        this.nguoiquanly = nguoiquanly;
        this.ghichu = ghichu;
    }

    public String getMadm() {
        return madm;
    }

    public void setMadm(String madm) {
        this.madm = madm;
    }

    public String getTendanhmuc() {
        return tendanhmuc;
    }

    public void setTendanhmuc(String tendanhmuc) {
        this.tendanhmuc = tendanhmuc;
    }

    public String getNguoiquanly() {
        return nguoiquanly;
    }

    public void setNguoiquanly(String nguoiquanly) {
        this.nguoiquanly = nguoiquanly;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    @Override
    public String toString() {
        return "Danhmuc{" +
                "madm='" + madm + '\'' +
                ", tendanhmuc='" + tendanhmuc + '\'' +
                ", nguoiquanly='" + nguoiquanly + '\'' +
                ", ghichu='" + ghichu + '\'' +
                '}';
    }
}