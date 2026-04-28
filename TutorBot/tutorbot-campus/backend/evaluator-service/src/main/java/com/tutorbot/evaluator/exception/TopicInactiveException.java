package com.tutorbot.evaluator.exception;

public class TopicInactiveException extends RuntimeException {
    public TopicInactiveException(Long topicId) {       
        super("Topic with id " + topicId + " is inactive");
    }
}
