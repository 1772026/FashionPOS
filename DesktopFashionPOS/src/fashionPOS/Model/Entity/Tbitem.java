package fashionPOS.Model.Entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Tbitem {
    private Integer id;
    private String name;
    private Integer stock;
    private Integer priceSell;
    private Integer priceSupply;
    private String description;
    private String size;
    private Collection<Tbtransaction> tbtransactionsById;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "stock", nullable = false)
    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Basic
    @Column(name = "price_sell", nullable = false)
    public Integer getPriceSell() {
        return priceSell;
    }

    public void setPriceSell(Integer priceSell) {
        this.priceSell = priceSell;
    }

    @Basic
    @Column(name = "price_supply", nullable = false)
    public Integer getPriceSupply() {
        return priceSupply;
    }

    public void setPriceSupply(Integer priceSupply) {
        this.priceSupply = priceSupply;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 1000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "size", nullable = false, length = 5)
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tbitem tbitem = (Tbitem) o;
        return Objects.equals(id, tbitem.id) &&
                Objects.equals(name, tbitem.name) &&
                Objects.equals(stock, tbitem.stock) &&
                Objects.equals(priceSell, tbitem.priceSell) &&
                Objects.equals(priceSupply, tbitem.priceSupply) &&
                Objects.equals(description, tbitem.description) &&
                Objects.equals(size, tbitem.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, stock, priceSell, priceSupply, description, size);
    }

    @OneToMany(mappedBy = "tbitemByTbitemId")
    public Collection<Tbtransaction> getTbtransactionsById() {
        return tbtransactionsById;
    }

    public void setTbtransactionsById(Collection<Tbtransaction> tbtransactionsById) {
        this.tbtransactionsById = tbtransactionsById;
    }
}
