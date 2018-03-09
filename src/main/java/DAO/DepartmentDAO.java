package DAO;

import DAO.Global.DBOperationDAO;
import VO.DepartmentVO;

import java.util.List;

public class DepartmentDAO {
    DepartmentVO departmentVO;
    DBOperationDAO dbOperationDAO;
    List<DepartmentVO> list;

    public DepartmentDAO(){
        this.dbOperationDAO = new DBOperationDAO();
    }

    public List<DepartmentVO> getDepartmentVOList() {
        dbOperationDAO.openCurrentSession();
        list  = dbOperationDAO.getList("from VO.DepartmentVO");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<DepartmentVO> getDepartmetVoListById(int _department_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.DepartmentVO where id="+_department_id);
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public DepartmentVO load(int _department_id){
        dbOperationDAO.openCurrentSession();
        DepartmentVO _send  = dbOperationDAO.load(DepartmentVO.class,_department_id);
        dbOperationDAO.closeCurrentSession();
        return _send;
    }


    public List<DepartmentVO> getDepartmentVOListByName(String _department_name){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.DepartmentVO where DepartmentName='"+_department_name+"'");
        dbOperationDAO.closeCurrentSession();
        return list;
    }
    public List<DepartmentVO> getDepartmentVOListByCompanyId(int _company_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.DepartmentVO where companyVO.id="+_company_id);
        dbOperationDAO.closeCurrentSession();
        return list;
    }


    public void deleteById(int _department_id){
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.deleteById(DepartmentVO.class,_department_id);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }

    public void insert(DepartmentVO departmentVO){
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.insert(departmentVO);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }

    public void update(DepartmentVO departmentVO,int _company_id){
        dbOperationDAO.openCurrentSessionWithTransaction();
        departmentVO.setId(_company_id);
        dbOperationDAO.update(departmentVO);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }




}
