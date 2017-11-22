package ua.yakov.validation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ua.yakov.entity.Customer;
import ua.yakov.entity.UserPass;
import ua.yakov.service.impl.CustorerServiceImpl;
import ua.yakov.service.impl.UserPassServiceImpl;

@Component
public class LogicDao {

    @Autowired
    Customer cus;
    @Autowired
    UserPass user;
    @Autowired
    CustorerServiceImpl custorerService;
    @Autowired
    UserPassServiceImpl userPassService;
    @Autowired
    PasswordEncoder passwordEncoder;

    public void  Regist (CusUser cusUser){
        cus.getId();
        user.setCustomerUser(cus);
        cus.setEmail(cusUser.getEmail());
        cus.setCustomerName(cusUser.getFname());
        user.setUsername(cusUser.getUsername());
        user.setPassword(passwordEncoder.encode(cusUser.getPassword()));
        custorerService.addCustomer(cus);
        userPassService.addUserPass(user);

    }

    public boolean RegLog(CusUser cusUser){

        if(userPassService.getByUserName(cusUser.getUsername()) == null){
            return true;
        }
        return false;
    }

}
