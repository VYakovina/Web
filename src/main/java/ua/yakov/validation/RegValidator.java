package ua.yakov.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class RegValidator implements Validator {
    @Override
    public boolean supports(Class<?> calzz) {
        return CusUser.class.equals(calzz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        LogicDao logicDao = new LogicDao();
        CusUser  cusUser = (CusUser) obj;
        if (logicDao.RegLog(cusUser) == false) {
            errors.rejectValue("rname","error.RegLogExists");
        }

    }
}
