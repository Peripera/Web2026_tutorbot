package com.tutorbot.evaluator.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.tutorbot.evaluator.exception.SkillInactiveException;
import com.tutorbot.evaluator.exception.StudentNotEnrolledException;
import com.tutorbot.evaluator.exception.TopicInactiveException;
import com.tutorbot.evaluator.exception.TopicNotFoundException;
import com.tutorbot.evaluator.model.Skill;
import com.tutorbot.evaluator.model.Topic;
import com.tutorbot.evaluator.repository.LearningPathRepository;
import com.tutorbot.evaluator.repository.TopicRepository;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EvaluationGuardServiceTest {

    private TopicRepository topicRepository;
    private LearningPathRepository learningPathRepository;
    private EvaluationGuardService guardService;

    @BeforeEach
    void setUp() {
        topicRepository = Mockito.mock(TopicRepository.class);
        learningPathRepository = Mockito.mock(LearningPathRepository.class);
        guardService = new EvaluationGuardService(topicRepository, learningPathRepository);
    }

    @Test
    void validate_happyPath_shouldPass() {
        String studentId = "A00835001";
        Long topicId = 1L;

        Skill skill = new Skill(1L, "Skill", 1);
        Topic topic = new Topic(topicId, "Topic", 1L, 1, skill);

        when(topicRepository.findById(topicId)).thenReturn(Optional.of(topic));
        when(topicRepository.findActiveById(topicId)).thenReturn(Optional.of(topic));
        when(topicRepository.isSkillActiveByTopicId(topicId)).thenReturn(true);
        when(learningPathRepository.existsByStudentIdAndTopicId(studentId, topicId)).thenReturn(true);

        assertDoesNotThrow(() -> guardService.validate(studentId, topicId));
    }

    @Test
    void validate_topicNotFound_shouldThrow() {
        String studentId = "A00835001";
        Long topicId = 9999L;

        when(topicRepository.findById(topicId)).thenReturn(Optional.empty());

        assertThrows(TopicNotFoundException.class, () -> guardService.validate(studentId, topicId));
    }

    @Test
    void validate_topicInactive_shouldThrow() {
        String studentId = "A00835001";
        Long topicId = 16L;

        Skill skill = new Skill(1L, "Skill", 1);
        Topic topic = new Topic(topicId, "Topic", 1L, 0, skill);

        when(topicRepository.findById(topicId)).thenReturn(Optional.of(topic));
        when(topicRepository.findActiveById(topicId)).thenReturn(Optional.empty());

        assertThrows(TopicInactiveException.class, () -> guardService.validate(studentId, topicId));
    }

    @Test
    void validate_skillInactive_shouldThrow() {
        String studentId = "A00835001";
        Long topicId = 15L;

        Skill skill = new Skill(2L, "Redes", 0);
        Topic topic = new Topic(topicId, "Topic", 1L, 1, skill);

        when(topicRepository.findById(topicId)).thenReturn(Optional.of(topic));
        when(topicRepository.findActiveById(topicId)).thenReturn(Optional.of(topic));
        when(topicRepository.isSkillActiveByTopicId(topicId)).thenReturn(false);

        assertThrows(SkillInactiveException.class, () -> guardService.validate(studentId, topicId));
    }

    @Test
    void validate_studentNotEnrolled_shouldThrow() {
        String studentId = "STU999";
        Long topicId = 1L;

        Skill skill = new Skill(1L, "Skill", 1);
        Topic topic = new Topic(topicId, "Topic", 1L, 1, skill);

        when(topicRepository.findById(topicId)).thenReturn(Optional.of(topic));
        when(topicRepository.findActiveById(topicId)).thenReturn(Optional.of(topic));
        when(topicRepository.isSkillActiveByTopicId(topicId)).thenReturn(true);
        when(learningPathRepository.existsByStudentIdAndTopicId(studentId, topicId)).thenReturn(false);

        assertThrows(StudentNotEnrolledException.class, () -> guardService.validate(studentId, topicId));
    }
}