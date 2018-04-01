package Controller.Message;

import DAO.MessageDAO;
import DAO.MessageToDAO;
import VO.MessageToVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "MessageInbox",urlPatterns = {"/message/inbox"})
public class MessageInbox extends HttpServlet {
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MessageToDAO messageToDAO = new MessageToDAO();
        List<MessageToVO> message_list  = messageToDAO.getMessageToVOListByUserTo(1);
        Collections.reverse(message_list);
        request.setAttribute("message_list",message_list);




        request.getRequestDispatcher("/WEB-INF/jsp/message_inbox.jsp").forward(request,response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request,response);
    }
}
