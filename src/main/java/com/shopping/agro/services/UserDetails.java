package com.shopping.agro.services;

import com.shopping.agro.entities.Authority;
import com.shopping.agro.entities.User;
import com.shopping.agro.entities.UserCredentials;
import com.shopping.agro.models.UserModel;

import java.util.Optional;

public interface UserDetails {
    Optional<User> findByUserName(UserModel username);
    Optional<UserModel> findByUserName(String username);
    Optional<User> save(User user);
    Optional<UserCredentials> save(UserCredentials user);
    Optional<Authority> save(Authority user);

    void rollback(User user);
}
