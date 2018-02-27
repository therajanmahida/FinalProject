package Controller.Finance;

import VO.BreadCrumbVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Set;

@WebServlet(name = "Finance",urlPatterns = {"/finance"})
public class Finance extends HttpServlet {
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //BreadCrumbVO _send_bread_crumb = new BreadCrumbVO();
        LinkedList<BreadCrumbVO> _list = new LinkedList<>();
        _list.add(new BreadCrumbVO("Pharma","home"));
        _list.add(new BreadCrumbVO("Finance","finance"));
        _list.add(new BreadCrumbVO("page",null));
        request.setAttribute("bread_crumb",_list);



        request.getRequestDispatcher("/WEB-INF/jsp/finance.jsp").forward(request,response);




    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request,response);
    }
}
