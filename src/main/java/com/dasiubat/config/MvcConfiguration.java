package com.dasiubat.config;

import com.dasiubat.config.development.DBConfigurationDevelopment;
import com.dasiubat.config.production.DBConfigurationProduction;
import com.dasiubat.domain.ActionTypeHolder;
import com.dasiubat.utils.ContextLookup;
import org.springframework.context.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@Import({DBConfigurationDevelopment.class, DBConfigurationProduction.class})
@ComponentScan(basePackages = {"com.dasiubat.controller"})
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/src/main/resources/**").addResourceLocations("/src/main/resources/");
    }


    // TODO scan for beans in other packages
    @Bean
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public ActionTypeHolder actionTypeHolder() {
        return new ActionTypeHolder();
    }

    @Bean
    public ContextLookup contextLookup() {
        return new ContextLookup();
    }
}