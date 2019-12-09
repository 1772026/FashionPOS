package fashionPOS.Model.Entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Tbitem {
    private int itemId;
    private String itemName;
    private int itemPriceSell;
    private int itemPriceSupply;
    private String itemDescription;
    private Tbcategory tbcategoryByTbcategoryCategoryId;
    private Collection<Tbsizestock> tbsizestocksByItemId;
    private Collection<Tbtransaction> tbtransactionsByItemId;

    @Id
    @Column(name = "item_id", nullable = false)
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "item_name", nullable = false, length = 50)
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Basic
    @Column(name = "item_price_sell", nullable = false)
    public int getItemPriceSell() {
        return itemPriceSell;
    }

    public void setItemPriceSell(int itemPriceSell) {
        this.itemPriceSell = itemPriceSell;
    }

    @Basic
    @Column(name = "item_price_supply", nullable = false)
    public int getItemPriceSupply() {
        return itemPriceSupply;
    }

    public void setItemPriceSupply(int itemPriceSupply) {
        this.itemPriceSupply = itemPriceSupply;
    }

    @Basic
    @Column(name = "item_description", nullable = false, length = 1000)
    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tbitem tbitem = (Tbitem) o;
        return itemId == tbitem.itemId &&
                itemPriceSell == tbitem.itemPriceSell &&
                itemPriceSupply == tbitem.itemPriceSupply &&
                Objects.equals(itemName, tbitem.itemName) &&
                Objects.equals(itemDescription, tbitem.itemDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, itemName, itemPriceSell, itemPriceSupply, itemDescription);
    }

    @ManyToOne
    @JoinColumn(name = "tbcategory_category_Id", referencedColumnName = "category_Id", nullable = false)
    public Tbcategory getTbcategoryByTbcategoryCategoryId() {
        return tbcategoryByTbcategoryCategoryId;
    }

    public void setTbcategoryByTbcategoryCategoryId(Tbcategory tbcategoryByTbcategoryCategoryId) {
        this.tbcategoryByTbcategoryCategoryId = tbcategoryByTbcategoryCategoryId;
    }

    @OneToMany(mappedBy = "tbitemByTbitemItemId")
    public Collection<Tbsizestock> getTbsizestocksByItemId() {
        return tbsizestocksByItemId;
    }

    public void setTbsizestocksByItemId(Collection<Tbsizestock> tbsizestocksByItemId) {
        this.tbsizestocksByItemId = tbsizestocksByItemId;
    }

    @OneToMany(mappedBy = "tbitemByTbitemItemId")
    public Collection<Tbtransaction> getTbtransactionsByItemId() {
        return tbtransactionsByItemId;
    }

    public void setTbtransactionsByItemId(Collection<Tbtransaction> tbtransactionsByItemId) {
        this.tbtransactionsByItemId = tbtransactionsByItemId;
    }
}
