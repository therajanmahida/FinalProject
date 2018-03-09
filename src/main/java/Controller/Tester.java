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
        employeeDAO.deleteById(1);






    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
            doProcess(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
            doProcess(request,response);
    }
}
