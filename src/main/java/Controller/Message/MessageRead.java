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
import java.util.List;

@WebServlet(name = "MessageRead",urlPatterns = {"/message/read/"})
public class MessageRead extends HttpServlet {
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String integers = request.getParameter("doc_id");
            if(integers == null || integers.isEmpty() ){
                response.sendRedirect("/message-inbox");
            }else{
                int message_id = Integer.parseInt(integers);
                request.getSession().setAttribute("current_read_message_id",message_id);

                MessageToDAO messageToDAO = new MessageToDAO();
                List<MessageToVO> messageToVO = messageToDAO.getMessageToVOList(message_id);

                //Set is read = 1
                MessageToVO messageToVO1 = messageToVO.get(0);
                messageToVO1.setIsRead(1);
                messageToDAO.update(messageToVO1,messageToVO1.getId());


                request.setAttribute("message",messageToVO.get(0));
                request.getRequestDispatcher("/WEB-INF/jsp/message_read.jsp").forward(request,response);

            }




    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request,response);
    }
}
