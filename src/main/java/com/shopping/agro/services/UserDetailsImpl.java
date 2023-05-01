package com.shopping.agro.services;

import com.shopping.agro.entities.Authority;
import com.shopping.agro.entities.User;
import com.shopping.agro.entities.UserCredentials;
import com.shopping.agro.models.UserModel;
import com.shopping.agro.repositories.AuthorityRepository;
import com.shopping.agro.repositories.UserCredentialsRepository;
import com.shopping.agro.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

@Service("userDetails")
public class UserDetailsImpl implements UserDetails{
    private static Logger logger = LoggerFactory.getLogger(UserDetailsImpl.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserCredentialsRepository credentialsRepository;
    @Autowired
    private AuthorityRepository authorityRepository;
    @Override
    public Optional<User> findByUserName(UserModel user) {
        Iterable<User> users = userRepository.findAll();
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            User iUser = iterator.next();
            logger.debug(iUser.toString());
            logger.debug(user.toString());
            if(iUser.getUsername().equalsIgnoreCase(user.getUsername()) || iUser.getEmailid().equalsIgnoreCase(user.getEmailid())){
                return Optional.of(iUser);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<UserModel> findByUserName(String username) {
        logger.debug("findByUserName called with : "+ username);
        Iterable<User> users = userRepository.findAll();
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            User iUser = iterator.next();
            if(iUser.getUsername().equalsIgnoreCase(username) ){
                UserModel model = iUser.mapToModel();
                Iterable<UserCredentials> all = credentialsRepository.findAll();
                Iterator<UserCredentials> credentialsIterator = all.iterator();
                while (credentialsIterator.hasNext()){
                    UserCredentials credentials = credentialsIterator.next();
                    if (model.getUsername().equalsIgnoreCase(credentials.getUsername())){
                        model.setPassword(credentials.getPassword());
                        Set<Authority> roles = credentials.getRoles();
                        for (Authority role : roles) {
                            logger.debug("role : "+ role.getAuthority());
                            model.setRoles(model.getRoles() == null ? "" + role.getAuthority() :  model.getRoles() + " " + role.getAuthority());
                        }
                        return Optional.of(model);
                    }
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> save(User user) {
        return Optional.of(userRepository.save(user));
    }

    @Override
    public Optional<UserCredentials> save(UserCredentials user) {
        return Optional.of(credentialsRepository.save(user));
    }

    @Override
    public Optional<Authority> save(Authority user) {
        return Optional.of(authorityRepository.save(user));
    }

    @Override
    public void rollback(User user) {
        userRepository.delete(user);
    }
}
