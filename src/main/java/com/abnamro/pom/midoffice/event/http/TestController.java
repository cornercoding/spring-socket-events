package com.abnamro.pom.midoffice.event.http;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    
    @Autowired
    AuditEventService auditService;
    
    @RequestMapping(value = "/test")
    public void test() throws Exception {
        
        auditService.sendAuditEvent(Instant.now().toString() + " | Starting beans in phase 2147483647");
        
    }
}
