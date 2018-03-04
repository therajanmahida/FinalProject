package Controller;

import DAO.*;
import DAO.Global.DBOperationDAO;
import VO.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.PrintWriter;
import java.util.*;

@javax.servlet.annotation.WebServlet(name = "Tester",urlPatterns = {"/tester"})
public class Tester extends javax.servlet.http.HttpServlet {
    protected void doProcess(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
            response.getWriter().println("Done");


        EmployeeDAO employeeDAO = new EmployeeDAO();
        CompanyDAO companyDAO = new CompanyDAO();
        DepartmentDAO departmentDAO = new DepartmentDAO();
        EmployeeVO employeeVO = new EmployeeVO();
        employeeVO.setComanyVO(companyDAO.load(1));
        employeeVO.setAadhaarNo("qwertyui");
        employeeVO.setAddress("B/91 pritamnagar society");
        employeeVO.setCity("Vadodara");
        employeeVO.setContactNumberOne("dfghjk");
        employeeVO.setContactNumberTwo("gsdfsd");
        employeeVO.setCurrentStatus(EmployeeVO.WorkingStatus.CURRENT);
        employeeVO.setDate(new Date(1996,05,14));
        List<DepartmentVO> list = new LinkedList<>();
        list.add(departmentDAO.load(1));
        list.add(departmentDAO.load(2));
        employeeVO.setDepartmentVO(list);
        employeeVO.setDesignation(EmployeeVO.Designation.HEAD);
        employeeVO.setEmployeeName("Tarang Parikh");
        employeeVO.setState("Gujarat");
        employeeVO.setJoiningDate(new Date(2015,07,26));
        employeeDAO.insert(employeeVO);







    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
            doProcess(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
            doProcess(request,response);
    }
}
