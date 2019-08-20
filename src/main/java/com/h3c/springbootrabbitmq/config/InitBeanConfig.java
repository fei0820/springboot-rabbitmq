package com.h3c.springbootrabbitmq.config;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: fei.xiao
 * @Date: 2019/8/20 16:47
 * @Description：
 */
@Configuration
public class InitBeanConfig {

    @Value("${spring.rabbitmq.host}")
    private String rabbitVirtualHost;
    @Value("${rabbitmq.addresses}")
    private String rabbitUrl;
    @Value("${spring.rabbitmq.username}")
    private String rabbitUserName;
    @Value("${spring.rabbitmq.password}")
    private String rabbitPwd;

    private void initConnection(CachingConnectionFactory connectionFactory){
        connectionFactory.setAddresses(rabbitUrl);
        connectionFactory.setUsername(rabbitUserName);
        connectionFactory.setPassword(rabbitPwd);
        connectionFactory.setPublisherConfirms(true);
    }

    @Bean(name = "connectionFactory")
    public ConnectionFactory connectionFactoryInvoice() {
        CachingConnectionFactory connectionFactoryInvoice = new CachingConnectionFactory();
        initConnection(connectionFactoryInvoice);
        connectionFactoryInvoice.setVirtualHost(rabbitVirtualHost);
        return connectionFactoryInvoice;
    }

    @Bean(name = "rabbitTemplate")
    public RabbitTemplate rabbitTemplateInvoice(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate= new RabbitTemplate(connectionFactory);
        MessageConverter messageConverter=new Jackson2JsonMessageConverter();
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }
}
