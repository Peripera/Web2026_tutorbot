package com.tutorbot.evaluator.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TOPICS")
public class Topic {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "COURSE_ID")
    private Long courseId;

    @Column(name = "ACTIVE", nullable = false)
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

    public Long getId() {
        return id;
    }

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}