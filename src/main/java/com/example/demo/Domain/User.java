package com.example.demo.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "user")
public class User extends BaseDomain {

    @Column(name = "name", nullable = false)
    @Size(min=2, max=30)
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    @Pattern(regexp="^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$")
    private String email;

    @Column(name = "password")
    @NotNull
    private String password;

    public User() {
        super();
    }

    public User(String name, String email, @NotNull String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(Long id, boolean isActive, Date createDate, Date updateDate, String name, String email, @NotNull String password) {
        super(id, isActive, createDate, updateDate);
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
