package VO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "department")
public class DepartmentVO implements Serializable {

    @Id
    @Column(name = "department_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "department_name", nullable = false)
    private String departmentName;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyVO companyVO;

    public DepartmentVO() {

    }

    public DepartmentVO(String departmentName, CompanyVO companyVO) {
        this.departmentName = departmentName;
        this.companyVO = companyVO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public CompanyVO getCompanyVO() {
        return companyVO;
    }

    public void setCompanyVO(CompanyVO companyVO) {
        this.companyVO = companyVO;
    }
}