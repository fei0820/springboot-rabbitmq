package com.h3c.springbootrabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootRabbitmqApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringbootRabbitmqApplication.class, args);
        Sender sender = applicationContext.getBean(Sender.class);
        sender.send();
    }

}
