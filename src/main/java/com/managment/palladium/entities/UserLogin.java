package com.managment.palladium.entities;

import javax.persistence.*;

@Entity
public class UserLogin {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_login_seq")
    private long userId;

    private String username;
    private String email;
    private String password;
    private boolean enabled = true;

    public UserLogin() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
