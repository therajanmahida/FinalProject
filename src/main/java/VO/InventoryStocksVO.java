package VO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "inventory")
public class InventoryStocksVO implements Serializable{

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    @Column(name = "stock_recieved_date")
    private Date StockRecievedDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "stock_manufactured_date")
    private Date StockManufacturedDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "stock_expiry_date")
    private Date StockExpiryDate;

    @Column(name = "stock_quntity")
    private int StockQuantity;

    @ManyToOne
    @JoinColumn(name = "drug_id")
    private DrugVO drugVO;

    @ManyToOne
    @JoinColumn(name = "outlet_id")
    private OutletVO outletVO;

    public InventoryStocksVO() {
    }

    public InventoryStocksVO(Date stockRecievedDate, Date stockManufacturedDate, Date stockExpiryDate, int stockQuantity, DrugVO drugVO, OutletVO outletVO) {
        StockRecievedDate = stockRecievedDate;
        StockManufacturedDate = stockManufacturedDate;
        StockExpiryDate = stockExpiryDate;
        StockQuantity = stockQuantity;
        this.drugVO = drugVO;
        this.outletVO = outletVO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStockRecievedDate() {
        return StockRecievedDate;
    }

    public void setStockRecievedDate(Date stockRecievedDate) {
        StockRecievedDate = stockRecievedDate;
    }

    public Date getStockManufacturedDate() {
        return StockManufacturedDate;
    }

    public void setStockManufacturedDate(Date stockManufacturedDate) {
        StockManufacturedDate = stockManufacturedDate;
    }

    public Date getStockExpiryDate() {
        return StockExpiryDate;
    }

    public void setStockExpiryDate(Date stockExpiryDate) {
        StockExpiryDate = stockExpiryDate;
    }

    public int getStockQuantity() {
        return StockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        StockQuantity = stockQuantity;
    }

    public DrugVO getDrugVO() {
        return drugVO;
    }

    public void setDrugVO(DrugVO drugVO) {
        this.drugVO = drugVO;
    }

    public OutletVO getOutletVO() {
        return outletVO;
    }

    public void setOutletVO(OutletVO outletVO) {
        this.outletVO = outletVO;
    }
}
