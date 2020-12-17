package cn.shop.mall.app.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by LSY on 2020/12/14.
 */
@SpringBootConfiguration
public class Config {


    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
