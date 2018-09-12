package com.abnamro.pom.midoffice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    
    @Autowired
    private SimpMessagingTemplate messagingTemplate;


    @RequestMapping(value="/audit/api/event", method=RequestMethod.POST)
    public String audit(@RequestBody String message) throws Exception {
        Thread.sleep(1000); // simulated delay
        
        messagingTemplate.convertAndSend("/topic/events", message);
        return message;
    }

}
