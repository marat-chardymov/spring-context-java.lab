package org.shop.config;

import java.util.HashMap;
import java.util.Map;

import org.shop.common.Sellers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Razor on 7/19/2015.
 */
@Configuration
@ComponentScan({"org.shop"})
public class DataInitializersConfig {
  @Bean
  public Map<Long,String> sellersMap(){
    HashMap<Long, String> sellersMap = new HashMap<Long, String>();
    sellersMap.put(1L, Sellers.AMAZON);
    sellersMap.put(2L, Sellers.SAMSUNG);
    sellersMap.put(3L, "Apple");
    return sellersMap;
  }
 }
