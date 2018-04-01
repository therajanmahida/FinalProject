package VO;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;

@Entity
@Table(name = "supplier")
@OnDelete(action = OnDeleteAction.CASCADE)
public class SupplierVO implements Serializable {

    @Id
    @Column(name = "supplier_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "supplier_name",nullable = false,unique = true)
    private String supplierName;

    @Column(name = "gst_number",nullable = false,unique = true)
    private String gSTInNumber;

    @Column(name = "owner_name",nullable = false)
    private String ownerName;

    @Column(name = "email_id",nullable = false,unique = true)
    private String emailId;

    @Column(name = "contact_number_one",nullable = false,unique = true)
    private String contactNumberOne;

    @Column(name ="contact_number_two",unique = true)
    private String contactNumberTwo;

    @Column(name = "address",nullable = false)
    private String address;

    @Column(name = "city",nullable = false)
    private String city;

    @Column(name = "state",nullable = false)
    private String state;

    @ManyToOne
    @JoinColumn(name = "company_id",nullable = false)
    private CompanyVO companyVO;

    public SupplierVO() {

    }

    public SupplierVO(String supplierName, String gSTInNumber, String ownerName, String emailId, String contactNumberOne, String contactNumberTwo, String address, String city, String state, CompanyVO companyVO) {
        this.supplierName = supplierName;
        this.gSTInNumber = gSTInNumber;
        this.ownerName = ownerName;
        this.emailId = emailId;
        this.contactNumberOne = contactNumberOne;
        this.contactNumberTwo = contactNumberTwo;
        this.address = address;
        this.city = city;
        this.state = state;
        this.companyVO = companyVO;
    }

    @Override
    public String toString() {
        return "SupplierVO{" +
                "id=" + id +
                ", supplierName='" + supplierName + '\'' +
                ", gSTInNumber='" + gSTInNumber + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", contactNumberOne='" + contactNumberOne + '\'' +
                ", contactNumberTwo='" + contactNumberTwo + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", companyVO=" + companyVO +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getgSTInNumber() {
        return gSTInNumber;
    }

    public void setgSTInNumber(String gSTInNumber) {
        this.gSTInNumber = gSTInNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
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

    public CompanyVO getCompanyVO() {
        return companyVO;
    }

    public void setCompanyVO(CompanyVO companyVO) {
        this.companyVO = companyVO;
    }
}
