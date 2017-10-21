package ua.yakov;

import net.sf.ehcache.search.query.QueryManager;
import org.hibernate.internal.SessionImpl;
import org.hibernate.query.Query;
import ua.yakov.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogCommand implements Command {

    UserPass user = new UserPass();
    DaoService daoService = new DaoService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String userName = request.getParameter("uname");
        String userPass = request.getParameter("upass");

        if (daoService.exists(userName,userPass) == null )  {
            return "reg.jsp";
        } else {
            return "index.jsp";
        }
    }
}
