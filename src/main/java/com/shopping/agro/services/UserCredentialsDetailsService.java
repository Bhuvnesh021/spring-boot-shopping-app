package com.shopping.agro.services;

import com.shopping.agro.userdetails.UserDetailsFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userCredentialsDetailsService")
public class UserCredentialsDetailsService implements UserDetailsService {
    @Autowired
    com.shopping.agro.services.UserDetails userDetails;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return UserDetailsFactory.getInstance().searchByUserName(s, userDetails);
    }
}
