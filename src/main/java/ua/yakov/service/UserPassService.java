package ua.yakov.service;


import ua.yakov.entity.UserPass;

public interface UserPassService {
    UserPass addUserPass(UserPass userpass);
    UserPass getByUserName(String uname, String upass);
}
