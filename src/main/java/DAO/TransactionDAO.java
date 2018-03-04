package DAO;

import DAO.Global.DBOperationDAO;
import VO.TransactionVO;

import java.util.List;

public class TransactionDAO {
    TransactionVO transactionVO;
    DBOperationDAO dbOperationDAO;
    List<TransactionVO> list;

    public TransactionDAO(){
        this.dbOperationDAO = new DBOperationDAO();
    }

    public List<TransactionVO> getTransactionVOList(){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.TransactionVO");
        dbOperationDAO.closeCurrentSession();
        return list;
    }
    public TransactionVO getTransactionVO(int _transaction_id){
        dbOperationDAO.openCurrentSession();
        TransactionVO transactionVO = dbOperationDAO.getCurrentSession().load(TransactionVO.class,_transaction_id);
        dbOperationDAO.closeCurrentSession();
        return transactionVO;
    }
    public List<TransactionVO> getTransactionVOList(int _company_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.TransactionVO where companyVO.id="+_company_id);
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public void insert(TransactionVO transactionVO){
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.insert(transactionVO);
        dbOperationDAO.openCurrentSessionWithTransaction();
    }

    public void deleteById(int _transaction_id){
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.deleteById(TransactionVO.class,_transaction_id);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }
    public void update(TransactionVO transactionVO, int _transaction_id){
        dbOperationDAO.openCurrentSessionWithTransaction();
        transactionVO.setId(_transaction_id);
        dbOperationDAO.update(transactionVO);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }



}
