package VO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "drug")
public class DrugVO implements Serializable {
    private enum DrugType{TABLET,CAPSULE}
    private enum State{SOLID,LIQUID}

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "item_name",nullable = false,unique = true)
    private String ItemName;

    @Column(name = "item_description",nullable = false)
    private String ItemDescription;

    @Column(name = "dosage",nullable = false)
    private String Dosage;

    @Enumerated(EnumType.STRING)
    @Column(name = "drug_type",nullable = false)
    private DrugType drugType;

    @Enumerated(EnumType.STRING)
    @Column(name = "drug_state",nullable = false)
    private State state;

    @Column(name = "buy_price",nullable = false)
    private double BuyPrice;

    @Column(name = "mrp",nullable = false)
    private double MRP;

    @Column(name = "expiry_duration",nullable = false)
    private int ExpiryDuration;

    @OneToMany
    @JoinColumn(name = "supplier_id")
    private Set<SupplierVO> supplierVO;

    public DrugVO() {
    }

    public DrugVO(String itemName, String itemDescription, String dosage, DrugType drugType, State state, double buyPrice, double MRP, int expiryDuration, Set<SupplierVO> supplierVO) {
        ItemName = itemName;
        ItemDescription = itemDescription;
        Dosage = dosage;
        this.drugType = drugType;
        this.state = state;
        BuyPrice = buyPrice;
        this.MRP = MRP;
        ExpiryDuration = expiryDuration;
        this.supplierVO = supplierVO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getItemDescription() {
        return ItemDescription;
    }

    public void setItemDescription(String itemDescription) {
        ItemDescription = itemDescription;
    }

    public String getDosage() {
        return Dosage;
    }

    public void setDosage(String dosage) {
        Dosage = dosage;
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
        return BuyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        BuyPrice = buyPrice;
    }

    public double getMRP() {
        return MRP;
    }

    public void setMRP(double MRP) {
        this.MRP = MRP;
    }

    public int getExpiryDuration() {
        return ExpiryDuration;
    }

    public void setExpiryDuration(int expiryDuration) {
        ExpiryDuration = expiryDuration;
    }

    public Set<SupplierVO> getSupplierVO() {
        return supplierVO;
    }

    public void setSupplierVO(Set<SupplierVO> supplierVO) {
        this.supplierVO = supplierVO;
    }
}
