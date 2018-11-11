package com.nabil.animes.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

import static org.hibernate.cfg.AvailableSettings.*;
import static org.hibernate.cfg.AvailableSettings.C3P0_MAX_STATEMENTS;

@Configuration
@EnableWebMvc
@PropertySource("classpath:database.properties")
@EnableTransactionManagement
@ComponentScan(basePackages = "com.nabil.animes")
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    private Environment env;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("WEB-INF/resources/");
    }

    @Bean
    public ViewResolver viewResolver() {
        return new InternalResourceViewResolver("/WEB-INF/jsp/", ".jsp");
    }

    @Bean
    public Properties getJDBCProperties() {
        Properties properties = new Properties();
        properties.put(DRIVER, env.getProperty("postgres.driver"));
        properties.put(URL, env.getProperty("postgres.url"));
        properties.put(USER, env.getProperty("postgres.username"));
        properties.put(PASS, env.getProperty("postgres.password"));
        return properties;
    }


    @Bean
    public Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
        properties.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put(DIALECT, env.getProperty("hibernate.dialect"));
        return properties;
    }

    @Bean
    public Properties getC3POProperties() {
        Properties properties = new Properties();
        properties.put(C3P0_MIN_SIZE, env.getProperty("c3p0.min_size"));
        properties.put(C3P0_MAX_SIZE, env.getProperty("c3p0.max_size"));
        properties.put(C3P0_ACQUIRE_INCREMENT, env.getProperty("c3p0.acquire_increment"));
        properties.put(C3P0_TIMEOUT, env.getProperty("c3p0.timeout"));
        properties.put(C3P0_MAX_STATEMENTS, env.getProperty("c3p0.max_statements"));
        return properties;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory() throws PropertyVetoException {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setHibernateProperties(getJDBCProperties());
        factoryBean.setDataSource(getDataSource());
        factoryBean.setPackagesToScan("com.nabil.animes.model");
        return factoryBean;
    }

    @Bean
    public DataSource getDataSource() throws PropertyVetoException {
        //use com.mchange.v2.c3p0.ComboPooledDataSource
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        // use org.apache.commons.dbcp2.BasicDataSource
        //BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClass(getJDBCProperties().getProperty(DRIVER));
        dataSource.setJdbcUrl(getJDBCProperties().getProperty(URL));
        dataSource.setUser(getJDBCProperties().getProperty(USER));
        dataSource.setPassword(getJDBCProperties().getProperty(PASS));
        return dataSource;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() throws PropertyVetoException {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }

}
