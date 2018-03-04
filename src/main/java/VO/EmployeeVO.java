package VO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "employee")
public class EmployeeVO implements Serializable {
    public enum WorkingStatus{CURRENT,EX};
    public enum Designation{HEAD,SENIOR,JUNIOR}

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "employee_name",nullable = false)
    private String EmployeeName;

    @Enumerated(EnumType.STRING)
    @Column(name = "designation",nullable = false)
    private Designation Designation;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth")
    private Date date;

    @Column(name = "contact_number_one",nullable = false,unique = true)
    private String ContactNumberOne;

    @Column(name = "conatact_number_two",unique = true)
    private String ContactNumberTwo;

    @Column(name = "address",nullable = false)
    private String Address;

    @Column(name ="city",nullable = false)
    private String City;

    @Column(name = "state",nullable = false)
    private String State;

    @Column(name = "aadhaar_no",nullable = false,unique = true)
    private String AadhaarNo;

    @Temporal(TemporalType.DATE)
    @Column(name = "joining_date",nullable = false)
    private Date JoiningDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "leaving_date")
    private Date LeavingDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "current_status",nullable = false)
    private WorkingStatus CurrentStatus;

    @OneToOne
    @JoinColumn(name = "outlet_id")
    private OutletVO outletVO;

    @OneToOne
    @JoinColumn(name = "company_id")
    private CompanyVO companyVO;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Working_Employee", joinColumns = { @JoinColumn(name = "id") } , inverseJoinColumns = { @JoinColumn(name = "department_id") })
    private List<DepartmentVO> departmentVO;

    @OneToOne
    @JoinColumn(name = "salary_id")
    private SalaryVO salaryVO;

    public EmployeeVO() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public EmployeeVO.Designation getDesignation() {
        return Designation;
    }

    public void setDesignation(EmployeeVO.Designation designation) {
        Designation = designation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContactNumberOne() {
        return ContactNumberOne;
    }

    public void setContactNumberOne(String contactNumberOne) {
        ContactNumberOne = contactNumberOne;
    }

    public String getContactNumberTwo() {
        return ContactNumberTwo;
    }

    public void setContactNumberTwo(String contactNumberTwo) {
        ContactNumberTwo = contactNumberTwo;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getAadhaarNo() {
        return AadhaarNo;
    }

    public void setAadhaarNo(String aadhaarNo) {
        AadhaarNo = aadhaarNo;
    }

    public Date getJoiningDate() {
        return JoiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        JoiningDate = joiningDate;
    }

    public Date getLeavingDate() {
        return LeavingDate;
    }

    public void setLeavingDate(Date leavingDate) {
        LeavingDate = leavingDate;
    }

    public WorkingStatus getCurrentStatus() {
        return CurrentStatus;
    }

    public void setCurrentStatus(WorkingStatus currentStatus) {
        CurrentStatus = currentStatus;
    }

    public OutletVO getOutletVO() {
        return outletVO;
    }

    public void setOutletVO(OutletVO outletVO) {
        this.outletVO = outletVO;
    }

    public CompanyVO getComanyVO() {
        return companyVO;
    }

    public void setComanyVO(CompanyVO comanyVO) {
        this.companyVO = comanyVO;
    }

    public List<DepartmentVO> getDepartmentVO() {
        return departmentVO;
    }

    public void setDepartmentVO(List<DepartmentVO> departmentVO) {
        this.departmentVO = departmentVO;
    }

    public SalaryVO getSalaryVO() {
        return salaryVO;
    }

    public void setSalaryVO(SalaryVO salaryVO) {
        this.salaryVO = salaryVO;
    }

    @Override
    public String toString() {
        return "EmployeeVO{" +
                "id=" + id +
                ", EmployeeName='" + EmployeeName + '\'' +
                ", Designation=" + Designation +
                ", date=" + date +
                ", ContactNumberOne='" + ContactNumberOne + '\'' +
                ", ContactNumberTwo='" + ContactNumberTwo + '\'' +
                ", Address='" + Address + '\'' +
                ", City='" + City + '\'' +
                ", State='" + State + '\'' +
                ", AadhaarNo='" + AadhaarNo + '\'' +
                ", JoiningDate=" + JoiningDate +
                ", LeavingDate=" + LeavingDate +
                ", CurrentStatus=" + CurrentStatus +
                ", outletVO=" + outletVO +
                ", comanyVO=" + companyVO +
                ", departmentVO=" + departmentVO +
                ", salaryVO=" + salaryVO +
                '}';
    }
}
