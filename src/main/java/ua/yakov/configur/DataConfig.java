package ua.yakov.configur;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:propertyFile.properties")
public class DataConfig   {
    @Resource
    private Environment env;


private Properties getHibernateProperties(){
    Properties properties = new Properties();
    properties.put("hibernate.dialect",env.getRequiredProperty("db.hibernate.dialect"));
    properties.put("hibernate.show_sql",env.getRequiredProperty("db.hibernate.show_sql"));
    properties.put("hibernate.hbm2ddl.auto",env.getRequiredProperty("db.hibernate.hbm2ddl.auto"));
    properties.put("hibernate.connection.CharSet",env.getRequiredProperty("db.hibernate.connection.CharSet"));
    properties.put("hibernate.connection.characterEncoding",env.getRequiredProperty("db.hibernate.connection.characterEncoding"));
    properties.put("hibernate.connection.useUnicode",env.getRequiredProperty("db.hibernate.connection.useUnicode"));
    properties.put("hibernate.connection.autocommit",env.getRequiredProperty("db.hibernate.connection.autocommit"));
    properties.put("hibernate.cache.region.factory_class",env.getRequiredProperty("db.hibernate.cache.region.factory_class"));
    properties.put("hibernate.javax.cache.provider",env.getRequiredProperty("db.hibernate.javax.cache.provider"));
    properties.put("hibernate.cache.use_second_level_cache",env.getRequiredProperty("db.hibernate.cache.use_second_level_cache"));
    properties.put("hibernate.generate_statistics",env.getRequiredProperty("db.hibernate.generate_statistics"));

    return properties;
}
 @Bean
public DataSource dataSource (){
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(env.getRequiredProperty("db.driver_class"));
    dataSource.setUrl(env.getRequiredProperty("db.url"));
    dataSource.setUsername(env.getRequiredProperty("db.username"));
    dataSource.setPassword(env.getRequiredProperty("db.password"));
return dataSource;

}

@Bean
    public LocalContainerEntityManagerFactoryBean  entityManagerFactory(){
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
    entityManagerFactoryBean.setDataSource(dataSource());
    entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
    entityManagerFactoryBean.setPackagesToScan(env.getRequiredProperty("db.entitymanager.packages.to.scan"));
    entityManagerFactoryBean.setJpaProperties(getHibernateProperties());
    return entityManagerFactoryBean;
}

    @Bean
    public Logger getGetLogger() {
         return LogManager.getLogger("ua.yakov.repositpry");
    }

    @Bean(name = "userDetailsService")
    public UserDetailsService userDetailsService() {
        JdbcDaoImpl jdbcDao = new JdbcDaoImpl();
        jdbcDao.setDataSource(dataSource());
        jdbcDao.setUsersByUsernameQuery("select userName, userPass from UserPass where userName =?");
        jdbcDao.setAuthoritiesByUsernameQuery("select u.userName,r.nameRole from UserPass u, Roles r where u.id = r.userId" +
                " and u.userName = ?");
        return jdbcDao;
    }
}
