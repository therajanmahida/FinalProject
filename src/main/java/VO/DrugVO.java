package VO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "drug")
public class DrugVO implements Serializable {
    public enum DrugType{TABLET,CAPSULE}
    public enum State{SOLID,LIQUID}

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "item_name",nullable = false)
    private String itemName;

    @Column(name = "item_description",nullable = false)
    private String itemDescription;

    @Column(name = "dosage",nullable = false)
    private String dosage;

    @Enumerated(EnumType.STRING)
    @Column(name = "drug_type",nullable = false)
    private DrugType drugType;

    @Enumerated(EnumType.STRING)
    @Column(name = "drug_state",nullable = false)
    private State state;

    @Column(name = "buy_price",nullable = false)
    private double buyPrice;

    @Column(name = "mrp",nullable = false)
    private double mRP;

    @Column(name = "expiry_duration",nullable = false)
    private int expiryDuration;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Drug_Supplier", joinColumns = { @JoinColumn(name = "id") } , inverseJoinColumns = { @JoinColumn(name = "supplier_id") })
    private Set<SupplierVO> supplierVO;

    @OneToOne
    @JoinColumn(name = "company_id")
    private CompanyVO companyVO;

    public DrugVO() {
    }

    public DrugVO(String itemName, String itemDescription, String dosage, DrugType drugType, State state, double buyPrice, double mRP, int expiryDuration, Set<SupplierVO> supplierVO, CompanyVO companyVO) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.dosage = dosage;
        this.drugType = drugType;
        this.state = state;
        this.buyPrice = buyPrice;
        this.mRP = mRP;
        this.expiryDuration = expiryDuration;
        this.supplierVO = supplierVO;
        this.companyVO = companyVO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public DrugType getDrugType() {
        return drugType;
    }

    public void setDrugType(DrugType drugType) {
        this.drugType = drugType;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public double getmRP() {
        return mRP;
    }

    public void setmRP(double mRP) {
        this.mRP = mRP;
    }

    public int getExpiryDuration() {
        return expiryDuration;
    }

    public void setExpiryDuration(int expiryDuration) {
        this.expiryDuration = expiryDuration;
    }

    public Set<SupplierVO> getSupplierVO() {
        return supplierVO;
    }

    public void setSupplierVO(Set<SupplierVO> supplierVO) {
        this.supplierVO = supplierVO;
    }

    public CompanyVO getCompanyVO() {
        return companyVO;
    }

    public void setCompanyVO(CompanyVO companyVO) {
        this.companyVO = companyVO;
    }

    @Override
    public String toString() {
        return "DrugVO{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", dosage='" + dosage + '\'' +
                ", drugType=" + drugType +
                ", state=" + state +
                ", buyPrice=" + buyPrice +
                ", mRP=" + mRP +
                ", expiryDuration=" + expiryDuration +
                ", supplierVO=" + supplierVO +
                ", companyVO=" + companyVO +
                '}';
    }
}
