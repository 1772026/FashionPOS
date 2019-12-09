package fashionPOS.Model.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Tbsizestock {
    private int sizestockId;
    private int sizestockSStock;
    private int sizestockMStock;
    private int sizestockLStock;
    private int sizestockXlStock;
    private int sizestockXxlStock;
    private int sizestockXxxlStock;
    private Tbitem tbitemByTbitemItemId;

    @Id
    @Column(name = "sizestock_id", nullable = false)
    public int getSizestockId() {
        return sizestockId;
    }

    public void setSizestockId(int sizestockId) {
        this.sizestockId = sizestockId;
    }

    @Basic
    @Column(name = "sizestock_S_Stock", nullable = false)
    public int getSizestockSStock() {
        return sizestockSStock;
    }

    public void setSizestockSStock(int sizestockSStock) {
        this.sizestockSStock = sizestockSStock;
    }

    @Basic
    @Column(name = "sizestock_M_Stock", nullable = false)
    public int getSizestockMStock() {
        return sizestockMStock;
    }

    public void setSizestockMStock(int sizestockMStock) {
        this.sizestockMStock = sizestockMStock;
    }

    @Basic
    @Column(name = "sizestock_L_Stock", nullable = false)
    public int getSizestockLStock() {
        return sizestockLStock;
    }

    public void setSizestockLStock(int sizestockLStock) {
        this.sizestockLStock = sizestockLStock;
    }

    @Basic
    @Column(name = "sizestock_XL_Stock", nullable = false)
    public int getSizestockXlStock() {
        return sizestockXlStock;
    }

    public void setSizestockXlStock(int sizestockXlStock) {
        this.sizestockXlStock = sizestockXlStock;
    }

    @Basic
    @Column(name = "sizestock_XXL_Stock", nullable = false)
    public int getSizestockXxlStock() {
        return sizestockXxlStock;
    }

    public void setSizestockXxlStock(int sizestockXxlStock) {
        this.sizestockXxlStock = sizestockXxlStock;
    }

    @Basic
    @Column(name = "sizestock_XXXL_Stock", nullable = false)
    public int getSizestockXxxlStock() {
        return sizestockXxxlStock;
    }

    public void setSizestockXxxlStock(int sizestockXxxlStock) {
        this.sizestockXxxlStock = sizestockXxxlStock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tbsizestock that = (Tbsizestock) o;
        return sizestockId == that.sizestockId &&
                sizestockSStock == that.sizestockSStock &&
                sizestockMStock == that.sizestockMStock &&
                sizestockLStock == that.sizestockLStock &&
                sizestockXlStock == that.sizestockXlStock &&
                sizestockXxlStock == that.sizestockXxlStock &&
                sizestockXxxlStock == that.sizestockXxxlStock;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sizestockId, sizestockSStock, sizestockMStock, sizestockLStock, sizestockXlStock, sizestockXxlStock, sizestockXxxlStock);
    }

    @ManyToOne
    @JoinColumn(name = "tbitem_item_id", referencedColumnName = "item_id", nullable = false)
    public Tbitem getTbitemByTbitemItemId() {
        return tbitemByTbitemItemId;
    }

    public void setTbitemByTbitemItemId(Tbitem tbitemByTbitemItemId) {
        this.tbitemByTbitemItemId = tbitemByTbitemItemId;
    }
}
