package ua.yakov.configur;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.yakov.dao.InfoDao;

/*@PropertySource("classpath:propertyFile.properties")*/
@Configuration
public class Cofigur {

    @Bean
    public InfoDao getInfoDao() {
        return new InfoDao();
    }

}
