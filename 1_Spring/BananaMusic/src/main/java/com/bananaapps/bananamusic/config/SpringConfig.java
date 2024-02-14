package com.bananaapps.bananamusic.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = {"com.bananaapps.bananamusic"})
@PropertySource("classpath:application.properties")
@EnableJpaRepositories("com.bananaapps.bananamusic.persistence")
@EntityScan("com.bananaapps.bananamusic.domain")
@EnableAutoConfiguration
public class SpringConfig {

}
