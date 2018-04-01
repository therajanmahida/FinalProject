package DAO;

import DAO.Global.DBOperationDAO;

import VO.DrugDocumentVO;


import java.util.List;

public class DrugDocumentDAO {
    DBOperationDAO dbOperationDAO;
    List<DrugDocumentVO> list;

    public DrugDocumentDAO(){
        this.dbOperationDAO = new DBOperationDAO();

    }

    public List<DrugDocumentVO> getDocumentByDrugID(int _drug_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.DrugDocumentVO where drugVO.id="+_drug_id);
        dbOperationDAO.closeCurrentSession();
        return list;
    }

}
