package ua.yakov;

import net.sf.ehcache.search.query.QueryManager;
import org.hibernate.internal.SessionImpl;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import ua.yakov.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class LogCommand implements Command {

    DaoService daoService = new DaoService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String userName = request.getParameter("uname");
        String userPass = request.getParameter("upass");

        if (daoService.exists(userName,userPass) == null )  {
            return "register.jsp";
        } else {
            return "index.jsp";
        }
    }
}
