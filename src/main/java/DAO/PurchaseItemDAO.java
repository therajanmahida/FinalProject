package DAO;

import DAO.Global.DBOperationDAO;
import VO.CompanyVO;
import VO.PurchaseItemVO;

import java.util.List;

public class PurchaseItemDAO {
    PurchaseItemVO purchaseItemVO;
    DBOperationDAO dbOperationDAO;
    List<PurchaseItemVO> list;

    public PurchaseItemDAO(){
        dbOperationDAO = new DBOperationDAO();
    }

    public List<PurchaseItemVO> getPurchaseItemVOList(){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.PurchaseItemVO");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<PurchaseItemVO> getPurchaseItemVOListById(int _purchase_item_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.PurchaseItemVO where id="+_purchase_item_id);
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<PurchaseItemVO> getPurchaseItemVOListByDrug(int _drug_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.PurchaseItemVO where drugVO.id = "+_drug_id);
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public PurchaseItemVO load(int _purchase_Item_id){
        dbOperationDAO.openCurrentSession();
        PurchaseItemVO purchaseItemVO = dbOperationDAO.load(PurchaseItemVO.class,_purchase_Item_id);
        dbOperationDAO.closeCurrentSession();
        return purchaseItemVO;
    }

    public void deleteById(int _purchase_item_id){
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.deleteById(PurchaseItemVO.class,_purchase_item_id);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }

    public void insert(PurchaseItemVO purchaseItemVO){
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.insert(purchaseItemVO);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }

    public void update(PurchaseItemVO purchaseItemVO,int _purchase_item_id){
        dbOperationDAO.openCurrentSessionWithTransaction();
        purchaseItemVO.setId(_purchase_item_id);
        dbOperationDAO.update(purchaseItemVO);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }












}
