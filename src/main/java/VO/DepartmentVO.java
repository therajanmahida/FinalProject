package VO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "department")
public class DepartmentVO implements Serializable {

    @Id
    @Column(name = "department_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "department_name",nullable = false)
    private String DepartmentName;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyVO companyVO;

    public DepartmentVO() {

    }

    public DepartmentVO(String departmentName, CompanyVO comanyVO) {
        DepartmentName = departmentName;
        this.companyVO = comanyVO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }

    public CompanyVO getComanyVO() {
        return companyVO;
    }

    public void setComanyVO(CompanyVO comanyVO) {
        this.companyVO = comanyVO;
    }
}
