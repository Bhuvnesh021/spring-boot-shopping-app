package com.shopping.agro.userdetails;

import com.shopping.agro.providers.UserDetailsProvider;

public class UserDetailsFactory {
    private static UserDetailsProvider provider = new UserDetailsProvider();
    private UserDetailsFactory(){

    }

    public static synchronized UserDetailsProvider getInstance(){
        return provider;
    }
}
