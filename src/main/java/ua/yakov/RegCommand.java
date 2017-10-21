package ua.yakov;

import ua.yakov.Command;
import ua.yakov.Customer;
import ua.yakov.DaoService;
import ua.yakov.UserPass;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegCommand implements Command {

    DaoService daoService = new DaoService();
    UserPass user = new UserPass();
    Customer cus  = new Customer();

    @Override
    public  String execute(HttpServletRequest request, HttpServletResponse response) {
        String uname = request.getParameter("fname");
        String userName = request.getParameter("uname");
        String userPass = request.getParameter("upass");
        String userMail = request.getParameter("email");
            cus.getId();
            user.setCustomerUser(cus);
            cus.setEmail(userMail);
            cus.setCustomerName(uname);
            user.setUserName(userName);
            user.setUserPass(userPass);
            daoService.persist(cus);
            daoService.persist(user);

        return "log.jsp";
    }
}
