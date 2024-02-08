package com.bananaapps.bananamusic.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.bananaapps.bananamusic.persistence", "com.bananaapps.bananamusic.service.music"})
@PropertySource("classpath:application.properties")
@EnableAutoConfiguration
public class SpringConfig {

}
