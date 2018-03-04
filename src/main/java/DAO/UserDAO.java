package DAO;


import DAO.Global.DBOperationDAO;
import VO.UserVO;

import java.util.List;

public class UserDAO {
     UserVO userVO;
     DBOperationDAO dbOperationDAO;
        List<UserVO> list;

    public UserDAO() {
        this.dbOperationDAO = new DBOperationDAO();
    }

    public List<UserVO> getUserList(){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.UserVO");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<UserVO> getUserWithUserId(int _id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.UserVO where id="+_id);
        dbOperationDAO.closeCurrentSession();
        return list;

    }

    /*-------------------------------------------------------*/
    public UserVO load(int _user_id){
        dbOperationDAO.openCurrentSession();
        UserVO userVO = dbOperationDAO.load(UserVO.class,_user_id);
        dbOperationDAO.closeCurrentSession();
        return userVO;
    }
    /*-------------------------------------------------------*/

    public List<UserVO> getUserWithUserName(String _username){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.UserVO where username='"+_username+"'");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public void insert(UserVO userVO){
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.insert(userVO);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }

    public void deleteById(int _user_id){
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.deleteById(UserVO.class,_user_id);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }

    public boolean deleteByUserName(String _username){
        dbOperationDAO.openCurrentSessionWithTransaction();
        org.hibernate.Query query = dbOperationDAO.getCurrentSession().createQuery("from UserVO where username='"+_username+"'");
        list = query.list();
        boolean result  = dbOperationDAO.deleteById(UserVO.class,list.get(0).getId());
        dbOperationDAO.closeCurrentSessionWithTransaction();
        return result;
    }

    public void update(UserVO userVO, int user_id){
        dbOperationDAO.openCurrentSessionWithTransaction();
        UserVO userVO1 = dbOperationDAO.getCurrentSession().load(UserVO.class,user_id);
        userVO1.setPassword(userVO.getPassword());
        userVO1.setUsername(userVO.getUsername());
        userVO1.setAccountStatus(userVO.getAccountStatus());
        userVO1.setEmployeeVO(userVO.getEmployeeVO());
        userVO1.setUserLevel(userVO.getUserLevel());
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }



}
