package DAO;

import DAO.Global.DBOperationDAO;
import VO.ClientVO;


import java.util.List;

public class ClientDAO {
    ClientVO clientVO;
    DBOperationDAO dbOperationDAO;
    List<ClientVO> list;

    public ClientDAO(){
        this.dbOperationDAO = new DBOperationDAO();
    }

    public List<ClientVO> getClientVOList(){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.ClientVO");
        dbOperationDAO.closeCurrentSession();
        return list;
    }
    public List<ClientVO> getClientVOListByCompany(int _company_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.ClientVO where companyVO.id="+_company_id);
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<ClientVO> getClientVOListByName(int _company_id,String clientName){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.ClientVO where companyVO.id="+_company_id+" and ClientName='"+clientName+"'");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<ClientVO> getClientVOListByGstNumber(int _company_id,String gstNumber){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.ClientVO where companyVO.id="+_company_id+" and GSTInNumber='"+gstNumber+"'");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<ClientVO> getClientVOListByContactNumber(int _company_id,String contactNumber){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.ClientVO where companyVO.id="+_company_id+" and ContactNumberOne='"+contactNumber+"'");
        list.addAll(dbOperationDAO.getList("from VO.ClientVO where companyVO.id="+_company_id+" and ContactNumberTwo='"+contactNumber+"'"));
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<ClientVO> getClientVOListByEmailId(int _company_id,String emailid){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.ClientVO where companyVO.id="+_company_id+" and EmailId='"+emailid+"'");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<ClientVO> getClientVOListByState(int _company_id,String state){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.ClientVO where companyVO.id="+_company_id+" and State='"+state+"'");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<ClientVO> getClientVOListByCity(int _company_id,String city){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.ClientVO where companyVO.id="+_company_id+" and City='"+city+"'");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public ClientVO load(int _client_id){
        dbOperationDAO.openCurrentSession();
        ClientVO clientVO = dbOperationDAO.load(ClientVO.class,_client_id);
        dbOperationDAO.closeCurrentSession();
        return clientVO;
    }

    public void deleteById(int _client_id){
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.deleteById(ClientVO.class,_client_id);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }

    public void insert(ClientVO clientVO){
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.insert(clientVO);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }

    public void update(ClientVO clientVO,int _client_id){
        dbOperationDAO.openCurrentSessionWithTransaction();
        clientVO.setId(_client_id);
        dbOperationDAO.update(clientVO);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }


}
