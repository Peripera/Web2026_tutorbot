package com.tutorbot.evaluator.exception;

public class SkillInactiveException extends RuntimeException {
    public SkillInactiveException(Long topicId) {       
        super("The skill associated with topic id " + topicId + " is inactive");
    }
    
}
