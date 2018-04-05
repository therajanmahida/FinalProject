package VO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "purchase_order")
public class PurchaseOrderVO implements Serializable {

    public  enum PurchaseRequest {AWAITING, PASSED, REJECTED}

    public  enum DeliveryStatus {DELIVERED, WAITING}

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    @Column(name = "purchase_date", nullable = false)
    private Date PurchaseDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "purchase_request", nullable = false)
    private PurchaseRequest purchaseRequest;

    @Temporal(TemporalType.DATE)
    @Column(name = "request_date", nullable = false)
    private Date RequestDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "delivery_status", nullable = false)
    private DeliveryStatus deliveryStatus;

    @Column(name = "purchase_amount", nullable = false)
    private double PurchaseAmount;

    @Column(name = "gst", nullable = false)
    private double GST;

    @ManyToOne
    @JoinColumn(name = "outlet_id")
    private OutletVO outletVO;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeVO employeeVO;

    @OneToOne
    @JoinColumn(name = "company_id")
    private CompanyVO companyVO;

    public PurchaseOrderVO() {

    }

    public PurchaseOrderVO(Date purchaseDate, PurchaseRequest purchaseRequest, Date requestDate, DeliveryStatus deliveryStatus, double purchaseAmount, double GST, OutletVO outletVO, EmployeeVO employeeVO, CompanyVO companyVO) {
        PurchaseDate = purchaseDate;
        this.purchaseRequest = purchaseRequest;
        RequestDate = requestDate;
        this.deliveryStatus = deliveryStatus;
        PurchaseAmount = purchaseAmount;
        this.GST = GST;
        this.outletVO = outletVO;
        this.employeeVO = employeeVO;
        this.companyVO = companyVO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPurchaseDate() {
        return PurchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        PurchaseDate = purchaseDate;
    }

    public PurchaseRequest getPurchaseRequest() {
        return purchaseRequest;
    }

    public void setPurchaseRequest(PurchaseRequest purchaseRequest) {
        this.purchaseRequest = purchaseRequest;
    }

    public Date getRequestDate() {
        return RequestDate;
    }

    public void setRequestDate(Date requestDate) {
        RequestDate = requestDate;
    }

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public double getPurchaseAmount() {
        return PurchaseAmount;
    }

    public void setPurchaseAmount(double purchaseAmount) {
        PurchaseAmount = purchaseAmount;
    }

    public double getGST() {
        return GST;
    }

    public void setGST(double GST) {
        this.GST = GST;
    }

    public OutletVO getOutletVO() {
        return outletVO;
    }

    public void setOutletVO(OutletVO outletVO) {
        this.outletVO = outletVO;
    }

    public EmployeeVO getEmployeeVO() {
        return employeeVO;
    }

    public void setEmployeeVO(EmployeeVO employeeVO) {
        this.employeeVO = employeeVO;
    }

    public CompanyVO getCompanyVO() {
        return companyVO;
    }

    public void setCompanyVO(CompanyVO companyVO) {
        this.companyVO = companyVO;
    }
}

