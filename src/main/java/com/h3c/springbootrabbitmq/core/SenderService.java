package com.h3c.springbootrabbitmq.core;

import com.alibaba.fastjson.JSON;
import com.h3c.springbootrabbitmq.model.User;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: fei.xiao
 * @Date: 2019/8/20 16:50
 * @Description：
 */
@Service
public class SenderService {

    private String exchange = "test.exchange";


    private String routingKey = "test.routingkey";


    private String testQueue = "test.queue";

    @Resource(name = "rabbitTemplate")
    private RabbitTemplate rabbitTemplate;

    public void testSenderToExchange(){
        User user = new User();
        user.setName("lianhua");
        user.setAge(18);
        rabbitTemplate.convertAndSend(exchange,routingKey, JSON.toJSONString(user));
    }

    public void testSenderToQueue(){
        User user = new User();
        user.setName("yanwei");
        user.setAge(18);
        rabbitTemplate.convertAndSend(testQueue, JSON.toJSONString(user));
    }



}
