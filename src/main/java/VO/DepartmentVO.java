package VO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "department")
public class DepartmentVO implements Serializable {

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "department_name",nullable = false,unique = true)
    private String DepartmentName;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyVO comanyVO;

    public DepartmentVO() {

    }

    public DepartmentVO(String departmentName, CompanyVO comanyVO) {
        DepartmentName = departmentName;
        this.comanyVO = comanyVO;
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
        return comanyVO;
    }

    public void setComanyVO(CompanyVO comanyVO) {
        this.comanyVO = comanyVO;
    }
}
