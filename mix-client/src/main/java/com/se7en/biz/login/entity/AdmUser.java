package com.se7en.biz.login.entity;

public class AdmUser {
    private String username;
    private String password;
    private String token;
    private String phpId;

    public String getPhpId() {
        return phpId;
    }

    public AdmUser setPhpId(String phpId) {
        this.phpId = phpId;
        return this;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
