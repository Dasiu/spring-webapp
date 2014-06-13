package com.dasiubat.config.production;

import com.dasiubat.config.SharedDBConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

/**
 * Created by Adam on 2014-05-03.
 */
@Configuration
@Profile("production")
public class DBConfigurationProduction extends SharedDBConfiguration {
    @Bean
    @Override
    public DataSource dataSource() {
        throw new RuntimeException("XXX");
    }
}
