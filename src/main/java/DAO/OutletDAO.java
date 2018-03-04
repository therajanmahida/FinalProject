package DAO;

import DAO.Global.DBOperationDAO;
import VO.CompanyVO;
import VO.OutletVO;

import java.util.List;

public class OutletDAO {
    OutletVO outletVO;
    DBOperationDAO dbOperationDAO;
    List<OutletVO> list;

    public List<OutletVO> getOutletVOList(){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.OutletVO");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<OutletVO> getOutletVOListByCompanyId(int _company_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.OutletVO where companyVO.id="+_company_id);
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<OutletVO> getOutletVOListByNameAndCompnany(String _outlet_name,int _company_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.OutletVO where companyVO.id = "+_company_id+" and OutletName = '"+_outlet_name+"'");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<OutletVO> getOutletVOListByContactNumberAndCompany(String _contact,int _company_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.OutletVO where companyVO.id="+_company_id+" and ContactNumberOne='"+_contact+"'");
        list.addAll(dbOperationDAO.getList("from VO.OutletVO where companyVO.id="+_company_id+" and ContactNumberTwo='"+_contact+"'"));
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<OutletVO> getOutletVOListByStateAndCompany(String _state,int _comapny_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.OutletVO where companyVO.id="+_comapny_id+" and State='"+_state+"'");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<OutletVO> getOutletVOListByCityAndCompanyId(String _city,int _comapny_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.OutletVO where companyVO.id="+_comapny_id+" and City='"+_city+"'");
        dbOperationDAO.closeCurrentSession();;
        return list;
    }

    public OutletVO load(int _outlet_id ){
        dbOperationDAO.openCurrentSession();
        OutletVO outletVO = dbOperationDAO.load(OutletVO.class,_outlet_id);
        dbOperationDAO.closeCurrentSession();
        return outletVO;
    }

    public void deleteById(int _outlet_id){
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.deleteById(OutletVO.class,_outlet_id);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }

    public void insert(OutletVO outletVO){
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.insert(outletVO);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }

    public void update(OutletVO outletVO,int _outlet_id){
        dbOperationDAO.openCurrentSessionWithTransaction();
        outletVO.setId(_outlet_id);
        dbOperationDAO.update(outletVO);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }

}
