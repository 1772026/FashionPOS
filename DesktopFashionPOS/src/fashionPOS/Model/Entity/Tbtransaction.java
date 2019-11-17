package fashionPOS.Model.Entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Tbtransaction {
    private Integer id;
    private Date tanggal;
    private Integer status;
    private Integer totalHarga;
    private String tipePembayaran;
    private Tbitem tbitemByTbitemId;
    private Tbcustomer tbcustomerByTbcustomerId;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "tanggal", nullable = false)
    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "total_harga", nullable = false)
    public Integer getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(Integer totalHarga) {
        this.totalHarga = totalHarga;
    }

    @Basic
    @Column(name = "tipe_pembayaran", nullable = false, length = 100)
    public String getTipePembayaran() {
        return tipePembayaran;
    }

    public void setTipePembayaran(String tipePembayaran) {
        this.tipePembayaran = tipePembayaran;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tbtransaction that = (Tbtransaction) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(tanggal, that.tanggal) &&
                Objects.equals(status, that.status) &&
                Objects.equals(totalHarga, that.totalHarga) &&
                Objects.equals(tipePembayaran, that.tipePembayaran);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tanggal, status, totalHarga, tipePembayaran);
    }

    @ManyToOne
    @JoinColumn(name = "tbitem_id", referencedColumnName = "id", nullable = false)
    public Tbitem getTbitemByTbitemId() {
        return tbitemByTbitemId;
    }

    public void setTbitemByTbitemId(Tbitem tbitemByTbitemId) {
        this.tbitemByTbitemId = tbitemByTbitemId;
    }

    @ManyToOne
    @JoinColumn(name = "tbcustomer_id", referencedColumnName = "id", nullable = false)
    public Tbcustomer getTbcustomerByTbcustomerId() {
        return tbcustomerByTbcustomerId;
    }

    public void setTbcustomerByTbcustomerId(Tbcustomer tbcustomerByTbcustomerId) {
        this.tbcustomerByTbcustomerId = tbcustomerByTbcustomerId;
    }
}
