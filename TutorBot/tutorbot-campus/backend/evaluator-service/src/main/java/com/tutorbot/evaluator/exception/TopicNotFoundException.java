package com.tutorbot.evaluator.exception;

public class TopicNotFoundException extends RuntimeException {
<<<<<<< HEAD
    public TopicNotFoundException(Long topicId) {       
        super("Topic with id " + topicId + " not found");
    }
    
=======

    public TopicNotFoundException(Long topicId) {
        super("Topic not found: " + topicId);
    }
>>>>>>> upstream/main
}
