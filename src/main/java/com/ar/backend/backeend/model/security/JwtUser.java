package com.ar.backend.backeend.model.security;

public class JwtUser {
    private String username;
//    private long id;

    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

//    public void setId(long id) {
//        this.id = id;
//    }


    public JwtUser() {
    }

    public JwtUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

//    public long getId() {
//        return id;
//    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
