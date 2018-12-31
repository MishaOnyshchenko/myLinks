package com.links.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.links")
@PropertySource("classpath:application.properties")
public class HibernateConfig {

    @Value("${spring.datasource.username}")
    private String userName;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.url}")
    private String jdbcUrl;
    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    @Value("${packagesToScan}")
    private String scanPackage;
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlAuto;
    @Value("${spring.jpa.properties.hibernate.dialect}")
    private String hibernateDialect;
    @Value("${spring.datasource.initialization-mode}")
    private String initDataSQl;
    @Value("${spring.jpa.properties.hibernate.enable_lazy_load_no_trans}")
    private String lazyLoad;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        return dataSource;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", hibernateDialect);
        properties.put("hibernate.hbm2ddl.auto", ddlAuto);
        properties.put("spring.datasource.initialization-mode", initDataSQl);
        properties.put("spring.jpa.properties.hibernate.enable_lazy_load_no_trans", lazyLoad);

        return properties;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan(scanPackage);
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        return sessionFactoryBean;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }
}
