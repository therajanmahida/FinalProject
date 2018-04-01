package DAO;

import DAO.Global.DBOperationDAO;

import VO.SalaryVO;

import java.util.List;

public class SalaryDAO {
    SalaryVO salaryVO;
    DBOperationDAO dbOperationDAO;
    List<SalaryVO> list;

    public SalaryDAO(){
        this.dbOperationDAO = new DBOperationDAO();
    }

    public List<SalaryVO> getSalarVOList(){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.SalaryVO");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<SalaryVO> getSalaryVOListById(int _id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.SalaryVO where id="+_id);
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<SalaryVO> getSalaryVOListByCompanyId(int _company_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.SalaryVO where companyVO.id="+_company_id);
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<SalaryVO> getSalaryVOListByDepartmentId(int _department_id){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.SalaryVO where departmentVO.id="+_department_id);
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public List<SalaryVO> getSalaryVOListByLevel(SalaryVO.Position _position){
        dbOperationDAO.openCurrentSession();
        list = dbOperationDAO.getList("from VO.SalaryVO where salaryLevel='"+_position.toString()+"'");
        dbOperationDAO.closeCurrentSession();
        return list;
    }

    public void deleteById(int _salary_id){
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.deleteById(SalaryVO.class,_salary_id);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }

    public void insert(SalaryVO salaryVO){
        dbOperationDAO.openCurrentSessionWithTransaction();
        dbOperationDAO.insert(salaryVO);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }

    public void update(SalaryVO salaryVO,int _salary_id){
        dbOperationDAO.openCurrentSessionWithTransaction();
        salaryVO.setId(_salary_id);
        dbOperationDAO.update(salaryVO);
        dbOperationDAO.closeCurrentSessionWithTransaction();
    }







}
