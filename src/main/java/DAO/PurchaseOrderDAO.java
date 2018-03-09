package DAO;

import DAO.Global.DBOperationDAO;
import VO.PurchaseOrderVO;
import org.hibernate.Query;

import java.util.Date;
import java.util.List;

public class PurchaseOrderDAO {
    PurchaseOrderVO purchaseOrderVO;
    DBOperationDAO dbOperationDAO;
    List<PurchaseOrderVO> list;

    public PurchaseOrderDAO(){
        this.dbOperationDAO = new DBOperationDAO();
    }

    public List<PurchaseOrderVO> getPurchaseOrderVOList(){
        dbOperationDAO.openCurrentSession();
        list  = dbOperationDAO.getList("from VO.PurchaseOrderVO");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<PurchaseOrderVO> getPurchaseOrderVOListByCompany(int _company_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.PurchaseOrderVO where companyVO.id="+_company_id);
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<PurchaseOrderVO> getPurchaseOrderVOListByPurchaseDate(int _company_id,Date _purchase_date){
        dbOperationDAO.openCurrentSession();
        Query query = dbOperationDAO.getCurrentSession().createQuery("from VO.PurchaseOrderVO where companyVO.id="+_company_id+" and PurchaseDate=:date");
        query.setDate("date",_purchase_date);
        list = query.list();
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<PurchaseOrderVO> getPurchaseOrderVOListByPurchaseRequest(int _company_id,PurchaseOrderVO.PurchaseRequest purchaseRequest){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.PurchaseOrderVO where companyVO.id="+_company_id+" and purchaseRequest='"+purchaseRequest+"'");
        dbOperationDAO.closeCurrentSession();;
        return list;
    }

    public List<PurchaseOrderVO> getPurchaseOrderVOListByRequestDate(int _company_id,Date requestDate) {
        dbOperationDAO.openCurrentSession();
        Query query = dbOperationDAO.getCurrentSession().createQuery("from VO.PurchaseOrderVO where companyVO.id="+_company_id+" and RequestDate=:date");
        query.setDate("date",requestDate);
        list = query.list();
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<PurchaseOrderVO> getPurchaseOrderVOListByDeliveryStatus(int _company_id, PurchaseOrderVO.DeliveryStatus deliveryStatus){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.PurchaseOrderVO where companyVO.id="+_company_id+" and deliveryStatus='"+deliveryStatus+"'");
        dbOperationDAO.closeCurrentSession();;
        return list;
    }

    public List<PurchaseOrderVO> getPurchaseOrderVOListByPurchaseAmount(int _compamy_id,double purchaseAmount){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.PurchaseOrderVO where companyVO.id="+_compamy_id+" and PurchaseAmount="+purchaseAmount);
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<PurchaseOrderVO> getPurchaseOrderVOListByGST(int _company_id,String gstNumber){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.PurchaseOrderVO where companyVO.id="+_company_id+" and GST='"+gstNumber+"'");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<PurchaseOrderVO> getPurchaseOrderVOListByOutlet(int _company_id,int _outlet_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.PurchaseOrder where companyVO.id="+_company_id+" and outletVO.id="+_outlet_id);
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<PurchaseOrderVO> getPurchaseOrderVOListByEmployee(int _company_id,int _employee_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.PurchaseOrder where companyVO.id="+_company_id+" and employeeVO.id="+_employee_id);
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public PurchaseOrderVO load(int _purchase_order_id){
        dbOperationDAO.openCurrentSession();
        PurchaseOrderVO purchaseOrderVO = dbOperationDAO.load(PurchaseOrderVO.class,_purchase_order_id);
        dbOperationDAO.closeCurrentSession();
        return purchaseOrderVO;
    }

    public void deleteById(int _purchase_order_id){
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.deleteById(PurchaseOrderVO.class,_purchase_order_id);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }

    public void insert(PurchaseOrderVO purchaseOrderVO){
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.insert(purchaseOrderVO);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }

    public void update(PurchaseOrderVO purchaseOrderVO,int _purchase_order_id){
        dbOperationDAO.openCurrentSessionWithTransaction();
        purchaseOrderVO.setId(_purchase_order_id);
        dbOperationDAO.update(purchaseOrderVO);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }


}
