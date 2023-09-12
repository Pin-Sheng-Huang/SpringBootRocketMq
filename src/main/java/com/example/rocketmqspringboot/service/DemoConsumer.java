package com.example.rocketmqspringboot.service;

import com.example.rocketmqspringboot.domain.User;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Service;

/**
 * @program: rocketmqspringboot
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2023-08-30 20:31
 * @LastEditTime: 2023-08-30 20:31
 */

@Service
//哪邊收消息 已經寫在yaml理
//@RocketMQMessageListener(consumerGroup = "group1", topic = "topic10", selectorExpression = "tag1 || tag2")//consumerGroup 要對應yaml理寫的配置
@RocketMQMessageListener(consumerGroup = "group1", topic = "topic10",
        selectorType = SelectorType.SQL92,selectorExpression = "age > 92",
        messageModel = MessageModel.BROADCASTING)
public class DemoConsumer implements RocketMQListener<User> {
    //實現方法
    @Override
    public void onMessage(User user) {
        System.out.println("消費者接收消息："+user);
    }
}
