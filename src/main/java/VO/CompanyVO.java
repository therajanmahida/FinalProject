package VO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "company")
public class CompanyVO implements Serializable{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "company_name",nullable = false,unique = true)
    private String CompanyName;

    @Temporal(TemporalType.DATE)
    @Column(name = "established_date")
    private Date EstablishedDate;

    @Column(name = "gstin_number",nullable = false,unique = true)
    private String GstNumber;

    @Column(name ="contact_no_one",nullable = false,unique = true)
    private String ContactNumberOne;

    @Column(name ="contact_no_two",unique = true)
    private String ContactNumberTwo;

    @Column(name ="email_id",nullable = false,unique = true)
    private String EmailId;

    @Column(name = "total_cash",nullable = false)
    private double TotalCash;

    public CompanyVO() {
    }

    public CompanyVO(String companyName, Date establishedDate, String gstNumber, String contactNumberOne, String contactNumberTwo, String emailId, double totalCash) {
        CompanyName = companyName;
        EstablishedDate = establishedDate;
        GstNumber = gstNumber;
        ContactNumberOne = contactNumberOne;
        ContactNumberTwo = contactNumberTwo;
        EmailId = emailId;
        TotalCash = totalCash;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public Date getEstablishedDate() {
        return EstablishedDate;
    }

    public void setEstablishedDate(Date establishedDate) {
        EstablishedDate = establishedDate;
    }

    public String getGstNumber() {
        return GstNumber;
    }

    public void setGstNumber(String gstNumber) {
        GstNumber = gstNumber;
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

    public double getTotalCash() {
        return TotalCash;
    }

    public void setTotalCash(double totalCash) {
        TotalCash = totalCash;
    }
}
