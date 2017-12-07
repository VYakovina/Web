package ua.yakov.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



import java.security.Principal;
import java.util.List;

@Controller
@SessionAttributes(types = {CusUser.class})
public class RegConrtroller {

    @Autowired
    LogicDao logicDao;
/*    @Autowired
    LogValidator logValidator;*/
    @Autowired
    RegValidator regValidator;

    @RequestMapping(value = "/log", method = RequestMethod.GET)
    public ModelAndView getLog () {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("log");
       /* CusUser user = new CusUser();
        model.addAttribute("loginUser", user);*/
        return modelAndView;
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

        if (result.hasErrors()) {
            mod.setViewName("register");
        } else {
            logicDao.Regist(cusUser);
            mod.setViewName("log");
        }
            return mod;
    }
  @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView doLog( Principal principal){
        ModelAndView mod = new ModelAndView();

            mod.setViewName("user/welcome");

       return mod;
    }

   /* @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getIndex() {
        ModelAndView model = new ModelAndView();
        model.setViewName("start");
        return model;
    }*/

    @RequestMapping(value = "/protected/**", method = RequestMethod.GET)
    public ModelAndView protectedPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("/protected/protect");
        return model;
      }

    @RequestMapping(value = "/user/**", method = RequestMethod.GET)
    public ModelAndView userPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("/user/welcome");
        return model;
    }


    @InitBinder("registrationUser")
    protected void regValidator(WebDataBinder binder) {
        binder.setValidator(this.regValidator); }

}
