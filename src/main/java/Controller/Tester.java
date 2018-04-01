package Controller;

import DAO.*;
import DAO.Global.DBOperationDAO;
import VO.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@javax.servlet.annotation.WebServlet(name = "Tester",urlPatterns = {"/tester"})
public class Tester extends javax.servlet.http.HttpServlet {
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        MessageToDAO messageToDAO = new MessageToDAO();
        response.getWriter().print(messageToDAO.getUnreadMessage(1));
        //request.getRequestDispatcher("/WEB-INF/jsp/check.jsp").forward(request,response);

    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
            doProcess(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
            doProcess(request,response);
    }
}
