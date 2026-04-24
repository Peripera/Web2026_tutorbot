package com.tutorbot.evaluator.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tutorbot.evaluator.exception.SkillInactiveException;
import com.tutorbot.evaluator.exception.StudentNotEnrolledException;
import com.tutorbot.evaluator.exception.TopicInactiveException;
import com.tutorbot.evaluator.exception.TopicNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TopicNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleTopicNotFound(TopicNotFoundException ex) {
<<<<<<< HEAD
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
=======
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
>>>>>>> upstream/main
                .body(Map.of("error", ex.getMessage()));
    }

    @ExceptionHandler(TopicInactiveException.class)
    public ResponseEntity<Map<String, String>> handleTopicInactive(TopicInactiveException ex) {
<<<<<<< HEAD
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
=======
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
>>>>>>> upstream/main
                .body(Map.of("error", ex.getMessage()));
    }

    @ExceptionHandler(SkillInactiveException.class)
    public ResponseEntity<Map<String, String>> handleSkillInactive(SkillInactiveException ex) {
<<<<<<< HEAD
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
=======
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
>>>>>>> upstream/main
                .body(Map.of("error", ex.getMessage()));
    }

    @ExceptionHandler(StudentNotEnrolledException.class)
    public ResponseEntity<Map<String, String>> handleStudentNotEnrolled(StudentNotEnrolledException ex) {
<<<<<<< HEAD
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(Map.of("error", ex.getMessage()));
    }
}
=======
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(Map.of("error", ex.getMessage()));
    }
}
>>>>>>> upstream/main
