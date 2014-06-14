package com.dasiubat.config.development;

import com.dasiubat.config.SharedDBConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by Adam on 2014-05-03.
 */
@Configuration
@ComponentScan
@Profile("development")
public class DBConfigurationDevelopment extends SharedDBConfiguration {
}
