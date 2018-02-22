package com.ashu.demo.model;


import org.hibernate.id.uuid.StandardRandomStrategy;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String jobDescription;


    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Skill> skillSet;

    @ManyToOne()
    private Organization organization;


    public JobPost(){

      this.skillSet = new HashSet<>();
  }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public Set<Skill> getSkillSet() {
        return skillSet;
    }

    public void setSkillSet(Set<Skill> skillSet) {
        this.skillSet = skillSet;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
