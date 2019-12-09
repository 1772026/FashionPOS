package fashionPOS.Model.Entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Tbcustomer {
    private int customerId;
    private String customerName;
    private String customerAddress;
    private String customerTelp;
    private String customerEmail;
    private Collection<Tbtransaction> tbtransactionsByCustomerId;

    @Id
    @Column(name = "customer_id", nullable = false)
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "customer_name", nullable = false, length = 100)
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Basic
    @Column(name = "customer_address", nullable = false, length = 200)
    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    @Basic
    @Column(name = "customer_telp", nullable = false, length = 20)
    public String getCustomerTelp() {
        return customerTelp;
    }

    public void setCustomerTelp(String customerTelp) {
        this.customerTelp = customerTelp;
    }

    @Basic
    @Column(name = "customer_email", nullable = false, length = 100)
    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tbcustomer that = (Tbcustomer) o;
        return customerId == that.customerId &&
                Objects.equals(customerName, that.customerName) &&
                Objects.equals(customerAddress, that.customerAddress) &&
                Objects.equals(customerTelp, that.customerTelp) &&
                Objects.equals(customerEmail, that.customerEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, customerName, customerAddress, customerTelp, customerEmail);
    }

    @OneToMany(mappedBy = "tbcustomerByTbcustomerCustomerId")
    public Collection<Tbtransaction> getTbtransactionsByCustomerId() {
        return tbtransactionsByCustomerId;
    }

    public void setTbtransactionsByCustomerId(Collection<Tbtransaction> tbtransactionsByCustomerId) {
        this.tbtransactionsByCustomerId = tbtransactionsByCustomerId;
    }
}
