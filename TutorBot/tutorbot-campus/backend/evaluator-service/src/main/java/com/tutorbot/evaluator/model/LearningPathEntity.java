package com.tutorbot.evaluator.model;

import jakarta.persistence.*;

@Entity
@Table(name= "LEARNING_PATHS")
public class LearningPathEntity {

    @Id
    @Column(name= "ID")
    private Long id;

    @Column(name = "STUDENT_ID", nullable = false)
    private String studentId;

    @Column(name = "TOPIC_ID", nullable = false)
    private Long topicId;

    public LearningPathEntity() {
    }

    public LearningPathEntity(Long id, String studentId, Long topicId) {
        this.id = id;
        this.studentId = studentId;
        this.topicId = topicId;
    }

    public Long getId() {
        return id;
    }

    public String getStudentId() {
        return studentId;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }
}