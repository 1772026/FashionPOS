package fashionPOS.Model.Entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Tbcustomer {
    private Integer id;
    private String name;
    private String address;
    private String telp;
    private String email;
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
    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "address", nullable = false, length = 200)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "telp", nullable = false, length = 20)
    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tbcustomer that = (Tbcustomer) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(address, that.address) &&
                Objects.equals(telp, that.telp) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, telp, email);
    }

    @OneToMany(mappedBy = "tbcustomerByTbcustomerId")
    public Collection<Tbtransaction> getTbtransactionsById() {
        return tbtransactionsById;
    }

    public void setTbtransactionsById(Collection<Tbtransaction> tbtransactionsById) {
        this.tbtransactionsById = tbtransactionsById;
    }
}
