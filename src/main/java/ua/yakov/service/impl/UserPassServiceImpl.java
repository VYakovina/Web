package ua.yakov.service.impl;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.yakov.entity.UserPass;
import ua.yakov.repository.UserPassRepository;
import ua.yakov.service.UserPassService;

import java.util.List;


@Service
public class UserPassServiceImpl implements UserPassService {

    @Autowired
    UserPassRepository userPassRepository;
   @Autowired
    Logger logger;

    @Override
    public UserPass addUserPass(UserPass userpass) {
        UserPass savedUserPass = userPassRepository.saveAndFlush(userpass);
       logger.info("exist");
        return savedUserPass;
    }

   /* @Override
    public UserPass getByUserNameAndUserPass(String uname, String password) {
      return  userPassRepository.findByName(uname,password);
    }*/

    @Override
    public UserPass getByUserName(String username) {
         return  userPassRepository.findByUserName(username);
    }
}
