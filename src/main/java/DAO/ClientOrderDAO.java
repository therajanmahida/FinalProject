package DAO;

import DAO.Global.DBOperationDAO;
import VO.ClientOrderVO;
import org.hibernate.Query;

import java.util.Date;
import java.util.List;

public class ClientOrderDAO {
    ClientOrderVO clientOrderVO;
    DBOperationDAO dbOperationDAO;
    List<ClientOrderVO> list;

    public ClientOrderDAO(){
        this.dbOperationDAO = new DBOperationDAO();
    }

    public List<ClientOrderVO> getClientOrderVOList(){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.ClientOrderVO");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<ClientOrderVO> getClientOrderVOListByCompany(int _company_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.ClientOrderVO where companyVO.id='"+_company_id);
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<ClientOrderVO> getClientOrderVOListByClient(int _company_id,int _client_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.ClientOrderVO where companyVO.id="+_company_id+" and clientVO.id="+_client_id+"");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<ClientOrderVO> getClientOrderVOListByOrderDate(int _company_id,Date orderDate){
        dbOperationDAO.openCurrentSession();
        Query query = dbOperationDAO.getCurrentSession().createQuery("from VO.ClientOrderVO where companyVO.id="+_company_id+" and OrderDate=:date");
        query.setDate("date",orderDate);
        list = query.list();
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<ClientOrderVO> getClinetOrderVOListByDispatchDate(int _company_id,Date dispatchDate){
        dbOperationDAO.openCurrentSession();
        Query query = dbOperationDAO.getCurrentSession().createQuery("from VO.ClientOrderVO where companyVO.id="+_company_id+" and DispatchDate=:date");
        query.setDate("date",dispatchDate);
        list = query.list();
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<ClientOrderVO> getClientOrderVOListByDeliveryDate(int _company_id,Date deliveryDate){
        dbOperationDAO.openCurrentSession();
        Query query = dbOperationDAO.getCurrentSession().createQuery("from VO.ClientOrderVO where companyVO.id="+_company_id+" and DeliveryDate=:date");
        query.setDate("date",deliveryDate);
        list = query.list();
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<ClientOrderVO> getClientOrderVOListByPaymentstStatus(int _company_id,ClientOrderVO.PaymentStatus paymentStatus){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.ClientOrderVO where companyVO.id="+_company_id+" and paymentStatus='"+paymentStatus+"'");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<ClientOrderVO> getClientOrderVOListBySellAmount(int _company_id,double sellAmount){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.ClientOrderVO where companyVO.id="+_company_id+" and SellAmount="+sellAmount+"");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<ClientOrderVO> getClientOrderVOListByTaxAmount(int _company_id,double taxAmount){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.ClientOrderVO where companyVO.id="+_company_id+" and TaxAmount="+taxAmount+"");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<ClientOrderVO> getClientOrderVOListByProfitMargin(int _company_id,double profitMargin){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.ClientOrderVO where companyVO.id="+_company_id+" and ProfitMargin="+profitMargin+"");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public ClientOrderVO load(int _client_order_id){
        dbOperationDAO.openCurrentSession();
        ClientOrderVO clientOrderVO = dbOperationDAO.load(ClientOrderVO.class,_client_order_id);
        dbOperationDAO.closeCurrentSession();
        return clientOrderVO;
    }

    public void deleteById(int _client_order_id){
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.deleteById(ClientOrderVO.class,_client_order_id);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }

    public void insert(ClientOrderVO clientOrderVO){
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.insert(clientOrderVO);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }

    public void update(ClientOrderVO clientOrderVO,int _client_order_id){
        dbOperationDAO.openCurrentSessionWithTransaction();
        clientOrderVO.setId(_client_order_id);
        dbOperationDAO.update(clientOrderVO);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }




}
