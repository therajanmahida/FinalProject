package Controller.Dashboard;

import VO.BreadCrumbVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet(name = "Dashboard",urlPatterns = {"/dashboard"})
public class Dashboard extends HttpServlet {
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LinkedList<BreadCrumbVO> list = new LinkedList<>();
        list.add(new BreadCrumbVO("Home",""));
        request.setAttribute("bread_crumb",list);

        request.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request,response);




    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request,response);
    }
}
