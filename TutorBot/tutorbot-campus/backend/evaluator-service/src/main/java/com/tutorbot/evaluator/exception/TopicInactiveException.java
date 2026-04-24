package com.tutorbot.evaluator.exception;

public class TopicInactiveException extends RuntimeException {
<<<<<<< HEAD
    public TopicInactiveException(Long topicId) {       
        super("Topic with id " + topicId + " is inactive");
=======

    public TopicInactiveException(Long topicId) {
        super("Topic is inactive: " + topicId);
>>>>>>> upstream/main
    }
}
