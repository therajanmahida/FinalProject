package Controller;

import VO.UserVO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@javax.servlet.annotation.WebServlet(name = "Tester",urlPatterns = {"/tester"})
public class Tester extends javax.servlet.http.HttpServlet {
    protected void doProcess(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
            response.getWriter().println("Done");

        SessionFactory _facSessionFactory = new Configuration().configure().addAnnotatedClass(UserVO.class).buildSessionFactory();
        Session _session =  _facSessionFactory.getCurrentSession();
        _session.beginTransaction();

        _session.flush();
        _session.clear();
        _session.getTransaction().commit();



    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
            doProcess(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
            doProcess(request,response);
    }
}
