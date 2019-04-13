package id.alfacart.riset.activemq.jms;

import com.google.gson.Gson;
import id.alfacart.riset.activemq.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

@Component
public class Producer {

    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(final String queueName, final String message) {
        Email email = new Gson().fromJson(message, Email.class);
        final String textMessage = email.toString();
        System.out.println("Sending message " + textMessage + " to queue - " + queueName);
//        jmsTemplate.send(queueName, new MessageCreator() {
//            public Message createMessage(Session session) throws JMSException {
//                TextMessage message = session.createTextMessage();
//                return message;
//            }
//        });
         jmsTemplate.convertAndSend(queueName, message);
    }




}
