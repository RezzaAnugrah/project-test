package id.alfacart.riset.activemq.jms;


import com.google.gson.Gson;
import id.alfacart.riset.activemq.model.Email;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @JmsListener(destination = "inbound.queue.1")
    public void receiveMessage(String jsonMessage){
        Email email = new Gson().fromJson(jsonMessage, Email.class);
        System.out.println("email.toString() = " + email.toString());
    }

}
