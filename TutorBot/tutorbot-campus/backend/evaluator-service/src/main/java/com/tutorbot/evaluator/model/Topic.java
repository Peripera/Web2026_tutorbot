package com.tutorbot.evaluator.model;

<<<<<<< HEAD
import jakarta.persistence.*;
=======
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
>>>>>>> upstream/main

@Entity
@Table(name = "TOPICS")
public class Topic {

    @Id
<<<<<<< HEAD
    @Column(name = "ID")
=======
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_topics")
    @SequenceGenerator(name = "seq_topics", sequenceName = "SEQ_TOPICS", allocationSize = 1)
>>>>>>> upstream/main
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "COURSE_ID")
    private Long courseId;

    @Column(name = "ACTIVE", nullable = false)
<<<<<<< HEAD
    private Integer active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SKILL_ID", nullable = false)
    private Skill skill;

    public Topic() {
    }

    public Topic(Long id, String name, Long courseId, Integer active, Skill skill) {
        this.id = id;
        this.name = name;
        this.courseId = courseId;
        this.active = active;
        this.skill = skill;
    }

=======
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "SKILL_ID")
    private Skill skill;

>>>>>>> upstream/main
    public Long getId() {
        return id;
    }

<<<<<<< HEAD
    public String getName() {
        return name;
    }

    public Long getCourseId() {
        return courseId;
    }

    public Integer getActive() {
        return active;
    }

    public Skill getSkill() {
        return skill;
    }

=======
>>>>>>> upstream/main
    public void setId(Long id) {
        this.id = id;
    }

<<<<<<< HEAD
=======
    public String getName() {
        return name;
    }

>>>>>>> upstream/main
    public void setName(String name) {
        this.name = name;
    }

<<<<<<< HEAD
=======
    public Long getCourseId() {
        return courseId;
    }

>>>>>>> upstream/main
    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

<<<<<<< HEAD
    public void setActive(Integer active) {
        this.active = active;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}
=======
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}
>>>>>>> upstream/main
