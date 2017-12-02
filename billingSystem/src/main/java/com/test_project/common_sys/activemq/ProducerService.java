package com.test_project.common_sys.activemq;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by Administrator on 2017/1/5.
 */
@Service
public class ProducerService {

	@Resource(name="jmsTemplate")
    private JmsTemplate jmsTemplate;
	
	@Resource(name = "demoQueueDestination")
    private Destination destination;
	

    public void sendMessage(Destination destination,String userName,String userBill,String password,String mail){
        System.out.println(Thread.currentThread().getName()+" 向队列"+destination.toString()+"发送消息---------------------->"+userName+"_"+userBill+"_"+password+"_"+mail);
        jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
            	MapMessage mapMessage = session.createMapMessage();   
            	mapMessage.setString("userName", userName);
            	mapMessage.setString("userBill", userBill);
            	mapMessage.setString("password", password);
            	mapMessage.setString("mail", mail);
            	return mapMessage;
            }
        });
    }

}
