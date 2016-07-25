package ru.my.quest.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by maksim on 4/21/2016.
 */
@Configuration
@EnableJpaRepositories("ru.my.quest.repository")
@ComponentScan("ru.my.quest")
public class DataAccess {

    @Value("${db.driver}")
    private String driver;
    @Value("${db.url}")
    private String url;
    @Value("${db.user}")
    private String user;
    @Value("${db.password}")
    private String password;

    @Bean
    DriverManagerDataSource dataSource() {
        final DriverManagerDataSource dm = new DriverManagerDataSource();
        dm.setDriverClassName(driver);
        dm.setUrl(url);
        dm.setUsername(user);
        dm.setPassword(password);
        return dm;
    }

    @Bean
    EntityManagerFactory entityManagerFactory(){

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setDatabase(Database.MYSQL);
        vendorAdapter.setShowSql(true);

        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
        entityManagerFactory.setPackagesToScan("ru.my.quest.model.entity");
        entityManagerFactory.afterPropertiesSet();
        return entityManagerFactory.getObject();
    }

   // @Bean
    JpaTransactionManager transactionManager(){
        SortedSet sortedSet = new TreeSet<>();

        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }



}
