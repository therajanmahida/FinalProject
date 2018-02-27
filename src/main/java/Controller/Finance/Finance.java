package Controller.Finance;

import VO.BreadCrumbVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet(name = "Finance",urlPatterns = {"/finance"})
public class Finance extends HttpServlet {
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BreadCrumbVO _send_bread_crumb = new BreadCrumbVO();
        _send_bread_crumb.addData("zPharma","/");
        _send_bread_crumb.addData("Finance","/finance");
        request.setAttribute("bread_crumb",_send_bread_crumb);



        request.getRequestDispatcher("/WEB-INF/jsp/finance.jsp").forward(request,response);




    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request,response);
    }
}
