package com.yankova.springbootintro;

import com.yankova.springbootintro.services.services.BeersService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootIntroApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootIntroApplication.class, args);
        BeersService beersService = ctx.getBean(BeersService.class);
        //fake(() -> List.of());
    }

    //public static void fake(BeersService beersService){
        //beersService.getBeers().forEach(System.out::println);
    //}

}
