package DAO;

import DAO.Global.DBOperationDAO;
import VO.SupplierDocumentVO;

import java.util.List;

public class SupplierDocumentDAO {
    DBOperationDAO dbOperationDAO;
    List<SupplierDocumentVO> list;

    public SupplierDocumentDAO(){
        this.dbOperationDAO = new DBOperationDAO();
    }

    public List<SupplierDocumentVO> getDocumentBySupplierID(int _supplier_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.SupplierDocumentVO where supplierVO.id="+_supplier_id);
        dbOperationDAO.closeCurrentSession();
        return list;
    }
}
