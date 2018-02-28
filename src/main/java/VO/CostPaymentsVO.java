package VO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "cost_payment")
public class CostPaymentsVO implements Serializable{

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "payment_name",nullable = false)
    private String PaymentName;

    @Column(name = "payment_to",nullable = false)
    private String PaymentTo;

    @Column(name = "payment_from")
    private String PaymentFrom;

    @Column(name = "payment_amount",nullable = false)
    private double PaymentAmount;

    @Column(name = "payment_date",nullable = false)
    private Date PaymentDate;

    @OneToOne
    @JoinColumn(name = "company_id")
    private CompanyVO companyVO;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private EmployeeVO employeeVO;

    public CostPaymentsVO() {

    }

    public CostPaymentsVO(String paymentName, String paymentTo, double paymentAmount, Date paymentDate, CompanyVO companyVO, EmployeeVO employeeVO) {
        PaymentName = paymentName;
        PaymentTo = paymentTo;
        PaymentAmount = paymentAmount;
        PaymentDate = paymentDate;
        this.companyVO = companyVO;
        this.employeeVO = employeeVO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaymentName() {
        return PaymentName;
    }

    public void setPaymentName(String paymentName) {
        PaymentName = paymentName;
    }

    public String getPaymentTo() {
        return PaymentTo;
    }

    public void setPaymentTo(String paymentTo) {
        PaymentTo = paymentTo;
    }

    public double getPaymentAmount() {
        return PaymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        PaymentAmount = paymentAmount;
    }

    public Date getPaymentDate() {
        return PaymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        PaymentDate = paymentDate;
    }

    public CompanyVO getCompanyVO() {
        return companyVO;
    }

    public void setCompanyVO(CompanyVO companyVO) {
        this.companyVO = companyVO;
    }

    public EmployeeVO getEmployeeVO() {
        return employeeVO;
    }

    public void setEmployeeVO(EmployeeVO employeeVO) {
        this.employeeVO = employeeVO;
    }
}
