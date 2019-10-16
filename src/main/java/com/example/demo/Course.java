package com.example.demo;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min = 4, message = "Please provide the course title (at least 4 characters.)")
    private String title;

    @NotNull
    @Size(min = 3, message = "Please provide Instructor's name (at least 3 characters.)")
    private String instructor;

    @NotNull
    @Size(min = 10, message = "Please provide a brief description (at least 10 characters.)")
    private String description;

    @NotNull
    @Min ( value = 3 , message = "Minimum is 3 credits. Non-credit courses not allowed.")
    private int credit;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Course() {

    }

    public Course(@NotNull @Size(min = 4, message = "Please provide the course title (at least 4 characters.)") String title, @NotNull @Size(min = 3, message = "Please provide Instructor's name (at least 3 characters.)") String instructor, @NotNull @Size(min = 10, message = "Please provide a brief description (at least 10 characters.)") String description, @NotNull @Min(value = 3, message = "Minimum is 3 credits. Non-credit courses not allowed.") int credit) {
        this.title = title;
        this.instructor = instructor;
        this.description = description;
        this.credit = credit;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}
