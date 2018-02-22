package com.ashu.demo.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Organization  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String companyName;

    private String description;

    @OneToMany(mappedBy = "organization")
    private Set<JobPost> jobPostSet = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<JobPost> getJobPostSet() {
        return jobPostSet;
    }

    public void setJobPostSet(Set<JobPost> jobPostSet) {
        this.jobPostSet = jobPostSet;
    }
}
