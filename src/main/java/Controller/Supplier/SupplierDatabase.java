package Controller.Supplier;

import DAO.SupplierDAO;
import VO.SupplierDocumentVO;
import VO.SupplierVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SupplierDatabase",urlPatterns = {"/supplier/database"})
public class SupplierDatabase extends HttpServlet {
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SupplierDAO supplierDAO = new SupplierDAO();
        List<SupplierVO> list = supplierDAO.getSupplierVOList(1);
        //response.getWriter().print(list);
        request.setAttribute("supplier_list",list);

        request.getRequestDispatcher("/WEB-INF/jsp/supplier_database.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request,response);
    }
}
