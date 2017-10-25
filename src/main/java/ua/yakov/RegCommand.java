package ua.yakov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import ua.yakov.Command;
import ua.yakov.Customer;
import ua.yakov.DaoService;
import ua.yakov.UserPass;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes(types = {CusUser.class})
//@WebServlet(name = "log", urlPatterns = "/log")
public class RegCommand  {

    @Autowired
    DaoService daoService;
    @Autowired
    HttpSession session;
    @Autowired
    LogicDao logicDao;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegForm(Model model) {
        CusUser user = new CusUser();
        model.addAttribute("registrationUser", user);
        return "register";
    }


    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public ModelAndView doReg(@ModelAttribute("registrationUser") @Validated CusUser cusUser, BindingResult result){
        ModelAndView mod = new ModelAndView();

        if (result.hasErrors()) {

            mod.setViewName("register");
        } else {
            logicDao.Regist(cusUser);
            mod.setViewName("log");
        }
            return mod;
    }

    /*@Override
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
    }*/
}
