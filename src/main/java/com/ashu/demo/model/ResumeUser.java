package com.ashu.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class ResumeUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private  int id;

    private String firstName;

    private String lastName;

    private String email;


   @OneToMany(mappedBy = "resumeUser",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Education> educations;

    @OneToMany(mappedBy = "resumeUser",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Experience> experiences;

    @OneToMany(mappedBy = "resumeUser",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Skill> skills;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Education> getEducations() {
        return educations;
    }

    public void setEducations(Set<Education> educations) {
        this.educations = educations;
    }

    public Set<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(Set<Experience> experiences) {
        this.experiences = experiences;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }
}
