package VO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "employee")
public class EmployeeVO implements Serializable {
    private enum WorkingStatus{CURRENT,EX};

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "employee_name",nullable = false)
    private String EmployeeName;

    @Column(name = "designation",nullable = false)
    private String Designation;

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
    private CompanyVO comanyVO;

    @OneToMany
    @JoinColumn(name = "department_id")
    private Set<DepartmentVO> departmentVO;

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

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
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
        return comanyVO;
    }

    public void setComanyVO(CompanyVO comanyVO) {
        this.comanyVO = comanyVO;
    }

    public Set<DepartmentVO> getDepartmentVO() {
        return departmentVO;
    }

    public void setDepartmentVO(Set<DepartmentVO> departmentVO) {
        this.departmentVO = departmentVO;
    }

    public SalaryVO getSalaryVO() {
        return salaryVO;
    }

    public void setSalaryVO(SalaryVO salaryVO) {
        this.salaryVO = salaryVO;
    }

    public EmployeeVO(String employeeName, String designation, Date date, String contactNumberOne, String contactNumberTwo, String address, String city, String state, String aadhaarNo, Date joiningDate, Date leavingDate, WorkingStatus currentStatus, OutletVO outletVO, CompanyVO comanyVO, Set<DepartmentVO> departmentVO, SalaryVO salaryVO) {

        EmployeeName = employeeName;
        Designation = designation;
        this.date = date;
        ContactNumberOne = contactNumberOne;
        ContactNumberTwo = contactNumberTwo;
        Address = address;
        City = city;
        State = state;
        AadhaarNo = aadhaarNo;
        JoiningDate = joiningDate;
        LeavingDate = leavingDate;
        CurrentStatus = currentStatus;
        this.outletVO = outletVO;
        this.comanyVO = comanyVO;
        this.departmentVO = departmentVO;
        this.salaryVO = salaryVO;
    }
}
