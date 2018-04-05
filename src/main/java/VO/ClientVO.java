package VO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "client")
public class ClientVO implements Serializable {

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="client_name",nullable = false)
    private String ClientName;

    @Column(name = "gst_number",nullable = false)
    private String GSTInNumber;

    @Column(name = "contact_number_one",nullable = false)
    private String ContactNumberOne;

    @Column(name = "contact_number_two")
    private String ContactNumberTwo;

    @Column(name = "email_id",nullable = false)
    private String EmailId;

    @Column(name = "address",nullable = false)
    private String Address;

    @Column(name = "city",nullable = false)
    private String City;

    @Column(name = "state",nullable = false)
    private String State;

    @ManyToOne
    @JoinColumn(name ="company_id")
    private CompanyVO companyVO;

    public ClientVO() {

    }

    public ClientVO(String clientName, String GSTInNumber, String contactNumberOne, String contactNumberTwo, String emailId, String address, String city, String state, CompanyVO companyVO) {
        ClientName = clientName;
        this.GSTInNumber = GSTInNumber;
        ContactNumberOne = contactNumberOne;
        ContactNumberTwo = contactNumberTwo;
        EmailId = emailId;
        Address = address;
        City = city;
        State = state;
        this.companyVO = companyVO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String clientName) {
        ClientName = clientName;
    }

    public String getGSTInNumber() {
        return GSTInNumber;
    }

    public void setGSTInNumber(String GSTInNumber) {
        this.GSTInNumber = GSTInNumber;
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

    public String getEmailId() {
        return EmailId;
    }

    public void setEmailId(String emailId) {
        EmailId = emailId;
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

    public CompanyVO getCompanyVO() {
        return companyVO;
    }

    public void setCompanyVO(CompanyVO companyVO) {
        this.companyVO = companyVO;
    }
}
