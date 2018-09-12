package com.abnamro.pom.midoffice.event.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuditEventService {

    
    @Autowired
    RestTemplate restTemplate;
    
    private String AUDIT_SERVICE_URL = "http://localhost:8080/audit/api/event";
   
    public boolean sendAuditEvent(String message) {
        
        HttpEntity<String> entity = new HttpEntity<String>(message);
        restTemplate.postForEntity(AUDIT_SERVICE_URL, entity, String.class);
        return true;
    }
}
