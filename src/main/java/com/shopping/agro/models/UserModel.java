package com.shopping.agro.models;

import com.shopping.agro.entities.Authority;
import com.shopping.agro.entities.User;
import com.shopping.agro.entities.UserCredentials;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UserModel {

    private String firstName;
    private String lastName;
    private String emailid;
    private String username;
    private String password;
    private String roles;
    public UserModel(){

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailid='" + emailid + '\'' +
                ", username='" + username + '\'' +
                ", role='" + roles + '\'' +
                '}';
    }
    public User mapToEntity(){
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setEmailid(emailid);
        return user;
    }
    public UserCredentials mapToUserCredentialsEntity(){
        UserCredentials credentials = new UserCredentials();
        credentials.setUsername(username);
        credentials.setPassword(password);
        Set<Authority> roles = new HashSet<>();
        Authority authority = new Authority();
        authority.setAuthority(this.roles);
        roles.add(authority);
        credentials.setRoles(roles);
        return credentials;
    }
}
