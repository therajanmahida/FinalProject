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
    private String employeeName;

    @Enumerated(EnumType.STRING)
    @Column(name = "designation",nullable = false)
    private Designation designation;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth")
    private Date date;

    @Column(name = "contact_number_one",nullable = false)
    private String contactNumberOne;

    @Column(name = "conatact_number_two")
    private String contactNumberTwo;

    @Column(name = "address",nullable = false)
    private String address;

    @Column(name ="city",nullable = false)
    private String city;

    @Column(name = "state",nullable = false)
    private String state;

    @Column(name = "aadhaar_no",nullable = false)
    private String aadhaarNo;

    @Temporal(TemporalType.DATE)
    @Column(name = "joining_date",nullable = false)
    private Date joiningDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "leaving_date")
    private Date leavingDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "current_status",nullable = false)
    private WorkingStatus currentStatus;

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

    public EmployeeVO(String employeeName, Designation designation, Date date, String contactNumberOne, String contactNumberTwo, String address, String city, String state, String aadhaarNo, Date joiningDate, Date leavingDate, WorkingStatus currentStatus, OutletVO outletVO, CompanyVO companyVO, List<DepartmentVO> departmentVO, SalaryVO salaryVO) {
        this.employeeName = employeeName;
        this.designation = designation;
        this.date = date;
        this.contactNumberOne = contactNumberOne;
        this.contactNumberTwo = contactNumberTwo;
        this.address = address;
        this.city = city;
        this.state = state;
        this.aadhaarNo = aadhaarNo;
        this.joiningDate = joiningDate;
        this.leavingDate = leavingDate;
        this.currentStatus = currentStatus;
        this.outletVO = outletVO;
        this.companyVO = companyVO;
        this.departmentVO = departmentVO;
        this.salaryVO = salaryVO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContactNumberOne() {
        return contactNumberOne;
    }

    public void setContactNumberOne(String contactNumberOne) {
        this.contactNumberOne = contactNumberOne;
    }

    public String getContactNumberTwo() {
        return contactNumberTwo;
    }

    public void setContactNumberTwo(String contactNumberTwo) {
        this.contactNumberTwo = contactNumberTwo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAadhaarNo() {
        return aadhaarNo;
    }

    public void setAadhaarNo(String aadhaarNo) {
        this.aadhaarNo = aadhaarNo;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Date getLeavingDate() {
        return leavingDate;
    }

    public void setLeavingDate(Date leavingDate) {
        this.leavingDate = leavingDate;
    }

    public WorkingStatus getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(WorkingStatus currentStatus) {
        this.currentStatus = currentStatus;
    }

    public OutletVO getOutletVO() {
        return outletVO;
    }

    public void setOutletVO(OutletVO outletVO) {
        this.outletVO = outletVO;
    }

    public CompanyVO getCompanyVO() {
        return companyVO;
    }

    public void setCompanyVO(CompanyVO companyVO) {
        this.companyVO = companyVO;
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
                ", employeeName='" + employeeName + '\'' +
                ", designation=" + designation +
                ", date=" + date +
                ", contactNumberOne='" + contactNumberOne + '\'' +
                ", contactNumberTwo='" + contactNumberTwo + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", aadhaarNo='" + aadhaarNo + '\'' +
                ", joiningDate=" + joiningDate +
                ", leavingDate=" + leavingDate +
                ", currentStatus=" + currentStatus +
                ", outletVO=" + outletVO +
                ", companyVO=" + companyVO +
                ", departmentVO=" + departmentVO +
                ", salaryVO=" + salaryVO +
                '}';
    }
}
