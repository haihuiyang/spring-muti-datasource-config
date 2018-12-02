package com.yhh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.annotation.Bean;

import java.util.Map;

@SpringBootApplication
public class SpringMutiDataSourceConfig {

    public static void main(String[] args) {
        SpringApplication.run(SpringMutiDataSourceConfig.class, args);
    }

    @Autowired
    private JpaProperties jpaProperties;

    @Bean(name = "vendorProperties")
    public Map<String, Object> getVendorProperties() {
        return jpaProperties.getHibernateProperties(new HibernateSettings());
    }

}