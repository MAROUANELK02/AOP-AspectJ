package com.aop.springaop;

import com.aop.springaop.services.IMetier;
import com.aop.springaop.services.SecurityContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAopApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(IMetier metier) {
        return args -> {
            SecurityContext.authenticate("root", "1234", new String[]{"USER", "ADMIN"});
            metier.process();
            metier.compute();
        };
    }

}
