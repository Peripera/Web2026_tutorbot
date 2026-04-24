package com.tutorbot.evaluator.exception;

public class SkillInactiveException extends RuntimeException {
<<<<<<< HEAD
    public SkillInactiveException(Long topicId) {       
        super("The skill associated with topic id " + topicId + " is inactive");
    }
    
=======

    public SkillInactiveException(Long topicId) {
        super("The parent skill for topic " + topicId + " is inactive");
    }
>>>>>>> upstream/main
}
