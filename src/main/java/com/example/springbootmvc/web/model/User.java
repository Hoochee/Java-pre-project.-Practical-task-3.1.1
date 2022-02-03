package com.example.springbootmvc.web.model;


import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(min = 5, message = "First name must have at least 5 characters")
    @NotEmpty(message = "Please enter a First name")
    @Column(name = "firstname")
    private String firstName;

    @Length(min = 5, message = "Last name must have at least 5 characters")
    @NotEmpty(message = "Please enter a Last name")
    @Column(name = "lastname")
    public String lastName;

    @Email
    @NotEmpty(message = "Please enter an email")
    @Column(name = "email")
    public String email;

    public User(long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
