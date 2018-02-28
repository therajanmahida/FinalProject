package VO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "purchase_item")
public class PurchaseItemVO implements Serializable{

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "quantity",nullable = false)
    private int Qauntity;

    @ManyToOne
    @JoinColumn(name = "purchase_id",nullable = false)
    private PurchaseOrderVO purchaseOrderVO;

    @OneToMany
    @JoinColumn(name = "drug_id",nullable = false)
    private Set<DrugVO> drugVO;

    public PurchaseItemVO() {

    }

    public PurchaseItemVO(int qauntity, PurchaseOrderVO purchaseOrderVO, Set<DrugVO> drugVO) {
        Qauntity = qauntity;
        this.purchaseOrderVO = purchaseOrderVO;
        this.drugVO = drugVO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQauntity() {
        return Qauntity;
    }

    public void setQauntity(int qauntity) {
        Qauntity = qauntity;
    }

    public PurchaseOrderVO getPurchaseOrderVO() {
        return purchaseOrderVO;
    }

    public void setPurchaseOrderVO(PurchaseOrderVO purchaseOrderVO) {
        this.purchaseOrderVO = purchaseOrderVO;
    }

    public Set<DrugVO> getDrugVO() {
        return drugVO;
    }

    public void setDrugVO(Set<DrugVO> drugVO) {
        this.drugVO = drugVO;
    }


}
