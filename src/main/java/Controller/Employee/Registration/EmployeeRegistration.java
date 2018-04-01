package Controller.Employee.Registration;

import DAO.DepartmentDAO;
import DAO.OutletDAO;
import DAO.SalaryDAO;
import VO.BreadCrumbVO;
import VO.DepartmentVO;
import VO.OutletVO;
import VO.SalaryVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "EmployeeRegistration",urlPatterns = {"/employee-register"})
public class EmployeeRegistration extends HttpServlet {
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //BreadCrumbVO _send_bread_crumb = new BreadCrumbVO();


        LinkedList<BreadCrumbVO> list = new LinkedList<>();
        list.add(new BreadCrumbVO("Home","dashboard"));
        list.add(new BreadCrumbVO("Staff","employee-registration"));
        list.add(new BreadCrumbVO("Registration",null));
        request.setAttribute("bread_crumb",list);

        DepartmentDAO departmentDAO = new DepartmentDAO();
        List<DepartmentVO> department_list = departmentDAO.getDepartmentVOList();
        request.setAttribute("department_list",department_list);

        OutletDAO outletDAO = new OutletDAO();
        List<OutletVO> outlet_list;
        try{
            outlet_list = outletDAO.getOutletVOList();
        }catch (NullPointerException e){
            outlet_list = new LinkedList<>();
        }

        SalaryDAO salaryDAO = new SalaryDAO();
        List<SalaryVO> salary_list;
        try{
            salary_list = salaryDAO.getSalarVOList();
        }catch (NullPointerException e){
            salary_list = new LinkedList<>();
        }
        request.setAttribute("salary_list",salary_list);

        request.getRequestDispatcher("/WEB-INF/jsp/employee_registration.jsp").forward(request,response);




    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request,response);
    }
}
