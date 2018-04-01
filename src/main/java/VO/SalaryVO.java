package VO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "salary")
public class SalaryVO implements Serializable {
    public enum Position {HEAD, SENIOR, JUNIOR}

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "salary_name",nullable = false)
    private String salaryName;

    @Column(name = "basic_pay", nullable = false)
    private double basicPay;

    @Column(name = "cost_to_company", nullable = false)
    private double costToCompany;

    @Enumerated(EnumType.STRING)
    @Column(name = "salary_level", nullable = false)
    private Position salaryLevel;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyVO comanyVO;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentVO departmentVO;

    public SalaryVO() {
    }

    public SalaryVO(String salaryName, double basicPay, double costToCompany, Position salaryLevel, CompanyVO comanyVO, DepartmentVO departmentVO) {
        this.salaryName = salaryName;
        this.basicPay = basicPay;
        this.costToCompany = costToCompany;
        this.salaryLevel = salaryLevel;
        this.comanyVO = comanyVO;
        this.departmentVO = departmentVO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSalaryName() {
        return salaryName;
    }

    public void setSalaryName(String salaryName) {
        this.salaryName = salaryName;
    }

    public double getBasicPay() {
        return basicPay;
    }

    public void setBasicPay(double basicPay) {
        this.basicPay = basicPay;
    }

    public double getCostToCompany() {
        return costToCompany;
    }

    public void setCostToCompany(double costToCompany) {
        this.costToCompany = costToCompany;
    }

    public Position getSalaryLevel() {
        return salaryLevel;
    }

    public void setSalaryLevel(Position salaryLevel) {
        this.salaryLevel = salaryLevel;
    }

    public CompanyVO getComanyVO() {
        return comanyVO;
    }

    public void setComanyVO(CompanyVO comanyVO) {
        this.comanyVO = comanyVO;
    }

    public DepartmentVO getDepartmentVO() {
        return departmentVO;
    }

    public void setDepartmentVO(DepartmentVO departmentVO) {
        this.departmentVO = departmentVO;
    }

    @Override
    public String toString() {
        return "SalaryVO{" +
                "id=" + id +
                ", salaryName='" + salaryName + '\'' +
                ", basicPay=" + basicPay +
                ", costToCompany=" + costToCompany +
                ", salaryLevel=" + salaryLevel +
                ", comanyVO=" + comanyVO +
                ", departmentVO=" + departmentVO +
                '}';
    }
}