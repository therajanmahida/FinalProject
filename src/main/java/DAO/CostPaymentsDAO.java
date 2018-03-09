package DAO;

import DAO.Global.DBOperationDAO;
import VO.CompanyVO;
import VO.CostPaymentsVO;
import org.hibernate.Query;

import java.util.Date;
import java.util.List;

public class CostPaymentsDAO {
    CostPaymentsVO costPaymentsVO;
    DBOperationDAO dbOperationDAO;
    List<CostPaymentsVO> list;

    public CostPaymentsDAO(){
        this.dbOperationDAO = new DBOperationDAO();
    }

    public List<CostPaymentsVO> getCostPaymentsVOList(){
        dbOperationDAO.openCurrentSession();
        list  = dbOperationDAO.getList("from VO.CostPaymentsVO");
        dbOperationDAO.closeCurrentSession();
        return list;
    }
    public List<CostPaymentsVO> getCostPaymentsVOListByCompany(int _company_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.CostPaymentsVO where companyVO.id="+_company_id);
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<CostPaymentsVO> getCostPaymentsVOListByName(int _company_id , String name){
        dbOperationDAO.openCurrentSession();
        list  = dbOperationDAO.getList("from VO.CostPaymentsVO where PaymentName='"+name+"' and companyVO.id="+_company_id+"");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<CostPaymentsVO> getCostPaymentsVOListByPaymentTo(int _company_id ,String paymentTo){
        dbOperationDAO.openCurrentSession();
        list  = dbOperationDAO.getList("from VO.CostPaymentsVO where PaymentTo='"+paymentTo+"' and companyVO.id="+_company_id+"");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<CostPaymentsVO> getCostPaymentsVOListByPaymentFrom(int _company_id ,String paymentFrom){
        dbOperationDAO.openCurrentSession();
        list  = dbOperationDAO.getList("from VO.CostPaymentsVO where PaymentFrom='"+paymentFrom+"' and companyVO.id="+_company_id+"");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<CostPaymentsVO> getCostPaymentsVOListByPaymentAmount(int _company_id ,double amount){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.CostPaymentsVO where PaymentAmount="+amount+" and companyVO.id="+_company_id+"");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<CostPaymentsVO> getCostPaymentsVOListByEmployee(int _company_id, int employeeid){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.CostPaymentsVO where companyVO.id="+_company_id+" and employeeVO.id="+employeeid);
        dbOperationDAO.closeCurrentSession();;
        return list;
    }

    public List<CostPaymentsVO> getCostPaymentsVOListByDate(int _company_id, Date date){
        dbOperationDAO.openCurrentSession();
        Query query = dbOperationDAO.getCurrentSession().createQuery("from VO.CostPaymentsVO where companyVO.id="+_company_id+" and PaymentDate=:date");
        query.setDate("date",date);
        list = query.list();
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public CostPaymentsVO load(int _cost_payment_id){
        dbOperationDAO.openCurrentSession();
        CostPaymentsVO costPaymentsVO = dbOperationDAO.load(CostPaymentsVO.class,_cost_payment_id);
        dbOperationDAO.closeCurrentSession();
        return costPaymentsVO;
    }

    public void deleteById(int _cost_payment_id){
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.deleteById(CostPaymentsVO.class,_cost_payment_id);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }

    public void insert(CostPaymentsVO costPaymentsVO){
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.insert(costPaymentsVO);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }

    public void update(CostPaymentsVO costPaymentsVO,int _cost_payment_id){
        dbOperationDAO.openCurrentSessionWithTransaction();
        costPaymentsVO.setId(_cost_payment_id);
        dbOperationDAO.update(costPaymentsVO);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }


}
