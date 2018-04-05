package VO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "transaction")
public class TransactionVO implements Serializable{

    private enum PaymentType{COST_PAYMENT,SUPPLIER_PAYMENT,CLIENT_PAYMENT}

    @Id
    @Column(name = "id",nullable =  false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "payment_to",nullable = false)
    private String PaymentTo;

    @Column(name = "payment_from",nullable = false)
    private String PaymentFrom;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_Type",nullable = false)
    private PaymentType paymentType;

    @Column(name = "payment_amount",nullable = false)
    private double PaymentAmount;

    @Temporal(TemporalType.DATE)
    @Column(name = "payment_date",nullable = false)
    private Date PaymentDateTime;

    @OneToOne
    @JoinColumn(name = "company_id")
    private CompanyVO companyVO;

    public TransactionVO(String paymentTo, String paymentFrom, PaymentType paymentType, double paymentAmount, Date paymentDateTime, CompanyVO companyVO) {
        PaymentTo = paymentTo;
        PaymentFrom = paymentFrom;
        this.paymentType = paymentType;
        PaymentAmount = paymentAmount;
        PaymentDateTime = paymentDateTime;
        this.companyVO = companyVO;
    }

    public TransactionVO() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaymentTo() {
        return PaymentTo;
    }

    public void setPaymentTo(String paymentTo) {
        PaymentTo = paymentTo;
    }

    public String getPaymentFrom() {
        return PaymentFrom;
    }

    public void setPaymentFrom(String paymentFrom) {
        PaymentFrom = paymentFrom;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public double getPaymentAmount() {
        return PaymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        PaymentAmount = paymentAmount;
    }

    public Date getPaymentDateTime() {
        return PaymentDateTime;
    }

    public void setPaymentDateTime(Date paymentDateTime) {
        PaymentDateTime = paymentDateTime;
    }

    public CompanyVO getCompanyVO() {
        return companyVO;
    }

    public void setCompanyVO(CompanyVO companyVO) {
        this.companyVO = companyVO;
    }
}
