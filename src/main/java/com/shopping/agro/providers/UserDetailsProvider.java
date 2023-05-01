package com.shopping.agro.providers;

import com.shopping.agro.Constants;
import com.shopping.agro.models.UserCredentails;
import com.shopping.agro.models.UserModel;
import com.shopping.agro.services.UserDetails;
import com.shopping.agro.services.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Optional;

public class UserDetailsProvider {
    private static Logger logger = LoggerFactory.getLogger(UserDetailsProvider.class);


    public UserCredentails searchByUserName(String username, UserDetails userDetails) {
        // Connect to the database and try to find appropriate user.
        logger.debug("searchByUserName called with :" + username);
        UserCredentails userCredentails = new UserCredentails(username);
        Optional<UserModel> byUserName = userDetails.findByUserName(username);
        logger.debug(byUserName.toString());
        if (byUserName.isPresent()) {
            logger.debug(byUserName.get().toString());
            userCredentails.setAuthorities(Arrays.asList(new SimpleGrantedAuthority("ROLE_" + byUserName.get().getRoles())));
            userCredentails.setPassword(Constants.NO_OP_SECURITY + byUserName.get().getPassword());
            userCredentails.setEnabled(true);
            return userCredentails;
        } else {
            return userCredentails;
        }

    }
}
