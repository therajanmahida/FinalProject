package VO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "outlet")
public class OutletVO implements Serializable{
    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "outlet_name",nullable = false,unique = true)
    private String OutletName;

    @Column(name = "contact_number_one",nullable = false,unique = true)
    private String ContactNumberOne;

    @Column(name = "contact_number_two",unique = true)
    private String ContactNumberTwo;

    @Column(name ="address_line",nullable = false)
    private String AddressLine;

    @Column(name="state",nullable = false)
    private String State;

    @Column(name="city",nullable = false)
    private String City;

    @ManyToOne
    @JoinColumn(name  = "comanyId")
    private CompanyVO comanyVO;

    public OutletVO(String outletName, String contactNumberOne, String contactNumberTwo, String addressLine, String state, String city, CompanyVO comanyVO) {
        OutletName = outletName;
        ContactNumberOne = contactNumberOne;
        ContactNumberTwo = contactNumberTwo;
        AddressLine = addressLine;
        State = state;
        City = city;
        this.comanyVO = comanyVO;
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
        return OutletName;
    }

    public void setOutletName(String outletName) {
        OutletName = outletName;
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

    public String getAddressLine() {
        return AddressLine;
    }

    public void setAddressLine(String addressLine) {
        AddressLine = addressLine;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public CompanyVO getComanyVO() {
        return comanyVO;
    }

    public void setComanyVO(CompanyVO comanyVO) {
        this.comanyVO = comanyVO;
    }
}
