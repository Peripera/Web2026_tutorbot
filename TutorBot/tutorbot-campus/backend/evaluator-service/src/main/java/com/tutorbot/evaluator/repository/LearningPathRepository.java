package com.tutorbot.evaluator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
=======
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
>>>>>>> upstream/main

import com.tutorbot.evaluator.model.LearningPathEntity;

public interface LearningPathRepository extends JpaRepository<LearningPathEntity, Long> {

<<<<<<< HEAD
    boolean existsByStudentIdAndTopicId(String studentId, Long topicId);
=======
    @Query("SELECT COUNT(lp) > 0 FROM LearningPathEntity lp WHERE lp.studentId = :studentId AND lp.topicId = :topicId")
    boolean existsByStudentIdAndTopicId(@Param("studentId") String studentId, @Param("topicId") Long topicId);
>>>>>>> upstream/main
}
