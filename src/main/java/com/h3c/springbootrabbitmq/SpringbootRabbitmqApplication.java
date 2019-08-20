package com.h3c.springbootrabbitmq;

import com.h3c.springbootrabbitmq.core.SenderService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.Resource;

@SpringBootApplication
public class SpringbootRabbitmqApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringbootRabbitmqApplication.class, args);
        //Sender sender = applicationContext.getBean(Sender.class);
        //sender.send();

        SenderService senderService = applicationContext.getBean(SenderService.class);
        senderService.testSenderToExchange();
        senderService.testSenderToQueue();
    }

}
