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
    private String companyName;

    @Temporal(TemporalType.DATE)
    @Column(name = "established_date")
    private Date establishedDate;

    @Column(name = "gstin_number",nullable = false,unique = true)
    private String gstNumber;

    @Column(name ="contact_no_one",nullable = false,unique = true)
    private String contactNumberOne;

    @Column(name ="contact_no_two",unique = true)
    private String contactNumberTwo;

    @Column(name ="email_id",nullable = false,unique = true)
    private String emailId;

    @Column(name = "total_cash",nullable = false)
    private double totalCash;

    public CompanyVO() {
    }

    public CompanyVO(String companyName, Date establishedDate, String gstNumber, String contactNumberOne, String contactNumberTwo, String emailId, double totalCash) {
        this.companyName = companyName;
        this.establishedDate = establishedDate;
        this.gstNumber = gstNumber;
        this.contactNumberOne = contactNumberOne;
        this.contactNumberTwo = contactNumberTwo;
        this.emailId = emailId;
        this.totalCash = totalCash;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getEstablishedDate() {
        return establishedDate;
    }

    public void setEstablishedDate(Date establishedDate) {
        this.establishedDate = establishedDate;
    }

    public String getGstNumber() {
        return gstNumber;
    }

    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public double getTotalCash() {
        return totalCash;
    }

    public void setTotalCash(double totalCash) {
        this.totalCash = totalCash;
    }

    @Override
    public String toString() {
        return "CompanyVO{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", establishedDate=" + establishedDate +
                ", gstNumber='" + gstNumber + '\'' +
                ", contactNumberOne='" + contactNumberOne + '\'' +
                ", contactNumberTwo='" + contactNumberTwo + '\'' +
                ", emailId='" + emailId + '\'' +
                ", totalCash=" + totalCash +
                '}';
    }
}
