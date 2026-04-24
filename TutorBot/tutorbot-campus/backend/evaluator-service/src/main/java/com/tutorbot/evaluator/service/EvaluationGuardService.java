package com.tutorbot.evaluator.service;

import org.springframework.stereotype.Service;

import com.tutorbot.evaluator.exception.SkillInactiveException;
import com.tutorbot.evaluator.exception.StudentNotEnrolledException;
import com.tutorbot.evaluator.exception.TopicInactiveException;
import com.tutorbot.evaluator.exception.TopicNotFoundException;
<<<<<<< HEAD
=======
import com.tutorbot.evaluator.model.Topic;
>>>>>>> upstream/main
import com.tutorbot.evaluator.repository.LearningPathRepository;
import com.tutorbot.evaluator.repository.TopicRepository;

@Service
public class EvaluationGuardService {

    private final TopicRepository topicRepository;
    private final LearningPathRepository learningPathRepository;

    public EvaluationGuardService(TopicRepository topicRepository,
<<<<<<< HEAD
                                  LearningPathRepository learningPathRepository) {
=======
            LearningPathRepository learningPathRepository) {
>>>>>>> upstream/main
        this.topicRepository = topicRepository;
        this.learningPathRepository = learningPathRepository;
    }

    public void validate(String studentId, Long topicId) {
        validateTopicExists(topicId);
        validateTopicIsActive(topicId);
        validateSkillIsActive(topicId);
        validateStudentEnrollment(studentId, topicId);
    }

    private void validateTopicExists(Long topicId) {
<<<<<<< HEAD
        if (topicRepository.findById(topicId).isEmpty()) {
=======
        if (!topicRepository.existsById(topicId)) {
>>>>>>> upstream/main
            throw new TopicNotFoundException(topicId);
        }
    }

    private void validateTopicIsActive(Long topicId) {
<<<<<<< HEAD
        if (topicRepository.findActiveById(topicId).isEmpty()) {
=======
        Topic topic = topicRepository.findActiveById(topicId).orElse(null);
        if (topic == null) {
>>>>>>> upstream/main
            throw new TopicInactiveException(topicId);
        }
    }

    private void validateSkillIsActive(Long topicId) {
<<<<<<< HEAD
        boolean skillActive = topicRepository.isSkillActiveByTopicId(topicId);
        if (!skillActive) {
=======
        Boolean skillActive = topicRepository.isSkillActiveByTopicId(topicId);
        if (skillActive == null || !skillActive) {
>>>>>>> upstream/main
            throw new SkillInactiveException(topicId);
        }
    }

    private void validateStudentEnrollment(String studentId, Long topicId) {
<<<<<<< HEAD
        boolean enrolled = learningPathRepository.existsByStudentIdAndTopicId(studentId, topicId);
        if (!enrolled) {
            throw new StudentNotEnrolledException(studentId, topicId);
        }
    }
}
=======
        if (!learningPathRepository.existsByStudentIdAndTopicId(studentId, topicId)) {
            throw new StudentNotEnrolledException(studentId, topicId);
        }
    }
}
>>>>>>> upstream/main
