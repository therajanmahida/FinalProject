import DAO.MessageToDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "Filter")
public class Filter implements javax.servlet.Filter {
    MessageToDAO messageToDAO;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        request.getSession().setAttribute("unread_message",messageToDAO.getUnreadMessage(1));
        request.getSession().setAttribute("total_message",messageToDAO.getTotolMessage(1));
        request.getSession().setAttribute("new_message_today",messageToDAO.getTodayMessage(1));
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        messageToDAO = new MessageToDAO();
    }

}
