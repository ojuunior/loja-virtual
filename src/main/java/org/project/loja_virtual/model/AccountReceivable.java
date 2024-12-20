package org.project.loja_virtual.model;

import org.project.loja_virtual.enums.AccountReceivableType;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNT_RECEIVABLE")
@SequenceGenerator(name = "SEQ_ACCOUNT_RECEIVABLE", sequenceName = "SEQ_ACCOUNT_RECEIVABLE", allocationSize = 1, initialValue = 1)
public class AccountReceivable implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ACCOUNT_RECEIVABLE")
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountReceivableType accountReceivableType;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dueDate;

    @Temporal(TemporalType.DATE)
    private Date paymentDate;

    @Column(nullable = false)
    private BigDecimal totalValue;

    private BigDecimal discountValue;

    @ManyToOne(targetEntity = Person.class)
    @JoinColumn(name = "person_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_PERSON"))
    private Person person;

    @ManyToOne(targetEntity = Person.class)
    @JoinColumn(name = "ENTERPRISE_ID", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_ENTERPRISE_ID"))
    private Person enterprise;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AccountReceivableType getAccountReceivableType() {
        return accountReceivableType;
    }

    public void setAccountReceivableType(AccountReceivableType accountReceivableType) {
        this.accountReceivableType = accountReceivableType;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public BigDecimal getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(BigDecimal discountValue) {
        this.discountValue = discountValue;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Person enterprise) {
        this.enterprise = enterprise;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        AccountReceivable that = (AccountReceivable) object;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
