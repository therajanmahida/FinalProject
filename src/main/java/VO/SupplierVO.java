package VO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "supplier")
public class SupplierVO implements Serializable {

    @Id
    @Column(name = "supplier_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "supplier_name",nullable = false,unique = true)
    private String SupplierName;

    @Column(name = "gst_number",nullable = false,unique = true)
    private String GSTInNumber;

    @Column(name = "owner_name",nullable = false)
    private String OwnerName;

    @Column(name = "email_id",nullable = false,unique = true)
    private String EmailId;

    @Column(name = "contact_number_one",nullable = false,unique = true)
    private String ContactNumberOne;

    @Column(name ="contact_number_two",unique = true)
    private String ContactNumberTwo;

    @Column(name = "address",nullable = false)
    private String Address;

    @Column(name = "city",nullable = false)
    private String City;

    @Column(name = "state",nullable = false)
    private String State;

    @ManyToOne
    @JoinColumn(name = "company_id",nullable = false)
    private CompanyVO comanyVO;

    public SupplierVO() {

    }

    public SupplierVO(String supplierName, String GSTInNumber, String ownerName, String emailId, String contactNumberOne, String contactNumberTwo, String address, String city, String state, CompanyVO comanyVO) {
        SupplierName = supplierName;
        this.GSTInNumber = GSTInNumber;
        OwnerName = ownerName;
        EmailId = emailId;
        ContactNumberOne = contactNumberOne;
        ContactNumberTwo = contactNumberTwo;
        Address = address;
        City = city;
        State = state;
        this.comanyVO = comanyVO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public void setSupplierName(String supplierName) {
        SupplierName = supplierName;
    }

    public String getGSTInNumber() {
        return GSTInNumber;
    }

    public void setGSTInNumber(String GSTInNumber) {
        this.GSTInNumber = GSTInNumber;
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String ownerName) {
        OwnerName = ownerName;
    }

    public String getEmailId() {
        return EmailId;
    }

    public void setEmailId(String emailId) {
        EmailId = emailId;
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

    public CompanyVO getComanyVO() {
        return comanyVO;
    }

    public void setComanyVO(CompanyVO comanyVO) {
        this.comanyVO = comanyVO;
    }
}
