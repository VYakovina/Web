package ua.yakov.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.yakov.entity.UserPass;
import ua.yakov.repository.UserPassRepository;
import ua.yakov.service.UserPassService;
@Service
public class UserPassServiceImpl implements UserPassService {

    @Autowired
    UserPassRepository userPassRepository;

    @Override
    public UserPass addUserPass(UserPass userpass) {
        UserPass savedUserPass = userPassRepository.saveAndFlush(userpass);
        return savedUserPass;
    }

    @Override
    public UserPass getByUserName(String uname, String upass) {
      return  userPassRepository.findByName(uname,upass);
    }
}
