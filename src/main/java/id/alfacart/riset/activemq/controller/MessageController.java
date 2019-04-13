package id.alfacart.riset.activemq.controller;

import com.google.gson.Gson;
import id.alfacart.riset.activemq.jms.Producer;
import id.alfacart.riset.activemq.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    Producer producer;

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/send")
    public String sendMessage(){
        String queueName = "inbound.queue.1";
        Email email = new Email("rezza.anugrahm1@gmail.com" , "Hallo Rezza Anugrah M");
        producer.sendMessage(queueName.toLowerCase()  ,  new Gson().toJson(email));
        return "success";
    }
}
