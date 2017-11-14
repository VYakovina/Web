package ua.yakov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.yakov.entity.UserPass;

public interface UserPassRepository extends JpaRepository<UserPass, Integer> {

    @Query("select c from UserPass c where c.userName = :uname and c.userPass = :upass")
    UserPass findByName(@Param("uname") String uname, @Param("upass") String upass);

    @Query("select c from UserPass c where c.userName = :uname")
    UserPass findByUserName(@Param("uname") String uname);
}
