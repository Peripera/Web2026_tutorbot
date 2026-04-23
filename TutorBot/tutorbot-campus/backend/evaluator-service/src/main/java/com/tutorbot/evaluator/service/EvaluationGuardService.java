package com.tutorbot.evaluator.service;

import org.springframework.stereotype.Service;

import com.tutorbot.evaluator.exception.SkillInactiveException;
import com.tutorbot.evaluator.exception.StudentNotEnrolledException;
import com.tutorbot.evaluator.exception.TopicInactiveException;
import com.tutorbot.evaluator.exception.TopicNotFoundException;
import com.tutorbot.evaluator.repository.LearningPathRepository;
import com.tutorbot.evaluator.repository.TopicRepository;

@Service
public class EvaluationGuardService {

    private final TopicRepository topicRepository;
    private final LearningPathRepository learningPathRepository;

    public EvaluationGuardService(TopicRepository topicRepository,
                                  LearningPathRepository learningPathRepository) {
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
        if (topicRepository.findById(topicId).isEmpty()) {
            throw new TopicNotFoundException(topicId);
        }
    }

    private void validateTopicIsActive(Long topicId) {
        if (topicRepository.findActiveById(topicId).isEmpty()) {
            throw new TopicInactiveException(topicId);
        }
    }

    private void validateSkillIsActive(Long topicId) {
        boolean skillActive = topicRepository.isSkillActiveByTopicId(topicId);
        if (!skillActive) {
            throw new SkillInactiveException(topicId);
        }
    }

    private void validateStudentEnrollment(String studentId, Long topicId) {
        boolean enrolled = learningPathRepository.existsByStudentIdAndTopicId(studentId, topicId);
        if (!enrolled) {
            throw new StudentNotEnrolledException(studentId, topicId);
        }
    }
}