package com.ashu.demo.model;

import javax.persistence.*;

@Entity
public class Reference {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private String firstName;

    private String lastName;

    private String email;

    @ManyToOne
    private ResumeUser resumeUser;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public ResumeUser getResumeUser() {
        return resumeUser;
    }

    public void setResumeUser(ResumeUser resumeUser) {
        this.resumeUser = resumeUser;
    }
}
