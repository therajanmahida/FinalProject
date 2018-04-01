package VO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "outlet")
public class OutletVO implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "outlet_name", nullable = false)
    private String outletName;

    @Column(name = "contact_number_one", nullable = false, unique = true)
    private String contactNumberOne;

    @Column(name = "contact_number_two", unique = true)
    private String contactNumberTow;

    @Column(name = "address_line", nullable = false)
    private String addressLine;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "city", nullable = false)
    private String city;

    @ManyToOne
    @JoinColumn(name = "comanyId", nullable = false)
    private CompanyVO companyVO;

    public OutletVO(String outletName, String contactNumberOne, String contactNumberTow, String addressLine, String state, String city, CompanyVO companyVO) {
        this.outletName = outletName;
        this.contactNumberOne = contactNumberOne;
        this.contactNumberTow = contactNumberTow;
        this.addressLine = addressLine;
        this.state = state;
        this.city = city;
        this.companyVO = companyVO;
    }

    public OutletVO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOutletName() {
        return outletName;
    }

    public void setOutletName(String outletName) {
        this.outletName = outletName;
    }

    public String getContactNumberOne() {
        return contactNumberOne;
    }

    public void setContactNumberOne(String contactNumberOne) {
        this.contactNumberOne = contactNumberOne;
    }

    public String getContactNumberTow() {
        return contactNumberTow;
    }

    public void setContactNumberTow(String contactNumberTow) {
        this.contactNumberTow = contactNumberTow;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public CompanyVO getCompanyVO() {
        return companyVO;
    }

    public void setCompanyVO(CompanyVO companyVO) {
        this.companyVO = companyVO;
    }
}
