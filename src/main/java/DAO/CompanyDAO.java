package DAO;

import DAO.Global.DBOperationDAO;
import VO.CompanyVO;

import java.util.List;

public class CompanyDAO {
    CompanyVO companyVO;
    DBOperationDAO dbOperationDAO;
    List<CompanyVO> list;

    public CompanyDAO(){
        this.dbOperationDAO = new DBOperationDAO();
    }

    public List<CompanyVO> getCompanyVOList(){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.CompanyVO");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<CompanyVO> getCompanyById(int _company_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.CompanyVO where id="+_company_id);
        dbOperationDAO.closeCurrentSession();
        return list;


    }

    public List<CompanyVO> getCompanyVOListByName(String _name){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.CompanyVO where CompanyName='"+_name+"'");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<CompanyVO> getCompanyVOListByGst(String _gst_number){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.CompanyVO where GstNumber='"+_gst_number+"'");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<CompanyVO> getCompanyVOListByContactNumber(String _number){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.CompanyVO where ContactNumberOne='"+_number+"'");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<CompanyVO> getCompanyVOListByEmail(String _email){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.CompanyVO where EmailId='"+_email+"'");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public CompanyVO load(int _company_id){
        dbOperationDAO.openCurrentSession();
        CompanyVO companyVO = dbOperationDAO.load(CompanyVO.class,_company_id);
        dbOperationDAO.closeCurrentSession();
        return companyVO;
    }

    public void deleteById(int _company_id){
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.deleteById(CompanyVO.class,_company_id);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }

    public void insert(CompanyVO companyVO){
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.insert(companyVO);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }

    public void update(CompanyVO companyVO,int _company_id){
        dbOperationDAO.openCurrentSessionWithTransaction();
        companyVO.setId(_company_id);
        dbOperationDAO.update(companyVO);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }


}
