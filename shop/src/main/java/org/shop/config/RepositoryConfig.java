package org.shop.config;

import org.shop.repository.OrderRepository;
import org.shop.repository.UserRepository;
import org.shop.repository.factory.UserRepositoryFactory;
import org.shop.repository.map.OrderMapRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Razor on 7/18/2015.
 */
@Configuration
@ComponentScan({"org.shop.repository.factory,org.shop.repository.map"})
@PropertySource(value = { "order.properties" })
public class RepositoryConfig {

    @Bean
    public UserRepositoryFactory userRepositoryFactory(){
        return new UserRepositoryFactory();
    }

    @Bean
    public UserRepository userRepository(){
        return userRepositoryFactory().createUserRepository();
    }

    @Bean(name = {"orderMapRepository","orderMapRepositoryAlias"})
    public OrderRepository orderMapRepository(  @Value("{orderMapRepo.initSequence}") long initSequence){
        return new OrderMapRepository(initSequence);
    }
}
