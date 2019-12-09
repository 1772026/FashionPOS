package fashionPOS.Model.Entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Tbtransaction {
    private int transactionId;
    private Date transactionDate;
    private int transactionStatus;
    private int transactionTotalprice;
    private String transactionPaymenttype;
    private Tbcustomer tbcustomerByTbcustomerCustomerId;
    private Tbitem tbitemByTbitemItemId;
    private Tbuser tbuserByTbuserUserId;

    @Id
    @Column(name = "transaction_id", nullable = false)
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    @Basic
    @Column(name = "transaction_date", nullable = false)
    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Basic
    @Column(name = "transaction_status", nullable = false)
    public int getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(int transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    @Basic
    @Column(name = "transaction_totalprice", nullable = false)
    public int getTransactionTotalprice() {
        return transactionTotalprice;
    }

    public void setTransactionTotalprice(int transactionTotalprice) {
        this.transactionTotalprice = transactionTotalprice;
    }

    @Basic
    @Column(name = "transaction_paymenttype", nullable = false, length = 100)
    public String getTransactionPaymenttype() {
        return transactionPaymenttype;
    }

    public void setTransactionPaymenttype(String transactionPaymenttype) {
        this.transactionPaymenttype = transactionPaymenttype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tbtransaction that = (Tbtransaction) o;
        return transactionId == that.transactionId &&
                transactionStatus == that.transactionStatus &&
                transactionTotalprice == that.transactionTotalprice &&
                Objects.equals(transactionDate, that.transactionDate) &&
                Objects.equals(transactionPaymenttype, that.transactionPaymenttype);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, transactionDate, transactionStatus, transactionTotalprice, transactionPaymenttype);
    }

    @ManyToOne
    @JoinColumn(name = "tbcustomer_customer_id", referencedColumnName = "customer_id", nullable = false)
    public Tbcustomer getTbcustomerByTbcustomerCustomerId() {
        return tbcustomerByTbcustomerCustomerId;
    }

    public void setTbcustomerByTbcustomerCustomerId(Tbcustomer tbcustomerByTbcustomerCustomerId) {
        this.tbcustomerByTbcustomerCustomerId = tbcustomerByTbcustomerCustomerId;
    }

    @ManyToOne
    @JoinColumn(name = "tbitem_item_id", referencedColumnName = "item_id", nullable = false)
    public Tbitem getTbitemByTbitemItemId() {
        return tbitemByTbitemItemId;
    }

    public void setTbitemByTbitemItemId(Tbitem tbitemByTbitemItemId) {
        this.tbitemByTbitemItemId = tbitemByTbitemItemId;
    }

    @ManyToOne
    @JoinColumn(name = "tbuser_user_id", referencedColumnName = "user_id", nullable = false)
    public Tbuser getTbuserByTbuserUserId() {
        return tbuserByTbuserUserId;
    }

    public void setTbuserByTbuserUserId(Tbuser tbuserByTbuserUserId) {
        this.tbuserByTbuserUserId = tbuserByTbuserUserId;
    }
}
