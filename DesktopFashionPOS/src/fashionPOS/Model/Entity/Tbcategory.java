package fashionPOS.Model.Entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Tbcategory {
    private int categoryId;
    private String categoryType;
    private Collection<Tbitem> tbitemsByCategoryId;

    @Id
    @Column(name = "category_Id", nullable = false)
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "category_type", nullable = false, length = 30)
    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tbcategory that = (Tbcategory) o;
        return categoryId == that.categoryId &&
                Objects.equals(categoryType, that.categoryType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, categoryType);
    }

    @OneToMany(mappedBy = "tbcategoryByTbcategoryCategoryId")
    public Collection<Tbitem> getTbitemsByCategoryId() {
        return tbitemsByCategoryId;
    }

    public void setTbitemsByCategoryId(Collection<Tbitem> tbitemsByCategoryId) {
        this.tbitemsByCategoryId = tbitemsByCategoryId;
    }
}
