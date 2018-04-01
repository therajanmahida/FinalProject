package DAO;

import DAO.Global.DBOperationDAO;
import VO.MessageToVO;

import java.util.*;

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
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<MessageToVO> getMessageToVOList(int _message_to_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.MessageToVO where id="+_message_to_id);
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<MessageToVO> getMessageToVOListByUserTo(int _user_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.MessageToVO where userTo.id ="+_user_id);
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public Long getTodayMessage(int _user_id){
        list = getMessageToVOListByUserTo(_user_id);
        Date today = new Date();
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(today);
        cal.add(Calendar.DATE,-1);
        Date previous = cal.getTime();

        Long today_message  = list.stream().filter(messageToVO1 -> (messageToVO1.getMessageVO().getMessageDate().compareTo(today) < 1 && messageToVO1.getMessageVO().getMessageDate().compareTo(previous) > -1)).count();
        return today_message;
    }

    public Integer getTotolMessage(int _user_id){
        return getMessageToVOListByUserTo(_user_id).size();
    }

    public Integer getUnreadMessage(int _user_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.MessageToVO where isRead="+0);
        dbOperationDAO.closeCurrentSession();
        return list.size();
    }
    public List<MessageToVO> getMessageToVOListByUserFrom(int _user_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.MessageToVO where userFrom.id = "+_user_id);
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
