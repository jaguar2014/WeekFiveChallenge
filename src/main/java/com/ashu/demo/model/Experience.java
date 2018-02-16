package com.ashu.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min=3, max =300,message = "please provide a company")
    private String company;

    @NotNull
    @Size(min=3,max =300,message = "please provide a job title")
    private  String jobTitle;


    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date startDate;


    @NotNull
    @Size(min=1,max =15,message = "please provide end date")
    private String endDate;

    @ManyToOne
    private ResumeUser resumeUser;

    private String dutyone;

    private String dutytwo;

    private String dutythree;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public ResumeUser getResumeUser() {
        return resumeUser;
    }

    public void setResumeUser(ResumeUser resumeUser) {
        this.resumeUser = resumeUser;
    }

    public String getDutyone() {
        return dutyone;
    }

    public void setDutyone(String dutyone) {
        this.dutyone = dutyone;
    }

    public String getDutytwo() {
        return dutytwo;
    }

    public void setDutytwo(String dutytwo) {
        this.dutytwo = dutytwo;
    }

    public String getDutythree() {
        return dutythree;
    }

    public void setDutythree(String dutythree) {
        this.dutythree = dutythree;
    }
}
