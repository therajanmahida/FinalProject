package VO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "client_order_items")
public class ClientOrderItemsVO implements Serializable{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "quantity",nullable = false)
    private int Quantity;

    @ManyToOne
    @JoinColumn(name = "client_order_id")
    private ClientOrderVO clientOrderVO;

    @OneToOne
    @JoinColumn(name = "drug_id")
    private DrugVO drugVO;

    public ClientOrderItemsVO(int quantity, ClientOrderVO clientOrderVO, DrugVO drugVO) {
        Quantity = quantity;
        this.clientOrderVO = clientOrderVO;
        this.drugVO = drugVO;
    }

    public ClientOrderItemsVO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public ClientOrderVO getClientOrderVO() {
        return clientOrderVO;
    }

    public void setClientOrderVO(ClientOrderVO clientOrderVO) {
        this.clientOrderVO = clientOrderVO;
    }

    public DrugVO getDrugVO() {
        return drugVO;
    }

    public void setDrugVO(DrugVO drugVO) {
        this.drugVO = drugVO;
    }
}
