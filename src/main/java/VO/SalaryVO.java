package VO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "salary")
public class SalaryVO implements Serializable {
    private enum Position{HEAD,SENIOR,JUNIOR}

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "basic_pay",nullable = false)
    private double BasicPay;

    @Column(name = "cost_to_company",nullable = false)
    private double CostToCompany;

    @Enumerated(EnumType.STRING)
    @Column(name = "salary_level",nullable = false)
    private Position SalaryLevel;

    @ManyToOne
    @JoinColumn(name="company_id")
    private CompanyVO comanyVO;

    @ManyToOne
    @JoinColumn(name="department_id")
    private DepartmentVO departmentVO;

    public SalaryVO() {
    }

    public SalaryVO(double basicPay, double costToCompany, Position salaryLevel, CompanyVO comanyVO, DepartmentVO departmentVO) {
        BasicPay = basicPay;
        CostToCompany = costToCompany;
        SalaryLevel = salaryLevel;
        this.comanyVO = comanyVO;
        this.departmentVO = departmentVO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBasicPay() {
        return BasicPay;
    }

    public void setBasicPay(double basicPay) {
        BasicPay = basicPay;
    }

    public double getCostToCompany() {
        return CostToCompany;
    }

    public void setCostToCompany(double costToCompany) {
        CostToCompany = costToCompany;
    }

    public Position getSalaryLevel() {
        return SalaryLevel;
    }

    public void setSalaryLevel(Position salaryLevel) {
        SalaryLevel = salaryLevel;
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
}
