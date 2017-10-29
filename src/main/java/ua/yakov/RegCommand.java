package ua.yakov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
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
public class RegCommand  {

    @Autowired
    LogicDao logicDao;

    @RequestMapping(value = "/log", method = RequestMethod.GET)
    public String getLog (Model model) {
        CusUser user = new CusUser();
        model.addAttribute("loginUser", user);
        return "log";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegForm(Model model) {
        CusUser user = new CusUser();
        model.addAttribute("registrationUser", user);
        return "register";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public ModelAndView doReg(@ModelAttribute("registrationUser") @Validated CusUser cusUser, BindingResult result){
        ModelAndView mod = new ModelAndView();


        if(logicDao.RegLog(cusUser) == true){
            logicDao.Regist(cusUser);
            mod.setViewName("log");
        } else{
            mod.setViewName("index");
        }
            return mod;
    }

    @RequestMapping(value = "/log", method = RequestMethod.POST)
    public ModelAndView doLog(@ModelAttribute("loginUser") @Validated CusUser cusUser, BindingResult result){
        ModelAndView mod = new ModelAndView();

        if(logicDao.Log(cusUser) == true){
            mod.setViewName("index");
        } else{
            mod.setViewName("welcome");
        }
        return mod;
    }


}
