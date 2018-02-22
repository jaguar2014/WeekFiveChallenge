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


    @OneToMany(fetch = FetchType.EAGER,mappedBy = "jobPost")
    private Set<Skill> skills;



    @ManyToOne(cascade = CascadeType.ALL)
    private Organization organization;


    public JobPost(){

      this.skills = new HashSet<>();
  }

  public void addSkill(Skill s)
  {
      this.skills.add(s);
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

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
