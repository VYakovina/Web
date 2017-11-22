package ua.yakov.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class RegValidator implements Validator {
    @Autowired
    LogicDao logicDao;
    @Override
    public boolean supports(Class<?> calzz) {
        return CusUser.class.equals(calzz);
    }

    @Override
    public void validate(Object obj, Errors errors) {

        CusUser  cusUser = (CusUser) obj;
        if (logicDao.RegLog(cusUser) == false) {
            errors.rejectValue("username","error.RegLogExists");
        }

    }
}
