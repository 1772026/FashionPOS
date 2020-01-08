package fashionPOS.Model.Entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Tbtransaction {
    private int transactionId;
    private Date transactionDate;
    private Integer transactionStatus;
    private Integer transactionTotalprice;
    private String transactionPaymenttype;
    private Integer qty;
    private Integer transactionReturStatus;
    private Tbcustomer tbcustomerByTbcustomerCustomerId;
    private Tbitem tbitemByTbitemItemId;
    private Tbuser tbuserByTbuserUserId;
    private Tbretur tbreturByTbReturReturId;

    @Id
    @Column(name = "transaction_id", nullable = false)
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    @Basic
    @Column(name = "transaction_date", nullable = true)
    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Basic
    @Column(name = "transaction_status", nullable = true)
    public Integer getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(Integer transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    @Basic
    @Column(name = "transaction_totalprice", nullable = true)
    public Integer getTransactionTotalprice() {
        return transactionTotalprice;
    }

    public void setTransactionTotalprice(Integer transactionTotalprice) {
        this.transactionTotalprice = transactionTotalprice;
    }

    @Basic
    @Column(name = "transaction_paymenttype", nullable = true, length = 100)
    public String getTransactionPaymenttype() {
        return transactionPaymenttype;
    }

    public void setTransactionPaymenttype(String transactionPaymenttype) {
        this.transactionPaymenttype = transactionPaymenttype;
    }

    @Basic
    @Column(name = "qty", nullable = true)
    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    @Basic
    @Column(name = "transaction_retur_status", nullable = true)
    public Integer getTransactionReturStatus() {
        return transactionReturStatus;
    }

    public void setTransactionReturStatus(Integer transactionReturStatus) {
        this.transactionReturStatus = transactionReturStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tbtransaction that = (Tbtransaction) o;
        return transactionId == that.transactionId &&
                Objects.equals(transactionDate, that.transactionDate) &&
                Objects.equals(transactionStatus, that.transactionStatus) &&
                Objects.equals(transactionTotalprice, that.transactionTotalprice) &&
                Objects.equals(transactionPaymenttype, that.transactionPaymenttype) &&
                Objects.equals(qty, that.qty) &&
                Objects.equals(transactionReturStatus, that.transactionReturStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, transactionDate, transactionStatus, transactionTotalprice, transactionPaymenttype, qty, transactionReturStatus);
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

    @ManyToOne
    @JoinColumn(name = "tbRetur_retur_id", referencedColumnName = "retur_id", nullable = false)
    public Tbretur getTbreturByTbReturReturId() {
        return tbreturByTbReturReturId;
    }

    public void setTbreturByTbReturReturId(Tbretur tbreturByTbReturReturId) {
        this.tbreturByTbReturReturId = tbreturByTbReturReturId;
    }
}
