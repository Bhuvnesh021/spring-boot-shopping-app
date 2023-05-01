package com.shopping.agro.entities;

import com.shopping.agro.models.UserModel;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "EMAIL_ID", nullable = false)
    private String emailid;
    @Column(name = "USER_NAME", nullable = false)
    private String username;

    @OneToOne
    private Cart cart;

    public User(){

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailid + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
    public UserModel mapToModel(){
        UserModel model = new UserModel();
        model.setFirstName(firstName);
        model.setLastName(lastName);
        model.setEmailid(emailid);
        model.setUsername(username);
        return model;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
