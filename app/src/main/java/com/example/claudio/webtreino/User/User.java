package com.example.claudio.webtreino.User;

/**
 * Created by claudio on 12/04/18.
 */

public class User {

    private  String Nome;
    private String Password;

    public User(){

    }

    public User(String name, String password){
        Nome = name;
        Password = password;
    }

    public String getName() {
        return Nome;
    }

    public void setName(String name) {
        Nome = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
