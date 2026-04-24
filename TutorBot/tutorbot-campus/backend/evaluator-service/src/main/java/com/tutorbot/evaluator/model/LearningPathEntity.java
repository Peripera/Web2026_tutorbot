package com.tutorbot.evaluator.model;

<<<<<<< HEAD
import jakarta.persistence.*;

@Entity
@Table(name= "LEARNING_PATHS")
public class LearningPathEntity {

    @Id
    @Column(name= "ID")
=======
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "LEARNING_PATHS")
public class LearningPathEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_learning_paths")
    @SequenceGenerator(name = "seq_learning_paths", sequenceName = "SEQ_LEARNING_PATHS", allocationSize = 1)
>>>>>>> upstream/main
    private Long id;

    @Column(name = "STUDENT_ID", nullable = false)
    private String studentId;

    @Column(name = "TOPIC_ID", nullable = false)
    private Long topicId;

<<<<<<< HEAD
    public LearningPathEntity() {
    }

    public LearningPathEntity(Long id, String studentId, Long topicId) {
        this.id = id;
        this.studentId = studentId;
        this.topicId = topicId;
    }

=======
>>>>>>> upstream/main
    public Long getId() {
        return id;
    }

<<<<<<< HEAD
    public String getStudentId() {
        return studentId;
    }

    public Long getTopicId() {
        return topicId;
    }

=======
>>>>>>> upstream/main
    public void setId(Long id) {
        this.id = id;
    }

<<<<<<< HEAD
=======
    public String getStudentId() {
        return studentId;
    }

>>>>>>> upstream/main
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

<<<<<<< HEAD
    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }
}
=======
    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }
}
>>>>>>> upstream/main
