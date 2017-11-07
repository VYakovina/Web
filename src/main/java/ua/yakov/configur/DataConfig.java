package ua.yakov.configur;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ua.yakov.dao.Dao;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
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
    @Qualifier(value = "jpaTransactionManager")
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

    @Bean
    public Dao getDao() {
        return new Dao();
    }



}
