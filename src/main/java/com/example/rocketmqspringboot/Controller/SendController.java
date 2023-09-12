package com.example.rocketmqspringboot.Controller;

import com.example.rocketmqspringboot.domain.User;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: rocketmqspringboot
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2023-08-30 19:22
 * @LastEditTime: 2023-08-30 19:22
 */
//缺啥补啥

@RestController
@RequestMapping("/demo")
public class SendController {
    @Autowired
    RocketMQTemplate rocketMQTemplate;//模版类:帮助我们建立连接 以及断连接

    @GetMapping("/send")
    public String send(){
        //发送逻辑
        String msg = "i m very handsome";
        //rocketMQTemplate.convertAndSend("topic10",msg);//convert转换成底层字节数组
        User user = new User("asheng",28);
        rocketMQTemplate.convertAndSend("topic10",user);

        //同步消息：範例   ******
//        SendResult sendResult = rocketMQTemplate.syncSend("topic10", msg, 2);
        //異步消息  ************
//        rocketMQTemplate.asyncSend("topic10",user , new SendCallback() {
//            @Override
//            public void onSuccess(SendResult sendResult) {
//                System.out.println(sendResult);
//            }
//
//            @Override
//            public void onException(Throwable throwable) {
//                System.out.println(throwable);
//            }
//        },100);

        //單項消息 ********
//        rocketMQTemplate.sendOneWay("topic10",user);

        //延時消息 *******
//        rocketMQTemplate.syncSend("topic10",MessageBuilder.withPayload(msg).build(),2000,2);
        //------------批量消息--------------- *******
//        List<Message> msgList = new ArrayList<>();
//        String msg1 = "ListSetMap";
//        Message message1 = new Message("Topic7", "tag1", msg1.getBytes(StandardCharsets.UTF_8));
//        msgList.add(message1);
//        String msg2 = "ListSetMap";
//        Message message2 = new Message("Topic7", "tag1", msg2.getBytes(StandardCharsets.UTF_8));
//        msgList.add(message2);
//        String msg3 = "ListSetMap";
//        Message message3 = new Message("Topic7", "tag1", msg3.getBytes(StandardCharsets.UTF_8));
//        msgList.add(message3);
//        rocketMQTemplate.syncSend("topic10",msgList,1000);

        return "successs!!";
    }
}
