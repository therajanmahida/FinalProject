package DAO;

import DAO.Global.DBOperationDAO;
import VO.ReminderVO;
import org.hibernate.Query;

import java.util.Date;
import java.util.List;

public class ReminderDAO {
    ReminderVO reminderVO;
    DBOperationDAO dbOperationDAO;
    List<ReminderVO> list;

    public ReminderDAO(){
        this.dbOperationDAO = new DBOperationDAO();
    }

    public List<ReminderVO> getReminderList() {
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.ReminderVO");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<ReminderVO> getReminderListBySender(int _user_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.ReminderVO where userVOFrom.id="+_user_id);
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<ReminderVO> getReminderListByReceiver(int _user_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.ReminderVO where userVOTo.id="+_user_id);
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<ReminderVO> getReminderListByCompany(int _company_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.ReminderVO where companyVO.id="+_company_id);
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<ReminderVO> getReminderListByDate(Date date){
        dbOperationDAO.openCurrentSession();
        Query query = dbOperationDAO.getCurrentSession().createQuery("from VO.ReminderVO where ReminderDate = :date");
        query.setDate("date",date);
        list = query.list();
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public void deleteById(int _reminder_id){
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.deleteById(ReminderVO.class,_reminder_id);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }

    public void insert(ReminderVO reminderVO){
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.insert(reminderVO);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }

    public void update(ReminderVO reminderVO,int _reminder_id){
        dbOperationDAO.openCurrentSessionWithTransaction();
        reminderVO.setId(_reminder_id);
        dbOperationDAO.update(reminderVO);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }



}
