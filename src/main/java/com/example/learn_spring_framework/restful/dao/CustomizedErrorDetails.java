package com.example.learn_spring_framework.restful.dao;

import java.time.LocalDateTime;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2025-11-19 09:42
 */
public class CustomizedErrorDetails {
    private String message;
    private LocalDateTime localDateTime;
    private String tracedDetails;

    public CustomizedErrorDetails(String message, LocalDateTime localDateTime, String tracedDetails) {
        this.message = message;
        this.localDateTime = localDateTime;
        this.tracedDetails = tracedDetails;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public String getTracedDetails() {
        return tracedDetails;
    }
}
