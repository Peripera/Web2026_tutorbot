package com.tutorbot.evaluator.exception;

public class TopicNotFoundException extends RuntimeException {
    public TopicNotFoundException(Long topicId) {       
        super("Topic with id " + topicId + " not found");
    }
    
}
