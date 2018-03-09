package DAO;

import DAO.Global.DBOperationDAO;
import VO.MessageVO;
import org.hibernate.Query;

import java.util.Date;
import java.util.List;

public class MessageDAO {
    MessageVO messageVO;
    DBOperationDAO dbOperationDAO;
    List<MessageVO> list;

    public MessageDAO(){
        this.dbOperationDAO = new DBOperationDAO();
    }

    public List<MessageVO> getMessageVOList(){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.MessageVO");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<MessageVO> getMessageVOListByCompanyId(int _company_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.MessageVO where companyVO.id="+_company_id);
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<MessageVO> getMessageVOListByDate(int _company_id , Date date){
        dbOperationDAO.openCurrentSession();
        Query query = dbOperationDAO.getCurrentSession().createQuery("from VO.MessageVO where companyVO.id="+_company_id+" and MessageDate = :date");
        query.setDate("date",date);
        list = query.list();
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public MessageVO load(int _message_id){
        dbOperationDAO.openCurrentSession();
        MessageVO messageVO = dbOperationDAO.load(MessageVO.class,_message_id);
        dbOperationDAO.closeCurrentSession();
        return messageVO;
    }

    public void deleteById(int _message_id){
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.deleteById(MessageVO.class,_message_id);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }

    public void insert(MessageVO messageVO){
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.insert(messageVO);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }

    public void update(MessageVO messageVO,int _message_id){
        dbOperationDAO.openCurrentSessionWithTransaction();
        messageVO.setId(_message_id);
        dbOperationDAO.update(messageVO);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }





}
