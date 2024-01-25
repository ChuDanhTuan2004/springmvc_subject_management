package org.example.subject_management.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Ban khong the de trong ten")
    private String name;
    @Min(value = 1, message = "So tin chi phai lon hon 1")
    private int numberOfCourses;

    @ManyToOne
    @JoinColumn(name = "cate_id", nullable = false)
    private Category category;

    public Subject() {
    }

    public Subject(Long id, String name, int numberOfCourses, Category category) {
        this.id = id;
        this.name = name;
        this.numberOfCourses = numberOfCourses;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfCourses() {
        return numberOfCourses;
    }

    public void setNumberOfCourses(int numberOfCourses) {
        this.numberOfCourses = numberOfCourses;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
