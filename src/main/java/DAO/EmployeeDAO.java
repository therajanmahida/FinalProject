package DAO;

import DAO.Global.DBOperationDAO;
import VO.EmployeeVO;
import org.hibernate.Query;

import java.util.Date;
import java.util.List;

public class EmployeeDAO {
    EmployeeVO employeeVO;
    DBOperationDAO dbOperationDAO;
    List<EmployeeVO> list;

    public EmployeeDAO(){
        this.dbOperationDAO = new DBOperationDAO();
    }

    public List<EmployeeVO> getEmployeeVOList() {
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.EmployeeVO");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<EmployeeVO> getEmployeeVOListByName(String _employee_name) {
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.EmployeeVO where employeeName='"+_employee_name+"'");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<EmployeeVO> getEmployeeVOListByCompany(int _company_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.EmployeeVO where companyVO.id="+_company_id);
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public int getEmployeeQuantity(int _company_id){
        list = getEmployeeVOListByCompany(_company_id);
        return list.size();
    }

    public List<EmployeeVO> getEmployeeVOListByDepartment(int _department_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.EmployeeVO where departmentVO.id="+_department_id);
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<EmployeeVO> getEmployeeVOListByOutlet(int _outlet_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.EmployeeVO where outletVO.id="+_outlet_id);
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<EmployeeVO> getEmployeeVOListByWorkingStatus(EmployeeVO.WorkingStatus _status){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.EmployeeVO where currentStatus='"+_status+"'");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<EmployeeVO> getEmployeeVOListByJoiningDate(Date date){
        dbOperationDAO.openCurrentSession();
        Query query = dbOperationDAO.getCurrentSession().createQuery("from VO.EmployeeVO where joiningDate = :date");
        query.setDate("date",date);
        list = query.list();
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<EmployeeVO> getEmployeeVOListByDesignation(EmployeeVO.Designation _designation){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.EmployeeVO where designation='"+_designation.toString()+"'");
        dbOperationDAO.closeCurrentSession();
        return list;
    }


    public EmployeeVO load(int _employee_id){
        dbOperationDAO.openCurrentSession();
        EmployeeVO employeeVO = dbOperationDAO.load(EmployeeVO.class,_employee_id);
        dbOperationDAO.closeCurrentSession();
        return employeeVO;
    }

    public void deleteById(int _employee_id){
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.deleteById(EmployeeVO.class,_employee_id);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }

    public void insert(EmployeeVO employeeVO){
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.insert(employeeVO);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }

    public void update(EmployeeVO employeeVO,int _employee_id){
        dbOperationDAO.openCurrentSessionWithTransaction();
        employeeVO.setId(_employee_id);
        dbOperationDAO.update(employeeVO);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }





}
