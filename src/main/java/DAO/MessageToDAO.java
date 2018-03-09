package DAO;

import DAO.Global.DBOperationDAO;
import VO.MessageToVO;

import java.util.List;

public class MessageToDAO {
    MessageToVO messageToVO;
    DBOperationDAO dbOperationDAO;
    List<MessageToVO> list;

    public MessageToDAO(){
        this.dbOperationDAO = new DBOperationDAO();
    }

    public List<MessageToVO> getMessageToVOList(){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.MessageToVO");
        dbOperationDAO.closeCurrentSession();;
        return list;
    }

    public List<MessageToVO> getMessageToVOListByUserTo(int _user_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.MessageToVO where UserTo.id ="+_user_id);
        dbOperationDAO.closeCurrentSession();;
        return list;
    }

    public List<MessageToVO> getMessageToVOListByUserFrom(int _user_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.MessageToVO where UserFrom.id = "+_user_id);
        dbOperationDAO.closeCurrentSession();;
        return list;
    }

    public MessageToVO load(int _message_to_id){
        dbOperationDAO.openCurrentSession();
        MessageToVO messageToVO = dbOperationDAO.load(MessageToVO.class,_message_to_id);
        dbOperationDAO.closeCurrentSession();
        return messageToVO;
    }

    public void deleteById(int _message_to_id){
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.deleteById(MessageToVO.class,_message_to_id);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }

    public void insert(MessageToVO messageToVO){
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.insert(messageToVO);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }

    public void update(MessageToVO messageToVO,int _message_to_id){
        dbOperationDAO.openCurrentSessionWithTransaction();
        messageToVO.setId(_message_to_id);
        dbOperationDAO.update(messageToVO);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }
}
