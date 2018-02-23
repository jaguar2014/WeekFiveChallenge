package com.ashu.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @Size(min=1,message = "please provide a skill name")
    private String skillName;


    @Size(min=1, message = "Please provide a skills rating")
    private String rating;


    @ManyToMany(mappedBy = "skills")
    private Set<JobPost> jobPosts;


    @ManyToMany(mappedBy = "skills")
    private Set<ResumeUser> resumeUsers;


    public Set<JobPost> getJobPosts() {
        return jobPosts;
    }

    public void setJobPosts(Set<JobPost> jobPosts) {
        this.jobPosts = jobPosts;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Set<ResumeUser> getResumeUsers() {
        return resumeUsers;
    }

    public void setResumeUsers(Set<ResumeUser> resumeUsers) {
        this.resumeUsers = resumeUsers;
    }
}
