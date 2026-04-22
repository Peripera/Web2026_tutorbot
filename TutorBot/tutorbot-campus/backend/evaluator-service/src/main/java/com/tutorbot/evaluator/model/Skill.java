package com.tutorbot.evaluator.model;

import jakarta.persistence.*;

@Entity
@Table(name = "SKILLS")
public class Skill {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "ACTIVE", nullable = false)
    private Integer active;

    public Skill() {
    }

    public Skill(Long id, String name, Integer active) {
        this.id = id;
        this.name = name;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getActive() {
        return active;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}
