package Listener;

import DAO.MessageDAO;
import DAO.MessageToDAO;
import VO.DrugVO;
import VO.MessageToVO;
import VO.StateCity;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Scanner;

@WebListener()
public class Listener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    // Public constructor is required by servlet spec
    public Listener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce){

        String url = sce.getServletContext().getRealPath("/WEB-INF/Resources/stateCity.html");
        File file = new File(url);
        Document document = null;
        try {
            document = Jsoup.parse(file,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        LinkedList<StateCity> list = new LinkedList<>();
        Elements ele = document.getElementsByTag("state");
        ele.forEach(element -> {
            StateCity stateCity = new StateCity();
            Elements e = element.getElementsByTag("name");
            stateCity.setStateName(e.get(0).html());
            Elements eles = element.getElementsByTag("city");
            eles.forEach(element1 -> {
                stateCity.getCityName().add(element1.html());
            });
            list.add(stateCity);
        });

        sce.getServletContext().setAttribute("state_city",list);




    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */

        final MessageToDAO messageToDAO = new MessageToDAO();

       //new Thread(() -> se.getSession().setAttribute("unread_message",messageToDAO.getUnreadMessage(1))).start();




    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }
}
