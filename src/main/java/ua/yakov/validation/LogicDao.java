package ua.yakov.validation;


import org.springframework.stereotype.Component;
import ua.yakov.entity.Customer;
import ua.yakov.dao.DaoService;
import ua.yakov.entity.UserPass;

@Component
public class LogicDao {


    public void  Regist (CusUser cusUser){

        Customer cus = new Customer();
        UserPass user = new UserPass();
        DaoService daoService = new DaoService();

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
        DaoService daoService = new DaoService();
        if(daoService.exists(cusUser.getUname(),cusUser.getUpass()) == null){
           return true;
        }
        return false;
    }

    public boolean RegLog(CusUser cusUser){
        DaoService daoService = new DaoService();
        if(daoService.userExists(cusUser.getRname()) == null){
            return true;
        }
        return false;
    }



}
