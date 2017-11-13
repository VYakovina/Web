package ua.yakov.service;


import ua.yakov.entity.UserPass;

import java.util.List;

public interface UserPassService {
    UserPass addUserPass(UserPass userpass);
    UserPass getByUserNameAndUserPass(String uname, String upass);
    UserPass getByUserName(String uname);
}
