package ua.yakov;

import net.sf.ehcache.search.query.QueryManager;
import org.hibernate.internal.SessionImpl;
import org.hibernate.query.Query;
import ua.yakov.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogCommand implements Command {

    UserPass user = new UserPass();
    QueryManager session;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String userName = request.getParameter("uname");


        Query q = (Query) session.createQuery("select u from UserPass u where u.userName = :userName");
        q.setParameter("userName",userName);

        if (userName.equals("userName")) {
            return "reg.jsp";
        } else {
            return "index.jsp";
        }
    }
}
