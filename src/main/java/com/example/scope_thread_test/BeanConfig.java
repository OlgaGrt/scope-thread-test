package com.example.scope_thread_test;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.SimpleThreadScope;

@Configuration
public class BeanConfig {

    @Bean
    public static BeanFactoryPostProcessor beanFactoryPostProcessor() {
        return configurableListableBeanFactory ->
                configurableListableBeanFactory.registerScope("thread", new SimpleThreadScope());
    }
}
