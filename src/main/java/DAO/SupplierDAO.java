package DAO;

import Controller.Supplier.Supplier;
import DAO.Global.DBOperationDAO;
import VO.SupplierVO;

import java.util.List;

public class SupplierDAO  {
    SupplierVO supplierVO;
    DBOperationDAO dbOperationDAO;
    List<SupplierVO> list;

    public SupplierDAO(){
        this.dbOperationDAO = new DBOperationDAO();
    }

    public List<SupplierVO> getSupplierVOList(){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.SupplierVO");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<SupplierVO> getSupplierVOListBySupplierID(int _supplier_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.SupplierVO where id="+_supplier_id);
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<SupplierVO> getSupplierVOList(int _company_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.SupplierVO where companyVO.id="+_company_id+"");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public Integer insert(SupplierVO supplierVO){
        dbOperationDAO.openCurrentSessionWithTransaction();
        Integer id  = dbOperationDAO.insert(supplierVO);
        dbOperationDAO.closeCurrentSessionWithTransaction();
        return id;
    }

    public void deleteById(int _supplier_id){
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.deleteById(SupplierVO.class,_supplier_id);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }

    public void update(SupplierVO supplierVO, int _supplier_id){
        dbOperationDAO.openCurrentSessionWithTransaction();
        supplierVO.setId(_supplier_id);
        dbOperationDAO.update(supplierVO);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }


}
