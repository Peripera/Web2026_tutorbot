package com.tutorbot.evaluator.repository;

import com.tutorbot.evaluator.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topic, Long> {

    @Query("""
        SELECT t
        FROM Topic t
        WHERE t.id = :topicId
          AND t.active = 1
    """)
    Optional<Topic> findActiveById(@Param("topicId") Long topicId);

    @Query("""
        SELECT CASE WHEN COUNT(t) > 0 THEN true ELSE false END
        FROM Topic t
        WHERE t.id = :topicId
          AND t.skill.active = 1
    """)
    boolean isSkillActiveByTopicId(@Param("topicId") Long topicId);
}