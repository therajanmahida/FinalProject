package Controller.Employee.Portal;

import VO.BreadCrumbVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet(name = "EmployeePortal",urlPatterns = {"/staff/employee"})
public class Employee extends HttpServlet {
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LinkedList<BreadCrumbVO> breadCrumbVOS = new LinkedList<>();
        breadCrumbVOS.add(new BreadCrumbVO("Pharma","/home"));
        breadCrumbVOS.add(new BreadCrumbVO("Staff","/staff"));
        breadCrumbVOS.add(new BreadCrumbVO("Employee",null));
        request.setAttribute("bread_crumb",breadCrumbVOS);
        request.setAttribute("page_name","Employee");


        request.getRequestDispatcher("/WEB-INF/jsp/employee_portal.jsp").forward(request,response);




    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request,response);
    }
}
