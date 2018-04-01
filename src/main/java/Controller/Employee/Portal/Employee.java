package Controller.Employee.Portal;

import DAO.EmployeeDAO;
import VO.BreadCrumbVO;
import VO.EmployeeVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "EmployeePortal",urlPatterns = {"/employee-list"})
public class Employee extends HttpServlet {
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LinkedList<BreadCrumbVO> list = new LinkedList<>();
        list.add(new BreadCrumbVO("Home","dashboard"));
        list.add(new BreadCrumbVO("Staff","employee-registration"));
        list.add(new BreadCrumbVO("List",null));
        request.setAttribute("bread_crumb",list);

        EmployeeDAO employeeDAO = new EmployeeDAO();
        List<EmployeeVO> employee_list = employeeDAO.getEmployeeVOListByCompany(1);
        request.setAttribute("employee_list",employee_list);

        request.getRequestDispatcher("/WEB-INF/jsp/employee_list.jsp").forward(request,response);




    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request,response);
    }
}
