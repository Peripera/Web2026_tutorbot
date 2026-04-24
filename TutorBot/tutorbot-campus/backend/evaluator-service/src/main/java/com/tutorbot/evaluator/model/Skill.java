package com.tutorbot.evaluator.model;

<<<<<<< HEAD
import jakarta.persistence.*;
=======
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
>>>>>>> upstream/main

@Entity
@Table(name = "SKILLS")
public class Skill {

    @Id
<<<<<<< HEAD
    @Column(name = "ID")
=======
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_skills")
    @SequenceGenerator(name = "seq_skills", sequenceName = "SEQ_SKILLS", allocationSize = 1)
>>>>>>> upstream/main
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "ACTIVE", nullable = false)
<<<<<<< HEAD
    private Integer active;

    public Skill() {
    }

    public Skill(Long id, String name, Integer active) {
        this.id = id;
        this.name = name;
        this.active = active;
    }
=======
    private Boolean active;
>>>>>>> upstream/main

    public Long getId() {
        return id;
    }

<<<<<<< HEAD
    public String getName() {
        return name;
    }

    public Integer getActive() {
        return active;
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
    public void setActive(Integer active) {
=======
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
>>>>>>> upstream/main
        this.active = active;
    }
}
