package ua.yakov.repository;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = {"ua.yakov.repository"})
@EntityScan(basePackages = {"ua.yakov.entity"})
@EnableTransactionManagement
public class RepositoryConfigaration {
}
