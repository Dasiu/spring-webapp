package com.dasiubat.config;

import org.h2.jdbcx.JdbcDataSource;
import org.h2.tools.Server;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Adam on 2014-05-06.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories({"com.dasiubat.service"})
public class SharedDBConfiguration {
    @Autowired
    private DataSource dataSource;
//    @Resource
//    private Properties hibernateProperties;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
        emfb.setPackagesToScan("com.dasiubat.domain");
        emfb.setJpaVendorAdapter(jpaVendorAdapter());
        emfb.setJpaProperties(getHibernateProperties());
        emfb.setDataSource(dataSource);
        return emfb;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        return hibernateJpaVendorAdapter;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory().getObject());
        txManager.setDataSource(dataSource);
        return txManager;
    }

//    @Bean
//    public AnnotationSessionFactoryBean getSessionFactory() {
//        AnnotationSessionFactoryBean asfb = new AnnotationSessionFactoryBean();
//        asfb.setDataSource(dataSource());
//        asfb.setHibernateProperties(hibernateProperties);
//        asfb.setPackagesToScan();
//        asfb.setJpaVendorAdapter
//        return asfb;
//    }

    @Bean
    public Properties getHibernateProperties()
    {
        Resource resource = new ClassPathResource("persistence.properties");
        Properties properties;
        try {
            properties = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        Properties properties = new Properties();
//        properties.put("org.hibernate.envers.track_entities_changed_in_revision", true);
//        properties.put("org.hibernate.envers.global_with_modified_flag", true);
        return properties;
    }

//    @Bean(initMethod = "start", destroyMethod = "stop")
//    @DependsOn("h2WebServer")
//    public Server h2Server() throws SQLException {
//        return Server.createTcpServer("-tcp","-tcpAllowOthers","-tcpPort","9092").start();
//    }

//    @Bean(initMethod = "start", destroyMethod = "stop")
//    public Server h2WebServer() throws SQLException {
//        return Server.createWebServer("-web","-webAllowOthers","-webPort","70000").start();
//    }

    @Bean
//    @DependsOn("h2WebServer")
    public DataSource dataSource() {
//        String jdbcUrl = "jdbc:h2:mem:foo_db";
//        JdbcDataSource ds = new JdbcDataSource();
//        ds.setURL(jdbcUrl);
//        ds.setUser("sa");
//        ds.setPassword("");

        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/envers?characterEncoding=utf-8");
        dataSource.setUsername("root");
        dataSource.setPassword("test");

        return dataSource;
    }

//    @Bean
//    public PropertiesFactoryBean propertiesFactoryBean() {
//        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
//        propertiesFactoryBean.setLocation(new ClassPathResource("persistence.properties"));
//        return propertiesFactoryBean.;
//    }

//    @Bean
//
//    public AuditReader auditReader() {
//        return AuditReaderFactory.get(entityManager);
//    }
}
