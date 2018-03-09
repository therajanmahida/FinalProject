package DAO;

import DAO.Global.DBOperationDAO;
import VO.DrugVO;

import java.util.List;

public class DrugDAO {
    DrugVO drugVO;
    DBOperationDAO dbOperationDAO;
    List<DrugVO> list;

    public List<DrugVO> getDrugVOList(){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.DrugVO");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<DrugVO> getDrugVOListByCompany(int _company_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.DrugVO where companyVO.id="+_company_id);
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<DrugVO> getDrugVOListByItemName(int _company_id , String itemName){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.DrugVO where companyVO.id="+_company_id+" and ItemName='"+itemName+"'");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<DrugVO> getDrugVOListByDrugType(int _company_id , DrugVO.DrugType drugType){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.DrugVO where companyVO.id="+_company_id+" and drugType='"+drugType+"'");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<DrugVO> getDrugVOListByDrugState(int _company_id , DrugVO.State drugState){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.DrugVO where companyVO.id="+_company_id+" and state='"+drugState+"'");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public DrugVO load(int _drug_id){
        dbOperationDAO.openCurrentSession();
        DrugVO drugVO = dbOperationDAO.load(DrugVO.class,_drug_id);
        dbOperationDAO.closeCurrentSession();
        return drugVO;
    }

    public void deleteById(int _drug_id){
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.deleteById(DrugVO.class,_drug_id);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }

    public void insert(DrugVO drugVO){
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.insert(drugVO);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }

    public void update(DrugVO drugVO,int _drug_id){
        dbOperationDAO.openCurrentSessionWithTransaction();
        drugVO.setId(_drug_id);
        dbOperationDAO.update(drugVO);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }


}
