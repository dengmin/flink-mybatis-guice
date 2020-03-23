package com.baieapp.model;

import java.io.Serializable;

/**
 * @Author dengmin
 * @Created 2020/3/22 09:59
 */
public class User implements Serializable {

    public User(){}

    private Long id;
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}

