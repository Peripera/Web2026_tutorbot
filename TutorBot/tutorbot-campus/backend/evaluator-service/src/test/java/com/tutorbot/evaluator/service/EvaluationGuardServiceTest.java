package com.tutorbot.evaluator.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.tutorbot.evaluator.exception.SkillInactiveException;
import com.tutorbot.evaluator.exception.StudentNotEnrolledException;
import com.tutorbot.evaluator.exception.TopicInactiveException;
import com.tutorbot.evaluator.exception.TopicNotFoundException;
import com.tutorbot.evaluator.model.Topic;
import com.tutorbot.evaluator.repository.LearningPathRepository;
import com.tutorbot.evaluator.repository.TopicRepository;

class EvaluationGuardServiceTest {

    private TopicRepository topicRepository;
    private LearningPathRepository learningPathRepository;
    private EvaluationGuardService guard;

    @BeforeEach
    void setUp() {
        topicRepository = mock(TopicRepository.class);
        learningPathRepository = mock(LearningPathRepository.class);
        guard = new EvaluationGuardService(topicRepository, learningPathRepository);
    }

    @Test
    void happyPath_validStudentAndTopic_passes() {
        Long topicId = 1L;
        String studentId = "A00835001";

        when(topicRepository.existsById(topicId)).thenReturn(true);
        when(topicRepository.findActiveById(topicId)).thenReturn(Optional.of(new Topic()));
        when(topicRepository.isSkillActiveByTopicId(topicId)).thenReturn(true);
        when(learningPathRepository.existsByStudentIdAndTopicId(studentId, topicId)).thenReturn(true);

        assertDoesNotThrow(() -> guard.validate(studentId, topicId));
    }

    @Test
    void topicDoesNotExist_throwsTopicNotFoundException() {
        Long topicId = 9999L;
        String studentId = "A00835001";

        when(topicRepository.existsById(topicId)).thenReturn(false);

        assertThrows(TopicNotFoundException.class, () -> guard.validate(studentId, topicId));
    }

    @Test
    void topicExistsButInactive_throwsTopicInactiveException() {
        Long topicId = 16L;
        String studentId = "A00835005";

        when(topicRepository.existsById(topicId)).thenReturn(true);
        when(topicRepository.findActiveById(topicId)).thenReturn(Optional.empty());

        assertThrows(TopicInactiveException.class, () -> guard.validate(studentId, topicId));
    }

    @Test
    void skillInactive_throwsSkillInactiveException() {
        Long topicId = 15L;
        String studentId = "A00835005";

        when(topicRepository.existsById(topicId)).thenReturn(true);
        when(topicRepository.findActiveById(topicId)).thenReturn(Optional.of(new Topic()));
        when(topicRepository.isSkillActiveByTopicId(topicId)).thenReturn(false);

        assertThrows(SkillInactiveException.class, () -> guard.validate(studentId, topicId));
    }

    @Test
    void studentNotEnrolled_throwsStudentNotEnrolledException() {
        Long topicId = 1L;
        String studentId = "A00835010";

        when(topicRepository.existsById(topicId)).thenReturn(true);
        when(topicRepository.findActiveById(topicId)).thenReturn(Optional.of(new Topic()));
        when(topicRepository.isSkillActiveByTopicId(topicId)).thenReturn(true);
        when(learningPathRepository.existsByStudentIdAndTopicId(studentId, topicId)).thenReturn(false);

        assertThrows(StudentNotEnrolledException.class, () -> guard.validate(studentId, topicId));
    }
}
