package com.tutorbot.evaluator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorbot.evaluator.model.LearningPathEntity;

public interface LearningPathRepository extends JpaRepository<LearningPathEntity, Long> {

    boolean existsByStudentIdAndTopicId(String studentId, Long topicId);
}
