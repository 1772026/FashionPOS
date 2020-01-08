package fashionPOS.Model.Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Tbretur {
    private int returId;
    private String returDescription;

    @Id
    @Column(name = "retur_id", nullable = false)
    public int getReturId() {
        return returId;
    }

    public void setReturId(int returId) {
        this.returId = returId;
    }

    @Basic
    @Column(name = "retur_description", nullable = true, length = 500)
    public String getReturDescription() {
        return returDescription;
    }

    public void setReturDescription(String returDescription) {
        this.returDescription = returDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tbretur tbretur = (Tbretur) o;
        return returId == tbretur.returId &&
                Objects.equals(returDescription, tbretur.returDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(returId, returDescription);
    }
}
