package ua.yakov;

import org.springframework.stereotype.Component;

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

    public boolean Log(CusUser cusUser){
        DaoService daoService = new DaoService();
        if(daoService.exists(cusUser.getUname(),cusUser.getUpass()) == null){
           return true;
        }
        return false;
    }

    public boolean RegLog(CusUser cusUser){
        DaoService daoService = new DaoService();
        if(daoService.userExists(cusUser.getUname()) == null){
            return true;
        }
        return false;
    }

}
