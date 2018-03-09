package DAO;

import DAO.Global.DBOperationDAO;
import VO.InventoryStocksVO;
import org.hibernate.Query;

import java.util.Date;
import java.util.List;

public class InventoryStocksDAO {
    InventoryStocksVO inventoryStocksVO;
    DBOperationDAO dbOperationDAO;
    List<InventoryStocksVO> list;

    public InventoryStocksDAO(){
        this.dbOperationDAO = new DBOperationDAO();
    }

    public List<InventoryStocksVO> getInventoryStocksVOList(){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.InventoryStocksVO");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<InventoryStocksVO> getInventoryStocksVOListByCompany(int _company_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.InventoryStocksVO where companyVO.id="+_company_id);
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<InventoryStocksVO> getInventoryStocksVOListByRecievedDate(int _company_id,Date recievedDate){
        dbOperationDAO.openCurrentSession();
        Query query = dbOperationDAO.getCurrentSession().createQuery("from VO.InventoryStocksVO where companyVO.id="+_company_id+" and StockRecievedDate=:date");
        query.setDate("date",recievedDate);
        list = query.list();
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<InventoryStocksVO> getInventoryStocksVOListByManufacturedDate(int _company_id,Date manufacturedDate){
        dbOperationDAO.openCurrentSession();
        Query query = dbOperationDAO.getCurrentSession().createQuery("from VO.InventoryStocksVO where companyVO.id="+_company_id+" and StockManufacturedDate=:date");
        query.setDate("date",manufacturedDate);
        list = query.list();
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<InventoryStocksVO> getInventoryStocksVOListByExpiryDate(int _company_id,Date expiryDate){
        dbOperationDAO.openCurrentSession();
        Query query = dbOperationDAO.getCurrentSession().createQuery("from VO.InventoryStocksVO where companyVO.id="+_company_id+" and StockExpiryDate=:date");
        query.setDate("date",expiryDate);
        list = query.list();
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<InventoryStocksVO> getInventoryStocksVOListByQuantity(int _company_id,int qunatity){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.InventoryStocksVO where company.id="+_company_id+" and StockQuantity="+qunatity);
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<InventoryStocksVO> getInventoryStocksVOListByDrug(int _company_id,int drug_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.InventoryStocksVO where company.id="+_company_id+" and drugVO.id="+drug_id);
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<InventoryStocksVO> getInventoryStocksVOListByOutlet(int _company_id,int outlet_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.InventoryStocksVO where company.id="+_company_id+" and outletVO.id="+outlet_id);
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public InventoryStocksVO load(int _inventory_stocks_id){
        dbOperationDAO.openCurrentSession();
        InventoryStocksVO inventoryStocksVO = dbOperationDAO.load(InventoryStocksVO.class,_inventory_stocks_id);
        dbOperationDAO.closeCurrentSession();
        return inventoryStocksVO;
    }

    public void deleteById(int _inventory_stocks_id){
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.deleteById(InventoryStocksVO.class,_inventory_stocks_id);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }

    public void insert(InventoryStocksVO inventoryStocksVO){
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.insert(inventoryStocksVO);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }

    public void update(InventoryStocksVO inventoryStocksVO,int _inventory_stocks_id){
        dbOperationDAO.openCurrentSessionWithTransaction();
        inventoryStocksVO.setId(_inventory_stocks_id);
        dbOperationDAO.update(inventoryStocksVO);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }



}
