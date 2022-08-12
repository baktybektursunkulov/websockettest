package com.company.controller;

import com.company.model.WebSocket;
import com.company.pojo.Greeting;
import com.company.pojo.Message;
import com.company.repo.WebSocketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {
    @Autowired
    WebSocketRepository repository;

    @MessageMapping("/hello")
    @SendTo("/topic/greeting")
    public void save(Message message) throws InterruptedException {
        WebSocket webSocket=new WebSocket();
        webSocket.setContent(HtmlUtils.htmlEscape(message.getName()));
        repository.save(webSocket);
       // return new Greeting(HtmlUtils.htmlEscape(message.getName()));
    }
    @MessageMapping("/show")
    @SendTo("/topic/greetings")
    public Greeting contents() throws InterruptedException {
         return new Greeting(HtmlUtils.htmlEscape(String.valueOf(repository.find())));
    }
}
