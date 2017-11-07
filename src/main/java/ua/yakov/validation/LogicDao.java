package ua.yakov.validation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.yakov.entity.Customer;
import ua.yakov.dao.DaoService;
import ua.yakov.entity.UserPass;

@Component
public class LogicDao {

    @Autowired
    Customer cus;
    @Autowired
    UserPass user;
    @Autowired
    DaoService daoService;

    public void  Regist (CusUser cusUser){
        cus.getId();
        user.setCustomerUser(cus);
        cus.setEmail(cusUser.getEmail());
        cus.setCustomerName(cusUser.getFname());
        user.setUserName(cusUser.getUname());
        user.setUserPass(cusUser.getUpass());
        daoService.persist(cus);
        daoService.persist(user);

    }

    public boolean LogIncor(CusUser cusUser){

        if(daoService.exists(cusUser.getUname(),cusUser.getUpass()) == null){
           return true;
        }
        return false;
    }

    public boolean RegLog(CusUser cusUser){

        if(daoService.userExists(cusUser.getUname()) == null){
            return true;
        }
        return false;
    }



}
