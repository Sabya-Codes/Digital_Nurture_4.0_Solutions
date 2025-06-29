package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);
    
    public static void main(String[] args) {
        String user = "Alice";
        int age = 30;
        double score = 95.5;
        boolean isAdmin = true;
      

        logger.info("User {} logged in", user);
      
        logger.debug("User {} is {} years old and scored {}", user, age, score);
        

        if (logger.isDebugEnabled()) {
            logger.debug("Detailed debug information: {}", getDetailedInfo());
        }
        
        try {
            throw new RuntimeException("Simulated error");
        } catch (Exception e) {
            logger.error("Error processing request for user {}", user, e);
        }
        
        
        logger.warn("Admin access granted: {}", isAdmin);
    }
    
    private static String getDetailedInfo() {
        return "This is expensive to compute debug information";
    }
}