package VO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "client_order")
public class ClientOrderVO implements Serializable {

    private enum PaymentStatus{DONE,AWAITING}

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    @Column(name ="order_date",nullable = false)
    private Date OrderDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "dispatch_date")
    private Date DispatchDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "delivery_date")
    private Date DeliveryDate;

    @Enumerated(EnumType.STRING)
    @Column(name="payment_status")
    private PaymentStatus paymentStatus;

    @Column(name = "sell_amount",nullable = false)
    private double SellAmount;

    @Column(name = "tax_amount",nullable = false)
    private double TaxAmount;

    @Column(name = "profit_margin",nullable = false)
    private double ProfitMargin;

    @OneToOne
    @JoinColumn(name = "client_id")
    private ClientVO clientVO;

    @OneToOne
    @JoinColumn(name = "company_id")
    private CompanyVO companyVO;

    public ClientOrderVO() {
    }

    public ClientOrderVO(Date orderDate, Date dispatchDate, Date deliveryDate, PaymentStatus paymentStatus, double sellAmount, double taxAmount, double profitMargin, ClientVO clientVO, CompanyVO companyVO) {
        OrderDate = orderDate;
        DispatchDate = dispatchDate;
        DeliveryDate = deliveryDate;
        this.paymentStatus = paymentStatus;
        SellAmount = sellAmount;
        TaxAmount = taxAmount;
        ProfitMargin = profitMargin;
        this.clientVO = clientVO;
        this.companyVO = companyVO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(Date orderDate) {
        OrderDate = orderDate;
    }

    public Date getDispatchDate() {
        return DispatchDate;
    }

    public void setDispatchDate(Date dispatchDate) {
        DispatchDate = dispatchDate;
    }

    public Date getDeliveryDate() {
        return DeliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        DeliveryDate = deliveryDate;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public double getSellAmount() {
        return SellAmount;
    }

    public void setSellAmount(double sellAmount) {
        SellAmount = sellAmount;
    }

    public double getTaxAmount() {
        return TaxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        TaxAmount = taxAmount;
    }

    public double getProfitMargin() {
        return ProfitMargin;
    }

    public void setProfitMargin(double profitMargin) {
        ProfitMargin = profitMargin;
    }

    public ClientVO getClientVO() {
        return clientVO;
    }

    public void setClientVO(ClientVO clientVO) {
        this.clientVO = clientVO;
    }

    public CompanyVO getCompanyVO() {
        return companyVO;
    }

    public void setCompanyVO(CompanyVO companyVO) {
        this.companyVO = companyVO;
    }
}
