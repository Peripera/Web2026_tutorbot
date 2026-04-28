package com.tutorbot.evaluator.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TOPICS")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_topics")
    @SequenceGenerator(name = "seq_topics", sequenceName = "SEQ_TOPICS", allocationSize = 1)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "COURSE_ID")
    private Long courseId;

    @Column(name = "ACTIVE", nullable = false)
    private Boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SKILL_ID", nullable = false)
    private Skill skill;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getCourseId() {
        return courseId;
    }

    public Boolean getActive() {
        return active;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}