package ua.yakov.configur;

import org.springframework.core.env.Environment;

import javax.annotation.Resource;
import java.util.Properties;

public class DataConfig {
    @Resource
    private Environment env;

private Properties getHibernateProperties(){
    Properties properties = new Properties();


    return properties;
}

}
